package com.mindtree.hotelProject.client;

import java.util.Scanner;

import com.mindtree.hotelProject.customException.service.HotelSearchServiceException;
import com.mindtree.hotelProject.service.serviceImpl.HotelSearchServiceImpl;

public class HotelSearchApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HotelSearchServiceImpl service = new HotelSearchServiceImpl();
		int choice = 0;

		do {
			System.out.println("1.Create Hotel\n2.Create Room in a Hotel\n3.Search Hotel based on City\n4.Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				try {
					service.createHotel();
				} catch (HotelSearchServiceException e) {
					System.out.println(e);
				}

				break;
			case 2:
				try {
					service.createRoom();
				} catch (HotelSearchServiceException e) {
					System.out.println(e);
				}
				break;
			case 3:
				try {
					service.display();
				} catch (HotelSearchServiceException e) {
					System.out.println(e);
				}
				break;
			case 4:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Wrong Input");
				break;

			}

		} while (choice != 4);

	}

}
