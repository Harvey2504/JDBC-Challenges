package com.mindtree.hotelProject.service.serviceImpl;

import java.util.Scanner;

import com.mindtree.hotelProject.customException.HotelSearchAppException;
import com.mindtree.hotelProject.customException.dao.HotelSearchDaoException;
import com.mindtree.hotelProject.customException.service.HotelSearchServiceException;
import com.mindtree.hotelProject.dao.daoImpl.HotelSearchDaoImpl;
import com.mindtree.hotelProject.entity.Hotel;
import com.mindtree.hotelProject.entity.Rooms;
import com.mindtree.hotelProject.service.HotelSearchService;

public class HotelSearchServiceImpl implements HotelSearchService {
	static Scanner sc = new Scanner(System.in);
	static HotelSearchDaoImpl dao = new HotelSearchDaoImpl();

	@Override
	public void createHotel() throws HotelSearchServiceException {
		System.out.println("Enter HotelId");
		int hotelId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter HotelName");
		String hotelName = sc.nextLine();
		System.out.println("Enter City");
		String city = sc.nextLine();
		Hotel hotel = new Hotel();
		hotel = new Hotel(hotelId, hotelName, city);

		try {
			dao.createHotel(hotel);
		} catch (HotelSearchDaoException e) {
			throw new HotelSearchServiceException(e);
		}

	}

	@Override
	public void createRoom() throws HotelSearchServiceException {
		String roomType = "";
		System.out.println("Enter roomNumber");
		int roomNumber = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter roomType");
		System.out.println("1.Luxury 2.SemiLuxury 3.Deluxe");
		int type = sc.nextInt();
		try {
			if (type == 1) {
				roomType = "Luxury";
			} else if (type == 2) {
				roomType = "Semi Luxury";
			} else if (type == 3) {
				roomType = "Deluxe";
			} else {
				throw new HotelSearchAppException("Wrong Input");
			}
		} catch (HotelSearchAppException e) {
			throw new HotelSearchServiceException(e);
		}

		System.out.println("Enter roomCost");
		int cost = sc.nextInt();
		System.out.println("Enter hotelId");
		int hotelId = sc.nextInt();
		sc.nextLine();

		try {
			Hotel hotel = dao.getHotelById(hotelId);
			Rooms rooms = new Rooms();
			rooms = new Rooms(roomNumber, roomType, cost, hotel);
			dao.createRoom(rooms);
		} catch (HotelSearchDaoException e) {
			throw new HotelSearchServiceException(e);
		}

	}

	@Override
	public void display() throws HotelSearchServiceException {
		System.out.println("Enter the City Name");
		String city = sc.nextLine();

		try {
			dao.display(city);
		} catch (HotelSearchDaoException e) {
			throw new HotelSearchServiceException(e);
		}

	}

}
