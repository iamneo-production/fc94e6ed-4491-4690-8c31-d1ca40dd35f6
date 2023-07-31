package com.examly.springapp.payload;

public class RoomDto {

    private int roomId;
	
	private String roomType;

	private int capacity;

	private boolean isAvailable;

	private double pricePerNight;

	public RoomDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomDto(int roomId, String roomType, int capacity, boolean isAvailable, double pricePerNight) {
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
