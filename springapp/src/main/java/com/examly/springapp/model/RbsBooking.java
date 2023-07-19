package com.examly.springapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class RbsBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private Date checkInDate;
    private Date checkOutDate;
    
    @ManyToOne
    @JoinColumn(name = "room_id")
    private RbsRoom room;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private RbsCustomer customer;

    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RbsPayment> payments;
    
    @OneToMany(mappedBy = "booking",cascade = CascadeType.ALL)
    private List<RbsCancellation> cancellations;
    
    
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private RbsPayment payment; // Add payment property
    
    
    public RbsPayment getPayment() {
        return payment;
    }

    public void setPayment(RbsPayment payment) {
        this.payment = payment;
    }
    
    public RbsBooking(int id, Date checkInDate, Date checkOutDate, RbsRoom room, RbsCustomer customer,
            List<RbsPayment> payments, List<RbsCancellation> cancellations) {
    				this.id = id;
    				this.checkInDate = checkInDate;
    				this.checkOutDate = checkOutDate;
    				this.room = room;
    				this.customer = customer;
    				this.payments = payments;
    				this.cancellations = cancellations;
    }
    
    
    public RbsRoom getRoom() {
		return room;
		
	}

	public void setRoom(RbsRoom room) {
		this.room = room;
	}

    public RbsCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(RbsCustomer customer) {
		this.customer = customer;
	}

	public RbsBooking() {
		super();
		
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
