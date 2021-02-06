package com.mindtree.hotelProject.entity;

public class Rooms {
	private int roomNumber;
	private String roomType;
	private int cost;
	private Hotel hotel;

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Rooms(int roomNumber, String roomType, int cost, Hotel hotel) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.cost = cost;
		this.hotel = hotel;
	}

	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}

}
