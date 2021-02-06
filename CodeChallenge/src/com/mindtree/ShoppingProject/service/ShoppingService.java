package com.mindtree.ShoppingProject.service;

import com.mindtree.ShoppingProject.customException.ShoppingAppException;
import com.mindtree.ShoppingProject.customException.service.ShoppingServiceException;

public interface ShoppingService {
	void signup() throws ShoppingServiceException;

	void shop(int custId) throws ShoppingServiceException, ShoppingAppException;

	void report(String date) throws ShoppingServiceException;

	void addItems() throws ShoppingServiceException;

	void updateQuantity(int itemId) throws ShoppingServiceException;

	void deleteItems(int itemId) throws ShoppingServiceException;

	void display() throws ShoppingServiceException;

}
