package com.examly.springapp.payload;
import java.util.Date;

public class CancellationDto {
    
    private int cancellationId;
	private Date dateCancelled;
	private String reason;
	
	private BookingDto booking;
	
	
	public BookingDto getBooking() {
		return booking;
	}


	public void setBooking(BookingDto booking) {
		this.booking = booking;
	}
	
	
	public CancellationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CancellationDto(int cancellationId, Date dateCancelled, String reason) {
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
