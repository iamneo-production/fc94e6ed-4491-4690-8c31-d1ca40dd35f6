package com.examly.springapp.payload;
import java.util.Objects;

import java.util.Date;

public class BookingDto {

    private int id;
    private Date checkInDate;
    private Date checkOutDate;
    
    private CustomerDto customer;
    private RoomDto room;
    private PaymentDto payment;
    private CancellationDto cancellation;
    
	public CancellationDto getCancellation() {
		return cancellation;
	}
	public void setCancellation(CancellationDto cancellation) {
		this.cancellation = cancellation;
	}
	public PaymentDto getPayment() {
		return payment;
	}
	public void setPayment(PaymentDto payment) {
		this.payment = payment;
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
	
	public BookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingDto(int id, Date checkInDate, Date checkOutDate) {
		super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingDto)) return false;
        BookingDto other = (BookingDto) o;
        return Objects.equals(id, other.id) &&
                Objects.equals(checkInDate, other.checkInDate) &&
                Objects.equals(checkOutDate, other.checkOutDate) &&
                
                Objects.equals(room, other.room) &&
                Objects.equals(payment, other.payment) &&
                Objects.equals(cancellation, other.cancellation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkInDate, checkOutDate, room, payment, cancellation);
    }
    
}
