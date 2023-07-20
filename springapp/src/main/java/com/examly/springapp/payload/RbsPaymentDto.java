package com.examly.springapp.payload;


import java.time.LocalDateTime;


public class RbsPaymentDto {


    private int paymentId;
    private double amount;
    private LocalDateTime paymentDateTime;
    private String paymentStatus;
    
    private RbsBookingDto booking;
    
    
    public RbsBookingDto getBooking() {
        return booking;
    }


    public void setBooking(RbsBookingDto booking) {
        this.booking = booking;
    }


    public RbsPaymentDto() {
        super();
        
    }
    
    
    public RbsPaymentDto(int paymentId, double amount, LocalDateTime paymentDateTime, String paymentStatus) {
        super();
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDateTime = paymentDateTime;
        this.paymentStatus = paymentStatus;
    }


    public int getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public LocalDateTime getPaymentDateTime() {
        return paymentDateTime;
    }
    public void setPaymentDateTime(LocalDateTime paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    
    
}



