package com.mindtree.ShoppingProject.service.serviceimpl;

import java.util.Scanner;

import com.mindtree.ShoppingProject.customException.ShoppingAppException;
import com.mindtree.ShoppingProject.customException.dao.ShoppingAppDaoException;
import com.mindtree.ShoppingProject.customException.service.ShoppingServiceException;
import com.mindtree.ShoppingProject.dao.daoimpl.ShoppingDaoImpl;
import com.mindtree.ShoppingProject.entity.Customer;
import com.mindtree.ShoppingProject.entity.Items;
import com.mindtree.ShoppingProject.service.ShoppingService;

public class ShoppingServiceImpl implements ShoppingService {
	static ShoppingDaoImpl shoppingDaoImpl = new ShoppingDaoImpl();
	static Scanner sc = new Scanner(System.in);

	@Override
	public void signup() throws ShoppingServiceException {
		try {
			System.out.println("Enter CustId");
			int custId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Name");
			String custName = sc.nextLine();
			System.out.println("Enter Phone");
			String phone = sc.nextLine();
			Customer customer = new Customer();
			customer.setCustId(custId);
			customer.setCustName(custName);
			customer.setPhone(phone);
			shoppingDaoImpl.insertCustomer(customer);

		} catch (ShoppingAppDaoException s) {
			throw new ShoppingServiceException(s);
		}

	}

	@Override
	public void shop(int custId) throws ShoppingServiceException, ShoppingAppException {
		double bill = 0;
		try {
			boolean status = shoppingDaoImpl.checkId(custId);
			if (!status) {
				throw new ShoppingAppException("Please Register First With Your Details");
			}
		} catch (ShoppingAppDaoException s) {
			throw new ShoppingServiceException(s);

		} catch (ShoppingAppException s) {
			throw new ShoppingServiceException(s);

		}
		System.out.println("Enter Number of Items to be Bought");
		int number = sc.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.println("Enter ItemCode");
			int itemId = sc.nextInt();
			System.out.println("Enter quantity");
			int quantity = sc.nextInt();
			try {
				bill = bill + shoppingDaoImpl.getBill(itemId, quantity);
			} catch (ShoppingAppDaoException s) {
				throw new ShoppingServiceException(s);

			}

		}

		try {
			shoppingDaoImpl.shoppingEntries(custId, bill);
		} catch (ShoppingAppDaoException s) {
			throw new ShoppingServiceException(s);
		}

	}

	@Override
	public void report(String date) throws ShoppingServiceException {
		try {
			shoppingDaoImpl.report(date);
		} catch (ShoppingAppDaoException s) {
			throw new ShoppingServiceException(s);
		}

	}

	@Override
	public void addItems() throws ShoppingServiceException {
		try {
			System.out.println("Enter Item Id");
			int itemId = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Item Name");
			String itemName = sc.nextLine();
			System.out.println("Enter Price");
			double price = sc.nextDouble();
			System.out.println("Enter Quantity");
			int quantity = sc.nextInt();

			Items item = new Items();
			item = new Items(itemId, itemName, price, quantity);
			shoppingDaoImpl.insertItems(item);

		} catch (ShoppingAppDaoException s) {
			throw new ShoppingServiceException(s);
		}

	}

	@Override
	public void updateQuantity(int itemId) throws ShoppingServiceException {
		try {
			System.out.println("Enter Quantity");
			int quantity = sc.nextInt();
			shoppingDaoImpl.update(itemId, quantity);
		} catch (ShoppingAppDaoException s) {
			throw new ShoppingServiceException(s);
		}

	}

	@Override
	public void deleteItems(int itemId) throws ShoppingServiceException {
		try {
			shoppingDaoImpl.delete(itemId);
		} catch (ShoppingAppDaoException s) {
			throw new ShoppingServiceException(s);
		}

	}

	@Override
	public void display() throws ShoppingServiceException {
		try {
			shoppingDaoImpl.show();
		} catch (ShoppingAppDaoException s) {
			throw new ShoppingServiceException(s);
		}

	}

}
