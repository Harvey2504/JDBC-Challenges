package com.mindtree.ShoppingProject.dao;

import com.mindtree.ShoppingProject.customException.dao.ShoppingAppDaoException;
import com.mindtree.ShoppingProject.entity.Customer;
import com.mindtree.ShoppingProject.entity.Items;

public interface ShoppingDao {

	void insertCustomer(Customer customer) throws ShoppingAppDaoException;

	void shop(int itemId) throws ShoppingAppDaoException;

	void report(String date) throws ShoppingAppDaoException;

	void insertItems(Items item) throws ShoppingAppDaoException;

	void update(int itemId, int quantity) throws ShoppingAppDaoException;

	void delete(int itemId) throws ShoppingAppDaoException;

	void show() throws ShoppingAppDaoException;

	double getBill(int itemId, int quantity) throws ShoppingAppDaoException;

	boolean checkId(int custId) throws ShoppingAppDaoException;

	void shoppingEntries(int custId, double bill) throws ShoppingAppDaoException;

}
