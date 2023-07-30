package com.examly.springapp.payload;

import java.util.Date;

public class RbsBookingDto {

    private int id;
    private Date checkInDate;
    private Date checkOutDate;
    
    private RbsCustomerDto customer;
    private RbsRoomDto room;
    private RbsPaymentDto payment;
    
	public RbsPaymentDto getPayment() {
		return payment;
	}
	public void setPayment(RbsPaymentDto payment) {
		this.payment = payment;
	}
	public RbsCustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(RbsCustomerDto customer) {
		this.customer = customer;
	}
	
	public RbsRoomDto getRoom() {
		return room;
	}
	public void setRoom(RbsRoomDto room) {
		this.room = room;
	}
	
	public RbsBookingDto() {
		super();
		
	}
	public RbsBookingDto(int id, Date checkInDate, Date checkOutDate) {
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
    
    
    
}
