package com.mindtree.ShoppingProject.dao.daoimpl;

import java.sql.ResultSet;

import com.mindtree.ShoppingProject.customException.ShoppingAppException;
import com.mindtree.ShoppingProject.customException.dao.ShoppingAppDaoException;
import com.mindtree.ShoppingProject.dao.ShoppingDao;
import com.mindtree.ShoppingProject.dbUtil.Connect;
import com.mindtree.ShoppingProject.entity.Customer;
import com.mindtree.ShoppingProject.entity.Items;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class ShoppingDaoImpl implements ShoppingDao {
	static PreparedStatement preparedStatement = null;
	static Statement statement = null;
	static ResultSet result = null;
	Connect connect = new Connect();
	static String sql = "";

	@Override
	public void insertCustomer(Customer customer) throws ShoppingAppDaoException {
		try {
			sql = "insert into customer (cust_Id,cust_Name,phone) values (?,?,?)";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, customer.getCustId());
			preparedStatement.setString(2, customer.getCustName());
			preparedStatement.setString(3, customer.getPhone());
			int status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Registered Successfully");
			}
		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void report(String date) throws ShoppingAppDaoException {
		try {
			int status = 0;
			sql = "select * from customer where date=" + date;
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			System.out.println("CustId\tCustName\tBill");
			while (result.next()) {
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getDouble(5));
				status = 1;
			}
			if (status == 0) {
				throw new ShoppingAppException("No Entries Found");
			}

		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void shop(int itemId) throws ShoppingAppDaoException {
		try {
			int status = 0;
			sql = "select * from items where item_id=" + itemId;
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				status = 1;
			}
			if (status == 0) {
				throw new ShoppingAppException("No Entries Found");
			}

		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void insertItems(Items item) throws ShoppingAppDaoException {
		try {
			sql = "insert into items values (?,?,?,?)";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, item.getItemId());
			preparedStatement.setString(2, item.getItemName());
			preparedStatement.setDouble(3, item.getPrice());
			preparedStatement.setInt(4, item.getQuantity());
			int status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Items Inserted Successfully");
			}
		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void update(int itemId, int quantity) throws ShoppingAppDaoException {
		try {
			int status = 0;
			sql = "select * from items where item_id=" + itemId;
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				status = 1;
				quantity = quantity + result.getInt(4);
			}
			if (status == 0) {
				throw new ShoppingAppException("No Entries Found");
			}

		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		}

		try {
			sql = "update items set quantity=? where item_id=?";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, itemId);
			int status = preparedStatement.executeUpdate();

			if (status == 1) {
				System.out.println("Updated Succesfully");
			}

		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void delete(int itemId) throws ShoppingAppDaoException {
		try {
			sql = "delete from items where item_id=" + itemId;
			statement = (Statement) connect.getConnection().createStatement();
			int status = statement.executeUpdate(sql);
			if (status == 1) {
				System.out.println("Deleted Succesfully");
			}

		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void show() throws ShoppingAppDaoException {
		try {
			sql = "select * from items order by price asc,quantity desc";
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			System.out.println("Id\tItem_Name\tPrice\tQuantity ");
			while (result.next()) {
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t\t" + result.getDouble(3) + "\t"
						+ result.getInt(4));
			}
		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public double getBill(int itemId, int quantity) throws ShoppingAppDaoException {
		double bill = 0;
		try {

			sql = "select * from items where item_id=" + itemId;
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				if (result.getInt(4) >= quantity) {
					double price = result.getDouble(3);
					bill = price * quantity;
					sql = "update items set quantity=? where item_id=?";
					preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
					preparedStatement.setInt(1, (result.getInt(4) - quantity));
					preparedStatement.setInt(2, itemId);
					preparedStatement.executeUpdate();
					return bill;
				} else {
					throw new ShoppingAppException("Quantity Not Available");
				}

			}

		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}
		return bill;

	}

	public boolean checkId(int custId) throws ShoppingAppDaoException {
		try {
			sql = "select * from customer where cust_id=" + custId;
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				return true;
			}

		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}
		return false;

	}

	@Override
	public void shoppingEntries(int custId, double bill) throws ShoppingAppDaoException {
		try {
			sql = "update customer set amount=?,date=? where cust_Id=?";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setDouble(1, bill);
			preparedStatement.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
			preparedStatement.setInt(3, custId);
			int status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Shopping Successfull");
			}
		} catch (Exception e) {
			throw new ShoppingAppDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

}
