package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.payload.RbsCancellationDto;

public interface RbsCancellationService {
	
	RbsCancellationDto createCancellation(RbsCancellationDto cancellation, Integer bookingId);
	
	RbsCancellationDto updateCancellatin(RbsCancellationDto cancellation, Integer cancellationId);
	
	RbsCancellationDto getCancellationById(Integer cancellationId);
	
	List<RbsCancellationDto> getAllCancellations();
	
	void deleteCancellation(Integer cancellationId);
	
	List<RbsCancellationDto> getAllCancellationsforSpecificBooking(Integer bookingId);
	
	
}