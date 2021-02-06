package com.mindtree.hotelProject.dao;

import com.mindtree.hotelProject.customException.dao.HotelSearchDaoException;
import com.mindtree.hotelProject.entity.Hotel;
import com.mindtree.hotelProject.entity.Rooms;

public interface HotelSearchDao {
	void createHotel(Hotel hotel) throws HotelSearchDaoException;

	void createRoom(Rooms rooms) throws HotelSearchDaoException;

	void display(String city) throws HotelSearchDaoException;

	Hotel getHotelById(int hotelId) throws HotelSearchDaoException;

}
