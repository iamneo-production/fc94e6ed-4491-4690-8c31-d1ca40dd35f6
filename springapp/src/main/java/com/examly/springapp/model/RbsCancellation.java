package com.examly.springapp.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Table;


@Entity
@Table
public class RbsCancellation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cancellationId;


    private Date dateCancelled;
    
    @Column(length = 255)
    private String reason;
    
    @ManyToOne
    @JoinColumn(name="id")
    private RbsBooking booking;
    
    
    public RbsBooking getBooking() {
        return booking;
    }
    public void setBooking(RbsBooking booking) {
        this.booking = booking;
    } 


    public RbsCancellation() {
        super();
        
    }


    public RbsCancellation(int cancellationId, Date dateCancelled, String reason) {
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



