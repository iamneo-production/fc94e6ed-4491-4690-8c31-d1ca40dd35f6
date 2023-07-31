package com.examly.springapp.payload;
import java.time.LocalDateTime;

public class PaymentDto {

    private int paymentId;
	private double amount;
	private LocalDateTime paymentDateTime;
	private String paymentStatus;
	
	private int bookingId;
	
	private BookingDto booking;
	private CustomerDto customer;
	private RoomDto room;
	private CancellationDto cancellation;
	
	
	public CancellationDto getCancellation() {
		return cancellation;
	}

	public void setCancellation(CancellationDto cancellation) {
		this.cancellation = cancellation;
	}

	public CustomerDto getCustomer() {
		return customer;
	}
	
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}


	public RoomDto getRoom() {
		return room;
	}


	public void setRoom(RoomDto room) {
		this.room = room;
	}


	public BookingDto getBooking() {
		return booking;
	}


	public void setBooking(BookingDto booking) {
		this.booking = booking;
	}


	public PaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PaymentDto(int paymentId, double amount, LocalDateTime paymentDateTime, String paymentStatus, int bookingId) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDateTime = paymentDateTime;
		this.paymentStatus = paymentStatus;
		this.bookingId = bookingId;
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
	
	public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }


    
}
