package com.mindtree.hotelProject.customException;

public class HotelSearchAppException extends Exception {
	public HotelSearchAppException() {

	}

	public HotelSearchAppException(Throwable arg0) {
		super(arg0);
	}

	public HotelSearchAppException(String arg0) {
		super(arg0);
	}

	public HotelSearchAppException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
