package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.payload.RbsCancellationDto;
import com.examly.springapp.service.RbsCancellationService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class RbsCancellationController {
	
	@Autowired
	private RbsCancellationService cancellationService;
	
	@PostMapping("/bookings/{bookingId}/cancellations")
	public ResponseEntity<RbsCancellationDto> createCancellation(@RequestBody RbsCancellationDto cancellationDto, @PathVariable Integer bookingId){
		RbsCancellationDto createCancellationDto = this.cancellationService.createCancellation(cancellationDto, bookingId);
		return new ResponseEntity<RbsCancellationDto>(createCancellationDto, HttpStatus.CREATED);
	}
	
	//get cancellations for specific booking
	
	@GetMapping("bookings/{bookingId}/cancellations")
	public ResponseEntity<List<RbsCancellationDto>>getAllCancellationsforSpecificBooking(@PathVariable Integer bookingId){
		List<RbsCancellationDto> cancellations = this.cancellationService.getAllCancellationsforSpecificBooking(bookingId);
		return new ResponseEntity<List<RbsCancellationDto>>(cancellations, HttpStatus.OK);
		
	}
	
	@GetMapping("/cancellations")
    public ResponseEntity<List<RbsCancellationDto>> getAllCancellations() {
        List<RbsCancellationDto> cancellations = this.cancellationService.getAllCancellations();
        return new ResponseEntity<>(cancellations, HttpStatus.OK);
    }
	

}
