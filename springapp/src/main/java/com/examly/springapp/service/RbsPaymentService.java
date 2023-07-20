package com.examly.springapp.service;


import java.util.List;


import com.examly.springapp.payload.RbsPaymentDto;


public interface RbsPaymentService {


    
    
    RbsPaymentDto updatePayment(RbsPaymentDto payment, Integer paymentId);
    
    //can implement get payment by id if required
    RbsPaymentDto getPaymentById(Integer paymentId);
    
    
    
    void deletePayment(Integer paymentId);
    
    
    List<RbsPaymentDto> getAllPayments();
    
    //update payment for specific booking
    RbsPaymentDto updatePaymentForSpecificBooking(RbsPaymentDto payment, Integer bookingId);
    
    //delete payment for specific booking
    void deletePaymentForSpecificBooking(Integer bookingId, Integer paymentId);


    List<RbsPaymentDto> getAllPaymentsforSpecificBooking(Integer bookingId);


    RbsPaymentDto createPayment(RbsPaymentDto paymentDto, Integer bookingId);


    
    
    
    
    
    
}



