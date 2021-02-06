package com.mindtree.ShoppingProject.client;

import java.util.Scanner;

import com.mindtree.ShoppingProject.customException.ShoppingAppException;
import com.mindtree.ShoppingProject.customException.service.ShoppingServiceException;
import com.mindtree.ShoppingProject.service.serviceimpl.ShoppingServiceImpl;

public class ShoppingApp {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ShoppingAppException {
		ShoppingServiceImpl shoppingService = new ShoppingServiceImpl();
		int choice = 0;

		do {
			System.out.println("1.Signup \n2.Shop \n3.Shopping Report \n4.Add Items"
					+ " \n5.Update Quantity \n6.Delete Items \n7.Get All Items" + " \n8.Exit");

			choice = sc.nextInt();
			switch (choice) {

			case 1:
				try {
					shoppingService.signup();

				} catch (ShoppingServiceException s) {
					System.out.println(s);

				}
				break;

			case 2:
				try {
					System.out.println("Enter Customer Id");
					int custId = sc.nextInt();
					shoppingService.shop(custId);
				} catch (ShoppingServiceException s) {
					System.out.println(s);

				}

				break;

			case 3:
				sc.nextLine();
				System.out.println("Enter Date");
				String date = sc.nextLine();
				try {
					shoppingService.report(date);
				} catch (ShoppingServiceException s) {
					System.out.println(s);
				}

				break;

			case 4:
				try {
					shoppingService.addItems();

				} catch (ShoppingServiceException s) {
					System.out.println(s);

				}
				break;

			case 5:
				try {
					System.out.println("Enter Item Id To Be Updated");
					int itemId = sc.nextInt();
					shoppingService.updateQuantity(itemId);

				} catch (ShoppingServiceException s) {
					System.out.println(s);

				}
				break;

			case 6:
				try {
					System.out.println("Enter Item Id To Be Deleted");
					int itemId = sc.nextInt();
					shoppingService.deleteItems(itemId);

				} catch (ShoppingServiceException s) {
					System.out.println(s);

				}
				break;

			case 7:
				try {
					shoppingService.display();

				} catch (ShoppingServiceException s) {
					System.out.println(s);

				}
				break;

			case 8:
				System.out.println("GoodBye");
				break;

			default:
				System.out.println("Invalid Input");
				break;
			}

		} while (choice != 8);

	}

}
