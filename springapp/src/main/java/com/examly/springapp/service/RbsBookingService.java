package com.examly.springapp.service;
import com.examly.springapp.payload.RbsBookingDto;
import java.util.List;
import com.examly.springapp.model.RbsBooking;
import com.examly.springapp.payload.RbsPaymentDto;


public interface RbsBookingService {


    RbsBookingDto createBooking(RbsBookingDto booking, Integer customerId);
    
    RbsBookingDto updateBooking(RbsBookingDto booking, Integer id);
    
    RbsBookingDto getBookingById(Integer id);
    
    List<RbsBookingDto> getAllBookings();
    
    void deleteBooking(Integer id);
    
    //get all bookings by customer
    List<RbsBookingDto> getBookingsByCustomer(Integer customerId);
    
    //search bookings
    List<RbsBooking> searchBookings(String keyword);


    List<RbsBookingDto> findByCustomerCustomerIdAndRoomRoomId(Integer roomId, Integer customerId);


    RbsBookingDto createBookingForRoom(RbsBookingDto bookingDto, Integer roomId, Integer customerId);


    RbsBookingDto updateBookingForCustomerAndRoom(RbsBookingDto bookingDto, Integer customerId, Integer roomId, Integer id);


    RbsBookingDto createSingleBooking(RbsBookingDto booking);


    RbsPaymentDto createPayment(RbsPaymentDto paymentDto, Integer bookingId);


    List<RbsPaymentDto> getAllPaymentsforSpecificBooking(Integer bookingId);
    
}



