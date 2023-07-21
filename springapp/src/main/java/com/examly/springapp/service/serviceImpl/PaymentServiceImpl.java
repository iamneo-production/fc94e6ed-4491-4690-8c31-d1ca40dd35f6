package com.examly.springapp.service.serviceImpl;

import com.examly.springapp.repository.BookingRepository;
import com.examly.springapp.repository.PaymentRepository;
import com.examly.springapp.payload.PaymentDto;
import com.examly.springapp.payload.BookingDto;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Payment;
import java.util.stream.Collectors;
import com.examly.springapp.service.PaymentService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import com.examly.springapp.exception.ResourceNotFoundException;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
	private BookingRepository bookingRepo;

    @Autowired
	private PaymentRepository paymentRepo;

	@Override
	public PaymentDto createPayment(PaymentDto paymentDto, Integer id) {
		Booking booking = this.bookingRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Booking", "Booking id", id));
		Payment payment = this.dtoToPayment(paymentDto);
		payment.setAmount(paymentDto.getAmount());
		payment.setPaymentStatus("success");
		payment.setPaymentDateTime(LocalDateTime.now());
		payment.setBooking(booking);
		Payment savedPayment = this.paymentRepo.save(payment);
		return this.paymentToDto(savedPayment);
		
		
	}
	
	@Override
	public List<PaymentDto> getAllPaymentsforSpecificBooking(Integer id) {
		Booking booking = this.bookingRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("BookingId", "Booking Id", id));
		List<Payment> payments = this.paymentRepo.findByBooking(booking);
		List<PaymentDto> paymentDtos = payments.stream().map((payment)->this.paymentToDto(payment)).collect(Collectors.toList());
		return paymentDtos;
		
	}

    @Override
	public PaymentDto updatePaymentForSpecificBooking(PaymentDto paymentDto, Integer id) {
		Booking booking = bookingRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));
	    Payment payment = paymentRepo.findById(paymentDto.getPaymentId())
	            .orElseThrow(() -> new ResourceNotFoundException("Payment", "Payment id", paymentDto.getPaymentId()));

	    if (!payment.getBooking().equals(booking)) {
	        throw new IllegalArgumentException("Payment is not associated with the given booking");
	    }

	    // Update the payment details
	    payment.setAmount(paymentDto.getAmount());
	    payment.setPaymentDateTime(paymentDto.getPaymentDateTime());
	    payment.setPaymentStatus("success");

	    // Save the updated payment
	    Payment updatedPayment = paymentRepo.save(payment);
	    
        return paymentToDto(updatedPayment);
	    
        
	}

    @Override
	public void deletePaymentForSpecificBooking(Integer id, Integer paymentId) {
	    Booking booking = bookingRepo.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Booking", "id", id));
	    Payment payment = paymentRepo.findById(paymentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Payment", "Payment id", paymentId));

	    if (!payment.getBooking().equals(booking)) {
	        throw new IllegalArgumentException("Payment is not associated with the given booking");
	    }

	    paymentRepo.delete(payment);
	}
	
    private PaymentDto paymentToDto(Payment payment) {
	    PaymentDto paymentDto = new PaymentDto();
	    paymentDto.setPaymentId(payment.getPaymentId());
	    paymentDto.setAmount(payment.getAmount());
	    paymentDto.setPaymentDateTime(payment.getPaymentDateTime());
	    paymentDto.setPaymentStatus(payment.getPaymentStatus());

	    
	    Booking booking = payment.getBooking();
	    if (booking != null) {
	        BookingDto bookingDto = new BookingDto();
	        bookingDto.setId(booking.getId());
	        bookingDto.setCheckInDate(booking.getCheckInDate());
	        bookingDto.setCheckOutDate(booking.getCheckOutDate());
	        
	        
	       /* Customer customer = booking.getCustomer();
			if (customer != null) {
				CustomerDto customerDto = new CustomerDto();
				customerDto.setCustomerId(customer.getCustomerId());
				customerDto.setName(customer.getName());
				customerDto.setEmail(customer.getEmail());
				customerDto.setPhone(customer.getPhone());
				
				 bookingDto.setCustomer(customerDto);		
			}
			
			Room room = booking.getRoom();
			if(room != null) {
				RoomDto roomDto = new RoomDto();
				roomDto.setRoomId(room.getRoomId());
				roomDto.setRoomType(room.getRoomType());
				roomDto.setAvailable(room.isAvailable());
				roomDto.setCapacity(room.getCapacity());
				roomDto.setPricePerNight(room.getPricePerNight());
				
				bookingDto.setRoom(roomDto);
			}*/
		    
			paymentDto.setBooking(bookingDto);

	    }
	    
	    
	    return paymentDto;
	}

    private Payment dtoToPayment(PaymentDto paymentDto) {
	    Payment payment = new Payment();
	    payment.setPaymentId(paymentDto.getPaymentId());
	    payment.setAmount(paymentDto.getAmount());
	    payment.setPaymentDateTime(paymentDto.getPaymentDateTime());
	    payment.setPaymentStatus("success");

	    // Set the booking
	    BookingDto bookingDto = paymentDto.getBooking();
	    if (bookingDto != null) {
	        Booking booking = new Booking();
	        booking.setId(bookingDto.getId());
	        booking.setCheckInDate(bookingDto.getCheckInDate());
	        booking.setCheckOutDate(booking.getCheckOutDate());
	        
	       /* CustomerDto customerDto = bookingDto.getCustomer();
			if (customerDto != null) {
				Customer customer = new Customer();
				customer.setCustomerId(customerDto.getCustomerId());
				customer.setName(customerDto.getName());
				customer.setEmail(customerDto.getEmail());
				customer.setPhone(customerDto.getPhone());
				// Set other customer properties as needed
				booking.setCustomer(customer);
			}*/
			
			/*RoomDto roomDto = bookingDto.getRoom();
			if(roomDto != null) {
				Room room = new Room();
				room.setRoomId(roomDto.getRoomId());
				room.setRoomType(roomDto.getRoomType());
				room.setAvailable(room.isAvailable());
				room.setCapacity(roomDto.getCapacity());
				room.setPricePerNight(roomDto.getPricePerNight());
				
				booking.setRoom(room);
			}*/
			
			payment.setBooking(booking);
	    }
	    
	    return payment;
	}


	




    
}
