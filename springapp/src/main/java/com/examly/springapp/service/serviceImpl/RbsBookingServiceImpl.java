package com.examly.springapp.service.serviceImpl;


import com.examly.springapp.service.RbsBookingService;
import com.examly.springapp.repository.RbsBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.repository.RbsRoomRepository;
import com.examly.springapp.repository.RbsCustomerRepository;
import com.examly.springapp.repository.RbsPaymentRepository;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.RbsBooking;
import com.examly.springapp.model.RbsPayment;
import com.examly.springapp.model.RbsCustomer;
import com.examly.springapp.model.RbsRoom;
import com.examly.springapp.payload.RbsBookingDto;
import com.examly.springapp.payload.RbsPaymentDto;
import com.examly.springapp.payload.RbsRoomDto;
import com.examly.springapp.payload.RbsCustomerDto;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;
import org.springframework.stereotype.Service;



public class RbsBookingServiceImpl {
    
    @Override
    public RbsBookingDto updateBooking(RbsBookingDto bookingDto, Integer id) {
        RbsBooking booking = this.bookingRepo.findById(id)
                .orElseThrow();
        booking.setCheckInDate(bookingDto.getCheckInDate());
        booking.setCheckOutDate(bookingDto.getCheckOutDate());
        
        RbsBooking updatedBooking = this.bookingRepo.save(booking);
        return this.bookingToDto(updatedBooking);


    }


    @Override
    public RbsBookingDto getBookingById(Integer id) {
        RbsBooking booking = this.bookingRepo.findById(id).orElseThrow();
        return this.bookingToDto(booking);
    }


    
    @Override
    public List<RbsBookingDto> getAllBookings() {
        List<RbsBooking> bookings = this.bookingRepo.findAll();
        return bookings.stream().map(this::bookingToDto).collect(Collectors.toList());
    }


    @Override
    public void deleteBooking(Integer id) {
        RbsBooking booking = this.bookingRepo.findById(id).orElseThrow();
        this.bookingRepo.delete(booking);
    
    }
    @Override
    public RbsBookingDto createSingleBooking(RbsBookingDto bookingDto) {
        RbsBooking booking = this.dtoToBooking(bookingDto);
        RbsBooking savedBooking = this.bookingRepo.save(booking);
        return this.bookingToDto(savedBooking);
    }


    
    
    @Override
    public RbsPaymentDto createPayment(RbsPaymentDto paymentDto, Integer bookingId) {
        RbsBooking booking = this.bookingRepo.findById(bookingId).orElseThrow();
        RbsPayment payment = this.dtoToPayment(paymentDto);
        payment.setAmount(4000.0);
        payment.setPaymentStatus("success");
        payment.setPaymentDateTime(LocalDateTime.now());
        payment.setBooking(booking);
        RbsPayment savedPayment = this.paymentRepo.save(payment);
        return this.paymentToDto(savedPayment);
        
    }
    
    @Override
    public List<RbsPaymentDto> getAllPaymentsforSpecificBooking(Integer bookingId) {
        RbsBooking booking = this.bookingRepo.findById(bookingId).orElseThrow();
        List<RbsPayment> payments = this.paymentRepo.findByBooking(booking);
        return payments.stream().map(this::paymentToDto).collect(Collectors.toList());
        
    }
    private RbsPaymentDto paymentToDto(RbsPayment payment) {
        RbsPaymentDto paymentDto = new RbsPaymentDto();
        paymentDto.setPaymentId(payment.getPaymentId());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setPaymentDateTime(payment.getPaymentDateTime());
        paymentDto.setPaymentStatus(payment.getPaymentStatus());


        // Set the booking
        RbsBooking booking = payment.getBooking();
        if (booking != null) {
            RbsBookingDto bookingDto = new RbsBookingDto();
            bookingDto.setId(booking.getId());
            bookingDto.setCheckInDate(booking.getCheckInDate());
            bookingDto.setCheckOutDate(booking.getCheckOutDate());
       
            RbsCustomer customer = booking.getCustomer();
            if (customer != null) {
                RbsCustomerDto customerDto = new RbsCustomerDto();
                customerDto.setCustomerId(customer.getCustomerId());
                customerDto.setName(customer.getName());
                customerDto.setEmail(customer.getEmail());
                customerDto.setPhone(customer.getPhone());
                
                 bookingDto.setCustomer(customerDto);       
            }
            
            RbsRoom room = booking.getRoom();
            if(room != null) {
                RbsRoomDto roomDto = new RbsRoomDto();
                roomDto.setRoomId(room.getRoomId());
                roomDto.setRoomType(room.getRoomType());
                roomDto.setAvailable(room.isAvailable());
                roomDto.setCapacity(room.getCapacity());
                roomDto.setPricePerNight(room.getPricePerNight());
                
                bookingDto.setRoom(roomDto);
            }
            
            paymentDto.setBooking(bookingDto);
        }


        return paymentDto;
    }
    
    
    
}





