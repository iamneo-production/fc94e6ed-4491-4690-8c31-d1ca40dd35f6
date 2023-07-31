package com.examly.springapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Date;
import com.examly.springapp.payload.ApiResponse;
import com.examly.springapp.service.RbsBookingService;
import com.examly.springapp.service.RbsPaymentService;
import com.examly.springapp.payload.RbsBookingDto;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("api/v1/")
public class RbsBookingController {

	@Autowired
    private RbsBookingService bookingService;


    @Autowired
	private RbsPaymentService paymentService;
	
	
	@PostMapping
	public ResponseEntity<RbsBookingDto> createSingleBooking(@RequestBody RbsBookingDto bookingDto){
		RbsBookingDto createBookingDto = this.bookingService.createSingleBooking(bookingDto);
		return new ResponseEntity<>(createBookingDto, HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("/customers/{customerId}/bookings")
	public ResponseEntity<RbsBookingDto> createBooking(@RequestBody RbsBookingDto bookingDto, @PathVariable Integer customerId){
		RbsBookingDto createBookingDto = this.bookingService.createBooking(bookingDto, customerId);
		 Date checkInDate = bookingDto.getCheckInDate();
	     Date checkOutDate = bookingDto.getCheckOutDate();
		return new ResponseEntity<RbsBookingDto>(createBookingDto, HttpStatus.CREATED);
		
	}
	
	// get all bookings for a specific customer
	@GetMapping("customers/{customerId}/bookings")
	public ResponseEntity<List<RbsBookingDto>>getBookingsByCustomer(@PathVariable Integer customerId){
		List<RbsBookingDto> bookings = this.bookingService.getBookingsByCustomer(customerId);
		return new ResponseEntity<List<RbsBookingDto>>(bookings, HttpStatus.OK);
		
		
	}
	
	@PostMapping("customers/{customerId}/rooms/{roomId}/bookings")
	public ResponseEntity<RbsBookingDto> createBookingForRoom(@RequestBody RbsBookingDto bookingDto, @PathVariable Integer roomId, @PathVariable Integer customerId){
		RbsBookingDto createBookingDto = this.bookingService.createBookingForRoom(bookingDto, roomId, customerId);
		 //Date checkInDate = bookingDto.getCheckInDate();
	     //Date checkOutDate = bookingDto.getCheckOutDate();
		return new ResponseEntity<RbsBookingDto>(createBookingDto, HttpStatus.CREATED);
	}
	
	
	//get all bookings for a specific room
	@GetMapping("customers/{customerId}/rooms/{roomId}/bookings")
	public ResponseEntity<List<RbsBookingDto>> findByCustomerCustomerIdAndRoomRoomId(@PathVariable Integer roomId, @PathVariable Integer customerId){
		List<RbsBookingDto> bookings = this.bookingService.findByCustomerCustomerIdAndRoomRoomId(roomId, customerId);
		
		return new ResponseEntity<List<RbsBookingDto>>(bookings, HttpStatus.OK);
	}	
	
	
	@PutMapping("/customers/{customerId}/rooms/{roomId}/bookings/{id}")
	public ResponseEntity<RbsBookingDto> updateBookingForCustomerAndRoom(
	        @RequestBody RbsBookingDto bookingDto,
	        @PathVariable Integer customerId,
	        @PathVariable Integer roomId,
	        @PathVariable Integer id) {

	    RbsBookingDto updatedBooking = bookingService.updateBookingForCustomerAndRoom(
	            bookingDto, customerId, roomId, id);

	    return ResponseEntity.ok(updatedBooking);
	}
	
	/*@DeleteMapping("/customers/{customerId}/rooms/{roomId}/bookings/{bookingId}")
	public ResponseEntity<ApiResponse> deleteBookingForCustomerAndRoom(@PathVariable Integer customerId, @PathVariable Integer roomId, @PathVariable Integer bookingId) {
	    this.bookingService.deleteBookingForCustomerAndRoom(customerId, roomId, bookingId);
	    return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
	}*/
	
	
	

    @PutMapping("/{id}")
    public ResponseEntity<RbsBookingDto> updateBooking(
            @RequestBody RbsBookingDto bookingDto, 
            @PathVariable Integer id){
        
        RbsBookingDto updatedBooking = this.bookingService.updateBooking(bookingDto, id);
        return ResponseEntity.ok(updatedBooking);
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteBooking(@PathVariable ("id") Integer bid){
            this.bookingService.deleteBooking(bid);
            return new ResponseEntity<>(new ApiResponse(), HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<RbsBookingDto>> getAllBookings(){
        return ResponseEntity.ok(this.bookingService.getAllBookings());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<RbsBookingDto> getSingleBooking(@PathVariable Integer id){
        return ResponseEntity.ok(this.bookingService.getBookingById(id));
    }
    
    
}




    
