package com.mindtree.CollegeApp.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.CollegeApp.customException.dao.CollegeDaoException;

public class Connect {
	public Connection getConnection() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/mindtree?autoRecconect=true&useSSL=false";
		String userName = "root";
		String password = "Oliverqueen@2504";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

	public Connection closeConnection(Connection connection) throws CollegeDaoException {

		try {
			connection.close();
			System.out.println("Connection Closed");
		} catch (SQLException e) {
			throw new CollegeDaoException("Error in Connection");
		}

		return connection;

	}
}