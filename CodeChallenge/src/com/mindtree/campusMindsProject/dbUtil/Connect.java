package com.mindtree.campusMindsProject.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.campusMindsProject.customException.dao.MindtreeMindsDaoException;

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

	public Connection closeConnection(Connection connection) throws MindtreeMindsDaoException {

		try {
			connection.close();
			System.out.println("Connection Closed");
		} catch (SQLException e) {
			throw new MindtreeMindsDaoException("Error in Connection", e);
		}

		return connection;

	}

}
