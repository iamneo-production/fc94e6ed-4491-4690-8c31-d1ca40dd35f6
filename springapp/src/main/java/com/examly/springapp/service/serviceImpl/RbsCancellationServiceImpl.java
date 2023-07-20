package com.examly.springapp.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.repository.RbsBookingRepository;
import com.examly.springapp.repository.RbsCancellationRepository;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.RbsBooking;
import com.examly.springapp.model.RbsCancellation;
import com.examly.springapp.model.RbsCustomer;
import com.examly.springapp.model.RbsRoom;
import com.examly.springapp.payload.RbsBookingDto;
import com.examly.springapp.payload.RbsCancellationDto;
import com.examly.springapp.payload.RbsCustomerDto;
import com.examly.springapp.payload.RbsRoomDto;
import com.examly.springapp.repository.RbsBookingRepository;
import com.examly.springapp.repository.RbsCancellationRepository;
import com.examly.springapp.service.RbsCancellationService;


@Service
public class RbsCancellationServiceImpl implements RbsCancellationService{
	
	@Autowired
	private RbsCancellationRepository cancellationRepo;
	
	/*@Autowired
	private ModelMapper modelMapper;*/
	
	@Autowired
	private RbsBookingRepository bookingRepo;

	@Override
	public RbsCancellationDto createCancellation(RbsCancellationDto cancellationDto, Integer bookingId) {
		RbsBooking booking = this.bookingRepo.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("Booking", "Booking id", bookingId));
		RbsCancellation cancellation = this.dtoToCancellation(cancellationDto);
		cancellation.setDateCancelled(new Date());
		cancellation.setReason(cancellationDto.getReason());
		
		cancellation.setBooking(booking);
		RbsCancellation savedCancellation = this.cancellationRepo.save(cancellation);
		return this.cancellationToDto(savedCancellation);
		
	}
	
	
	@Override
	public List<RbsCancellationDto> getAllCancellationsforSpecificBooking(Integer bookingId) {
		RbsBooking booking = this.bookingRepo.findById(bookingId).orElseThrow(()->new ResourceNotFoundException("BookingId", "Booking Id", bookingId));
		List<RbsCancellation> cancellations = this.cancellationRepo.findByBooking(booking);
		List<RbsCancellationDto> cancellationDtos = cancellations.stream().map((cancellation)->this.cancellationToDto(cancellation)).collect(Collectors.toList());
		return cancellationDtos;
	}
	
	@Override
    public List<RbsCancellationDto> getAllCancellations() {
        List<RbsCancellation> cancellations = this.cancellationRepo.findAll();
        List<RbsCancellationDto> cancellationDtos = cancellations.stream()
                .map(this::cancellationToDto)
                .collect(Collectors.toList());
        return cancellationDtos;
    }
	
	
	/*private Cancellation dtoToCancellation(CancellationDto cancellationDto) {
		Cancellation cancellation = this.modelMapper.map(cancellationDto, Cancellation.class);
		return cancellation;
		
	}

	private CancellationDto cancellationToDto(Cancellation cancellation) {
		CancellationDto cancellationDto = this.modelMapper.map(cancellation, CancellationDto.class);
		return cancellationDto;
	}*/
	
	private RbsCancellation dtoToCancellation(RbsCancellationDto cancellationDto) {
		RbsCancellation cancellation = new RbsCancellation();
		cancellation.setCancellationId(cancellationDto.getCancellationId());
		cancellation.setDateCancelled(cancellationDto.getDateCancelled());
		cancellation.setReason(cancellationDto.getReason());
		
		// Map other properties as needed
		RbsBookingDto bookingDto = cancellationDto.getBooking();
	    if (bookingDto != null) {
	        RbsBooking booking = new RbsBooking();
	        booking.setId(bookingDto.getId());
	        booking.setCheckInDate(bookingDto.getCheckInDate());
	        booking.setCheckOutDate(bookingDto.getCheckOutDate());
	        
	        RbsCustomerDto customerDto = bookingDto.getCustomer();
			if (customerDto != null) {
				RbsCustomer customer = new RbsCustomer();
				customer.setCustomerId(customerDto.getCustomerId());
				customer.setName(customerDto.getName());
				customer.setEmail(customerDto.getEmail());
				customer.setPhone(customerDto.getPhone());
				// Set other customer properties as needed
				booking.setCustomer(customer);
			}
			
			RbsRoomDto roomDto = bookingDto.getRoom();
			if(roomDto != null) {
				RbsRoom room = new RbsRoom();
				room.setRoomId(roomDto.getRoomId());
				room.setRoomType(roomDto.getRoomType());
				room.setAvailable(room.isAvailable());
				room.setCapacity(roomDto.getCapacity());
				room.setPricePerNight(roomDto.getPricePerNight());
				
				booking.setRoom(room);
			}
			
			cancellation.setBooking(booking);
	    }

		return cancellation;
	}

	private RbsCancellationDto cancellationToDto(RbsCancellation cancellation) {
		RbsCancellationDto cancellationDto = new RbsCancellationDto();
		cancellationDto.setCancellationId(cancellation.getCancellationId());
		cancellationDto.setDateCancelled(cancellation.getDateCancelled());
		cancellationDto.setReason(cancellation.getReason());
		
		RbsBooking booking = cancellation.getBooking();
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
		    
			cancellationDto.setBooking(bookingDto);
	    }

		// Map other properties as needed
		return cancellationDto;
	}
	
	

	@Override
	public RbsCancellationDto updateCancellatin(RbsCancellationDto cancellation, Integer cancellationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RbsCancellationDto getCancellationById(Integer cancellationId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void deleteCancellation(Integer cancellationId) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
