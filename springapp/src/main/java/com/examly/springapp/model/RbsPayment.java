package com.examly.springapp.model;


import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class RbsPayment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
    private double amount;
    private LocalDateTime paymentDateTime;
    private String paymentStatus;
    
    @ManyToOne
    @JoinColumn(name="id")
    private RbsBooking booking;
    
    public RbsPayment(int paymentId, double amount, LocalDateTime paymentDateTime, String paymentStatus, RbsBooking booking) {
        super();
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDateTime = paymentDateTime;
        this.paymentStatus = paymentStatus;
        this.booking = booking;
    }
    public RbsBooking getBooking() {
        return booking;
    }
    public void setBooking(RbsBooking booking) {
        this.booking = booking;
    }
    
    public RbsPayment() {
        super();
        
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
