package com.mindtree.hotelProject.entity;

public class Hotel {
	private int hotelId;
	private String hotelName;
	private String city;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Hotel(int hotelId, String hotelName, String city) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.city = city;
	}

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
