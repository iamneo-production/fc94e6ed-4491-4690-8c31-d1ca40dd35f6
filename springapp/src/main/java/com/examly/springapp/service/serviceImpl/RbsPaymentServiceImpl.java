package com.examly.springapp.service.serviceImpl;


import com.examly.springapp.service.RbsPaymentService;
import org.springframework.stereotype.Service;
import com.examly.springapp.repository.RbsBookingRepository;


import org.springframework.beans.factory.annotation.Autowired;


import com.examly.springapp.repository.RbsPaymentRepository;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.RbsBooking;
import com.examly.springapp.model.RbsPayment;


import com.examly.springapp.payload.RbsBookingDto;
import com.examly.springapp.payload.RbsPaymentDto;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class RbsPaymentServiceImpl implements RbsPaymentService{


    @Autowired
    private RbsPaymentRepository paymentRepo;
    
    
    @Autowired
    private RbsBookingRepository bookingRepo;


    @Override
    public RbsPaymentDto createPayment(RbsPaymentDto paymentDto, Integer id) {
        RbsBooking booking = this.bookingRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking", "Booking id", id));
        RbsPayment payment = this.dtoToPayment(paymentDto);
        //payment.setAmount(4000.0);
        //payment.setPaymentStatus();
        payment.setPaymentDateTime(LocalDateTime.now());
        payment.setBooking(booking);
        RbsPayment savedPayment = this.paymentRepo.save(payment);
        return this.paymentToDto(savedPayment);
        
        
    }
    
    @Override
    public List<RbsPaymentDto> getAllPaymentsforSpecificBooking(Integer id) {
        RbsBooking booking = this.bookingRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("BookingId", "Booking Id", id));
        List<RbsPayment> payments = this.paymentRepo.findByBooking(booking);
        List<RbsPaymentDto> paymentDtos = payments.stream().map((payment)->this.paymentToDto(payment)).collect(Collectors.toList());
        return paymentDtos;
        
    }
    
    //update payment for specific booking
    @Override
    public RbsPaymentDto updatePaymentForSpecificBooking(RbsPaymentDto paymentDto, Integer id) {
        RbsBooking booking = bookingRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));
        RbsPayment payment = paymentRepo.findById(paymentDto.getPaymentId())
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "Payment id", paymentDto.getPaymentId()));


        if (!payment.getBooking().equals(booking)) {
            throw new IllegalArgumentException("Payment is not associated with the given booking");
        }


        // Update the payment details
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentDateTime(paymentDto.getPaymentDateTime());
        payment.setPaymentStatus(paymentDto.getPaymentStatus());


        // Save the updated payment
        RbsPayment updatedPayment = paymentRepo.save(payment);
        
        return paymentToDto(updatedPayment);
        
        
    }
    
    //delete payment for specific booking
    @Override
    public void deletePaymentForSpecificBooking(Integer id, Integer paymentId) {
        RbsBooking booking = bookingRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));
        RbsPayment payment = paymentRepo.findById(paymentId)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "Payment id", paymentId));


        if (!payment.getBooking().equals(booking)) {
            throw new IllegalArgumentException("Payment is not associated with the given booking");
        }


        paymentRepo.delete(payment);
    }


    @Override
    public RbsPaymentDto getPaymentById(Integer paymentId) {
        RbsPayment payment = this.paymentRepo.findById(paymentId).orElseThrow(()-> new ResourceNotFoundException("Payment", "payment id", paymentId));
        return this.paymentToDto(payment);
        
    }


    @Override
    public List<RbsPaymentDto> getAllPayments() {
        List<RbsPayment> allPayments = this.paymentRepo.findAll();
        List<RbsPaymentDto> paymentDtos = allPayments.stream().map((payment)-> this.paymentToDto(payment)).collect(Collectors.toList());
        return paymentDtos;
        
    }
    
    @Override
    public RbsPaymentDto updatePayment(RbsPaymentDto payment, Integer paymentId) {
        
        return null;
    }


    @Override
    public void deletePayment(Integer paymentId) {
        RbsPayment payment = this.paymentRepo.findById(paymentId).orElseThrow(()-> new ResourceNotFoundException("Payment", "Id", paymentId));
        this.paymentRepo.delete(payment);
        
        
    }
    
    
    
    private RbsPaymentDto paymentToDto(RbsPayment payment) {
        RbsPaymentDto paymentDto = new RbsPaymentDto();
        paymentDto.setPaymentId(payment.getPaymentId());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setPaymentDateTime(payment.getPaymentDateTime());
        paymentDto.setPaymentStatus(payment.getPaymentStatus());


        
        RbsBooking booking = payment.getBooking();
        if (booking != null) {
            RbsBookingDto bookingDto = new RbsBookingDto();
            bookingDto.setId(booking.getId());
            bookingDto.setCheckInDate(booking.getCheckInDate());
            bookingDto.setCheckOutDate(booking.getCheckOutDate());
            
            
            
            paymentDto.setBooking(bookingDto);


        }
        
        
        return paymentDto;
    }


    private RbsPayment dtoToPayment(RbsPaymentDto paymentDto) {
        RbsPayment payment = new RbsPayment();
        payment.setPaymentId(paymentDto.getPaymentId());
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentDateTime(paymentDto.getPaymentDateTime());
        payment.setPaymentStatus(paymentDto.getPaymentStatus());


        // Set the booking
        RbsBookingDto bookingDto = paymentDto.getBooking();
        if (bookingDto != null) {
            RbsBooking booking = new RbsBooking();
            booking.setId(bookingDto.getId());
            booking.setCheckInDate(bookingDto.getCheckInDate());
            booking.setCheckOutDate(booking.getCheckOutDate());
            
           
            
            payment.setBooking(booking);
        }
        
        return payment;
    }


    
}



