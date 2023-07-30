package com.examly.springapp.payload;


import java.util.Date;


public class RbsCancellationDto {


    private int cancellationId;
    private Date dateCancelled;
    private String reason;
    
    private RbsBookingDto booking;
    
    
    public RbsBookingDto getBooking() {
        return booking;
    }


    public void setBooking(RbsBookingDto booking) {
        this.booking = booking;
    }
    
    
    public RbsCancellationDto() {
        super();
        
    }
    public RbsCancellationDto(int cancellationId, Date dateCancelled, String reason) {
        super();
        this.cancellationId = cancellationId;
        this.dateCancelled = dateCancelled;
        this.reason = reason;
    }
    public int getCancellationId() {
        return cancellationId;
    }
    public void setCancellationId(int cancellationId) {
        this.cancellationId = cancellationId;
    }
    public Date getDateCancelled() {
        return dateCancelled;
    }
    public void setDateCancelled(Date dateCancelled) {
        this.dateCancelled = dateCancelled;
    }
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
}



