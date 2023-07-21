package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.examly.springapp.service.BookingService;
import com.examly.springapp.service.PaymentService;
import com.examly.springapp.payload.BookingDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.examly.springapp.payload.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/bookings")
public class BookingController {
    /*private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public Booking getBookingById(@PathVariable int bookingId) {
        return bookingService.getBookingById(bookingId);
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{bookingId}")
    public Booking updateBooking(@PathVariable int bookingId, @RequestBody Booking booking) {
        return bookingService.updateBooking(bookingId, booking);
    }

    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable int bookingId) {
        bookingService.deleteBooking(bookingId);
    }

   @GetMapping("/{bookingId}/payments")
    public List<Payment> getAllPaymentsForBooking(@PathVariable int bookingId) {
        return bookingService.getAllPaymentsForBooking(bookingId);
    }

    @PostMapping("/{bookingId}/payments")
    public Payment createPaymentForBooking(@PathVariable int bookingId, @RequestBody Payment payment) {
        return bookingService.createPaymentForBooking(bookingId, payment);
    }

    @PutMapping("/{bookingId}/payments/{paymentId}")
    public Payment updatePaymentForBooking(
            @PathVariable int bookingId, @PathVariable int paymentId, @RequestBody Payment payment) {
        return bookingService.updatePaymentForBooking(bookingId, paymentId, payment);
    }

    @DeleteMapping("/{bookingId}/payments/{paymentId}")
    public void deletePaymentForBooking(@PathVariable int bookingId, @PathVariable int paymentId) {
        bookingService.deletePaymentForBooking(bookingId, paymentId);
    }

    @GetMapping("/{bookingId}/cancellations")
    public List<Cancellation> getAllCancellationsForBooking(@PathVariable int bookingId) {
        return bookingService.getAllCancellationsForBooking(bookingId);
    }

    @PostMapping("/{bookingId}/cancellations")
    public Cancellation createCancellationForBooking(
            @PathVariable int bookingId, @RequestBody Cancellation cancellation) {
        return bookingService.createCancellationForBooking(bookingId, cancellation);
    }

    @PutMapping("/{bookingId}/cancellations/{cancellationId}")
    public Cancellation updateCancellationForBooking(
            @PathVariable int bookingId, @PathVariable int cancellationId, @RequestBody Cancellation cancellation) {
        return bookingService.updateCancellationForBooking(bookingId, cancellationId, cancellation);
    }

    @DeleteMapping("/{bookingId}/cancellations/{cancellationId}")
    public void deleteCancellationForBooking(@PathVariable int bookingId, @PathVariable int cancellationId) {
        bookingService.deleteCancellationForBooking(bookingId, cancellationId);
    }*/

    @Autowired
	private BookingService bookingService;
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping
	public ResponseEntity<BookingDto> createSingleBooking(@RequestBody BookingDto bookingDto){
		BookingDto createBookingDto = this.bookingService.createSingleBooking(bookingDto);
		return new ResponseEntity<>(createBookingDto, HttpStatus.CREATED);
		
	}
	
	
	/*@PostMapping("/customers/{customerId}/bookings")
	public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto, @PathVariable Integer customerId){
		BookingDto createBookingDto = this.bookingService.createBooking(bookingDto, customerId);
		 Date checkInDate = bookingDto.getCheckInDate();
	     Date checkOutDate = bookingDto.getCheckOutDate();
		return new ResponseEntity<BookingDto>(createBookingDto, HttpStatus.CREATED);
		
	}
	
	// get all bookings for a specific customer
	@GetMapping("customers/{customerId}/bookings")
	public ResponseEntity<List<BookingDto>>getBookingsByCustomer(@PathVariable Integer customerId){
		List<BookingDto> bookings = this.bookingService.getBookingsByCustomer(customerId);
		return new ResponseEntity<List<BookingDto>>(bookings, HttpStatus.OK);
		
		
	}
	
	@PostMapping("customers/{customerId}/rooms/{roomId}/bookings")
	public ResponseEntity<BookingDto> createBookingForRoom(@RequestBody BookingDto bookingDto, @PathVariable Integer roomId, @PathVariable Integer customerId){
		BookingDto createBookingDto = this.bookingService.createBookingForRoom(bookingDto, roomId, customerId);
		 //Date checkInDate = bookingDto.getCheckInDate();
	     //Date checkOutDate = bookingDto.getCheckOutDate();
		return new ResponseEntity<BookingDto>(createBookingDto, HttpStatus.CREATED);
	}
	
	
	//get all bookings for a specific room
	@GetMapping("customers/{customerId}/rooms/{roomId}/bookings")
	public ResponseEntity<List<BookingDto>> findByCustomerCustomerIdAndRoomRoomId(@PathVariable Integer roomId, @PathVariable Integer customerId){
		List<BookingDto> bookings = this.bookingService.findByCustomerCustomerIdAndRoomRoomId(roomId, customerId);
		
		return new ResponseEntity<List<BookingDto>>(bookings, HttpStatus.OK);
	}	
	
	
	@PutMapping("/customers/{customerId}/rooms/{roomId}/bookings/{id}")
	public ResponseEntity<BookingDto> updateBookingForCustomerAndRoom(
	        @RequestBody BookingDto bookingDto,
	        @PathVariable Integer customerId,
	        @PathVariable Integer roomId,
	        @PathVariable Integer id) {

	    BookingDto updatedBooking = bookingService.updateBookingForCustomerAndRoom(
	            bookingDto, customerId, roomId, id);

	    return ResponseEntity.ok(updatedBooking);
	}
	
	@DeleteMapping("/customers/{customerId}/rooms/{roomId}/bookings/{bookingId}")
	public ResponseEntity<ApiResponse> deleteBookingForCustomerAndRoom(@PathVariable Integer customerId, @PathVariable Integer roomId, @PathVariable Integer bookingId) {
	    this.bookingService.deleteBookingForCustomerAndRoom(customerId, roomId, bookingId);
	    return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
	}*/
	
	
	@PutMapping("/{id}")
	public ResponseEntity<BookingDto> updateBooking(
			@RequestBody BookingDto bookingDto, 
			@PathVariable Integer id){
		
		BookingDto updatedBooking = this.bookingService.updateBooking(bookingDto, id);
		return ResponseEntity.ok(updatedBooking);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteBooking(@PathVariable ("id") Integer bid){
			this.bookingService.deleteBooking(bid);
			return new ResponseEntity<ApiResponse>(new ApiResponse(), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<BookingDto>> getAllBookings(){
		return ResponseEntity.ok(this.bookingService.getAllBookings());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookingDto> getSingleBooking(@PathVariable Integer id){
		return ResponseEntity.ok(this.bookingService.getBookingById(id));
	}
	
	
	
	/*@PostMapping("/{bookingId}/payments")
	public ResponseEntity<PaymentDto> createPayment(@RequestBody PaymentDto paymentDto, @PathVariable Integer id){
		PaymentDto createPaymentDto = this.paymentService.createPayment(paymentDto, id);
		return new ResponseEntity<PaymentDto>(createPaymentDto, HttpStatus.CREATED);
	}
	
	//get payments for specific booking
	
	@GetMapping("/{id}/payments")
	public ResponseEntity<List<PaymentDto>>getAllPaymentsforSpecificBooking(@PathVariable Integer id){
		List<PaymentDto> payments = this.paymentService.getAllPaymentsforSpecificBooking(id);
		return new ResponseEntity<List<PaymentDto>>(payments, HttpStatus.OK);
		
	}*/
	
	
}
