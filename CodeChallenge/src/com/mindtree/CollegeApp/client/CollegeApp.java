package com.mindtree.CollegeApp.client;

import java.util.Scanner;

import com.mindtree.CollegeApp.customException.service.CollegeServiceException;
import com.mindtree.CollegeApp.service.serviceImpl.CollegeServiceImpl;

public class CollegeApp {
	static Scanner sc = new Scanner(System.in);
	static CollegeServiceImpl service = new CollegeServiceImpl();

	public static void main(String[] args) {

		int choice = 0;
		do {
			System.out.println(
					"1.Create College\n2.Enrol Students\n3.Print Data\n4.Search Based on College and Subject\n5.Exit");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				try {
					service.insertCollege();

				} catch (CollegeServiceException e) {
					System.out.println(e);
				}

				break;
			case 2:
				try {
					service.insertStudent();

				} catch (CollegeServiceException e) {
					System.out.println(e);
				}
				break;
			case 3:
				try {
					service.display();

				} catch (CollegeServiceException e) {
					System.out.println(e);
				}
				break;
			case 4:
				try {
					service.search();

				} catch (CollegeServiceException e) {
					System.out.println(e);
				}
				break;
			case 5:
				System.out.println("GoodBye");
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}

		} while (choice != 5);

	}

}
