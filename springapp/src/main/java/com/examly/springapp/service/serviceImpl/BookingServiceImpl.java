package com.examly.springapp.service.serviceImpl;

import java.util.stream.Collectors;
import com.examly.springapp.payload.BookingDto;
import com.examly.springapp.payload.PaymentDto;
import com.examly.springapp.model.Payment;
import com.examly.springapp.model.Booking;
import com.examly.springapp.model.Cancellation;
import com.examly.springapp.repository.BookingRepository;
import com.examly.springapp.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import com.examly.springapp.service.BookingService;
import com.examly.springapp.exception.ResourceNotFoundException;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private PaymentRepository paymentRepo;



    @Override
    public BookingDto createSingleBooking(BookingDto bookingDto) {
        Booking booking = this.dtoToBooking(bookingDto);
        Booking savedBooking = this.bookingRepo.save(booking);
        return this.bookingToDto(savedBooking);
    }

    @Override
	public BookingDto updateBooking(BookingDto bookingDto, Integer id) {
		Booking booking = this.bookingRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Booking", "Id", id));
                if (bookingDto.getCheckInDate() != null) {
                    booking.setCheckInDate(bookingDto.getCheckInDate());
                }
                if (bookingDto.getCheckOutDate() != null) {
                    booking.setCheckOutDate(bookingDto.getCheckOutDate());
                }
		
		Booking updatedBooking = this.bookingRepo.save(booking);
        return this.bookingToDto(updatedBooking);
	}

	@Override
	public BookingDto getBookingById(Integer id) {
		Booking booking = this.bookingRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Booking", "Id", id));
		return this.bookingToDto(booking);
	}

	
	@Override
	public List<BookingDto> getAllBookings() {
		List<Booking> bookings = this.bookingRepo.findAll();
		List<BookingDto> bookingDtos = bookings.stream().map(booking -> this.bookingToDto(booking)).collect(Collectors.toList());
		
		return bookingDtos;
	}

	@Override
	public void deleteBooking(Integer id) {
		Booking booking = this.bookingRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Booking", "Id", id));
		this.bookingRepo.delete(booking);
	
	}

    private PaymentDto paymentToDto(Payment payment) {
	    PaymentDto paymentDto = new PaymentDto();
	    paymentDto.setPaymentId(payment.getPaymentId());
	    paymentDto.setAmount(payment.getAmount());
	    paymentDto.setPaymentDateTime(payment.getPaymentDateTime());
	    paymentDto.setPaymentStatus(payment.getPaymentStatus());

	    // Set the booking
	    Booking booking = payment.getBooking();
	    if (booking != null) {
	        BookingDto bookingDto = new BookingDto();
	        bookingDto.setId(booking.getId());
	        bookingDto.setCheckInDate(booking.getCheckInDate());
	        bookingDto.setCheckOutDate(booking.getCheckOutDate());
	   
	        /*Customer customer = booking.getCustomer();
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
			}
			
			/*Cancellation cancellation = (Cancellation) booking.getCancellations();
			if(cancellation != null) {
				CancellationDto cancellationDto = new CancellationDto();
				cancellationDto.setCancellationId(cancellation.getCancellationId());
				cancellationDto.setDateCancelled(cancellation.getDateCancelled());
				cancellationDto.setReason(cancellation.getReason());
				
				bookingDto.setCancellation(cancellationDto);
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
	    payment.setPaymentStatus(paymentDto.getPaymentStatus());

	    // Set the booking
	    BookingDto bookingDto = paymentDto.getBooking();
	    if (bookingDto != null) {
	        Booking booking = new Booking();
	        booking.setId(bookingDto.getId());
	        booking.setCheckInDate(bookingDto.getCheckInDate());
	        booking.setCheckOutDate(bookingDto.getCheckOutDate());
	        
	       /* CustomerDto customerDto = bookingDto.getCustomer();
			if (customerDto != null) {
				Customer customer = new Customer();
				customer.setCustomerId(customerDto.getCustomerId());
				customer.setName(customerDto.getName());
				customer.setEmail(customerDto.getEmail());
				customer.setPhone(customerDto.getPhone());
				// Set other customer properties as needed
				booking.setCustomer(customer);
			}
			
			RoomDto roomDto = bookingDto.getRoom();
			if(roomDto != null) {
				Room room = new Room();
				room.setRoomId(roomDto.getRoomId());
				room.setRoomType(roomDto.getRoomType());
				room.setAvailable(room.isAvailable());
				room.setCapacity(roomDto.getCapacity());
				room.setPricePerNight(roomDto.getPricePerNight());
				
				booking.setRoom(room);
			}
			
			CancellationDto cancellationDto = bookingDto.getCancellation();
			if(cancellationDto!=null) {
				Cancellation cancellation = new Cancellation();
				cancellation.setCancellationId(cancellationDto.getCancellationId());
				cancellation.setDateCancelled(cancellationDto.getDateCancelled());
				cancellation.setReason(cancellationDto.getReason());
				
				booking.setCancellation(cancellation);
			}*/
			
			
	        payment.setBooking(booking);
	    }

	    return payment;
	}

    private BookingDto bookingToDto(Booking booking) {
		BookingDto bookingDto = new BookingDto();
		bookingDto.setId(booking.getId());
		bookingDto.setCheckInDate(booking.getCheckInDate());
		bookingDto.setCheckOutDate(booking.getCheckOutDate());

		// Set the customer
		/*Customer customer = booking.getCustomer();
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
		
		Payment payment = booking.getPayment();
		if(payment != null) {
			PaymentDto paymentDto = new PaymentDto();
			paymentDto.setPaymentId(payment.getPaymentId());
			paymentDto.setAmount(payment.getAmount());
			paymentDto.setPaymentDateTime(payment.getPaymentDateTime());
			paymentDto.setPaymentStatus(payment.getPaymentStatus());
			
			bookingDto.setPayment(paymentDto);
			
		}
		/*Cancellation cancellation = booking.getCancellation();
	    if (cancellation != null) {
	        CancellationDto cancellationDto = new CancellationDto();
	        cancellationDto.setCancellationId(cancellation.getCancellationId());
	        cancellationDto.setDateCancelled(cancellation.getDateCancelled());
	        cancellationDto.setReason(cancellation.getReason());
	        bookingDto.setCancellation(cancellationDto);
	    }*/
	    

		return bookingDto;
	}

    private Booking dtoToBooking(BookingDto bookingDto) {
		Booking booking = new Booking();
		booking.setId(bookingDto.getId());
		booking.setCheckInDate(bookingDto.getCheckInDate());
		booking.setCheckOutDate(bookingDto.getCheckOutDate());

		// Set the customer
		/*CustomerDto customerDto = bookingDto.getCustomer();
		if (customerDto != null) {
			Customer customer = new Customer();
			customer.setCustomerId(customerDto.getCustomerId());
			customer.setName(customerDto.getName());
			customer.setEmail(customerDto.getEmail());
			customer.setPhone(customerDto.getPhone());
			// Set other customer properties as needed
			booking.setCustomer(customer);
		}
		
		RoomDto roomDto = bookingDto.getRoom();
		if(roomDto != null) {
			Room room = new Room();
			room.setRoomId(roomDto.getRoomId());
			room.setRoomType(roomDto.getRoomType());
			room.setAvailable(room.isAvailable());
			room.setCapacity(roomDto.getCapacity());
			room.setPricePerNight(roomDto.getPricePerNight());
			
			booking.setRoom(room);
		}*/
		
		PaymentDto paymentDto = bookingDto.getPayment();
		if(paymentDto != null) {
			Payment payment = new Payment();
			payment.setPaymentId(paymentDto.getPaymentId());
			payment.setAmount(paymentDto.getAmount());
			payment.setPaymentDateTime(paymentDto.getPaymentDateTime());
			payment.setPaymentStatus(paymentDto.getPaymentStatus());
			
			booking.setPayment(payment);
			
		}
		/*CancellationDto cancellationDto = bookingDto.getCancellation();
		if(cancellationDto!=null) {
			Cancellation cancellation = new Cancellation();
			cancellation.setCancellationId(cancellationDto.getCancellationId());
			cancellation.setDateCancelled(cancellationDto.getDateCancelled());
			cancellation.setReason(cancellationDto.getReason());
			
			booking.setCancellation(cancellation);
		}*/

		return booking;
	}
	
    
}
