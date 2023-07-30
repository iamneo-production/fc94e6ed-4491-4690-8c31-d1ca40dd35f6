package com.examly.springapp.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
import java.util.Date;

@Entity
@Table
public class Room{

   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    
    @Column(length = 255)
    private String roomType;


    private int capacity;


    private boolean isAvailable;


    private double pricePerNight;
    
     @OneToMany(mappedBy="room")
     private List<Booking> bookings;


    public Room() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Room(int roomId, String roomType, int capacity, boolean isAvailable, double pricePerNight) {
        super();
        this.roomId = roomId;
        this.roomType = roomType;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
        this.pricePerNight = pricePerNight;
    }


    public int getRoomId() {
        return roomId;
    }


    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }


    public String getRoomType() {
        return roomType;
    }


    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }


    public int getCapacity() {
        return capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public boolean isAvailable() {
        return isAvailable;
    }


    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


    public double getPricePerNight() {
        return pricePerNight;
    }


    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomId;
	
	@Column(length = 255)
	private String roomType;

	private int capacity;

	private boolean isAvailable;

	private double pricePerNight;
	
	 @OneToMany(mappedBy="room")
	 private List<Booking> bookings;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(int roomId, String roomType, int capacity, boolean isAvailable, double pricePerNight) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.capacity = capacity;
		this.isAvailable = isAvailable;
		this.pricePerNight = pricePerNight;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
    
    

}