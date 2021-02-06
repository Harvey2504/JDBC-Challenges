package com.mindtree.hotelProject.service;

import com.mindtree.hotelProject.customException.service.HotelSearchServiceException;

public interface HotelSearchService {
	void createHotel() throws HotelSearchServiceException;

	void createRoom() throws HotelSearchServiceException;

	void display() throws HotelSearchServiceException;

}
