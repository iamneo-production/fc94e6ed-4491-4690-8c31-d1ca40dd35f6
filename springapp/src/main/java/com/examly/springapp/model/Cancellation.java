package com.examly.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import java.util.Date;
import java.util.List;


@Entity
public class Cancellation {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cancellationId;
    private Date dateCancelled;
    private String reason;
    @ManyToOne
    @JoinColumn(name="booking_id")
    private Booking booking;
    public Cancellation() {
        // Default constructor
    }

    public Cancellation(int cancellationId, Date dateCancelled, String reason) {
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
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cancellationId;

	private Date dateCancelled;
	
	@Column(length = 255)
	private String reason;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Booking booking;
	
	
	
	
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	} 

	public Cancellation() {
		super();
		
	}

	public Cancellation(int cancellationId, Date dateCancelled, String reason) {
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
