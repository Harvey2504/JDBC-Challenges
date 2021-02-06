package com.mindtree.campusMindsProject.client;

import java.util.Scanner;

import com.mindtree.campusMindsProject.customException.service.MindtreeMindsServiceException;
import com.mindtree.campusMindsProject.service.serviceimpl.MindtreeMindsServiceImpl;

public class MindtreeMindsApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MindtreeMindsServiceImpl service = new MindtreeMindsServiceImpl();

		int choice = 0;
		do {
			System.out.println("1.Insert\n2.Delete\n3.Update Phone\n4.Minds in Track\n5.Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				try {
					service.insert();
				} catch (MindtreeMindsServiceException e) {
					System.out.println(e);
				}
				break;

			case 2:
				try {
					service.delete();
				} catch (MindtreeMindsServiceException e) {
					System.out.println(e);
				}

				break;

			case 3:
				try {
					service.update();
				} catch (MindtreeMindsServiceException e) {
					System.out.println(e);
				}

				break;

			case 4:
				try {
					service.display();
				} catch (MindtreeMindsServiceException e) {
					System.out.println(e);
				}
				break;

			case 5:
				System.out.println("Logging Out");
				break;

			default:
				System.out.println("Invalid Input");
				break;
			}
		} while (choice != 5);

	}

}
