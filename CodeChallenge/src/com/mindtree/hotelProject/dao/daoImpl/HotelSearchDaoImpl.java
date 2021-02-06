package com.mindtree.hotelProject.dao.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.hotelProject.customException.dao.HotelSearchDaoException;
import com.mindtree.hotelProject.dao.HotelSearchDao;
import com.mindtree.hotelProject.dbUtil.Connect;
import com.mindtree.hotelProject.entity.Hotel;
import com.mindtree.hotelProject.entity.Rooms;

public class HotelSearchDaoImpl implements HotelSearchDao {
	static PreparedStatement preparedStatement = null;
	static Statement statement = null;
	static ResultSet result = null;
	Connect connect = new Connect();
	static String sql = "";

	@Override
	public void createHotel(Hotel hotel) throws HotelSearchDaoException {
		try {
			sql = "insert into hotel (hotelId,hotelName,city) values (?,?,?)";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, hotel.getHotelId());
			preparedStatement.setString(2, hotel.getHotelName());
			preparedStatement.setString(3, hotel.getCity());
			int status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Hotel Registered Successfully");
			}
		} catch (Exception e) {
			throw new HotelSearchDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void createRoom(Rooms rooms) throws HotelSearchDaoException {
		try {
			sql = "insert into rooms (roomNumber,roomType,cost,hotelId) values (?,?,?,?)";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, rooms.getRoomNumber());
			preparedStatement.setString(2, rooms.getRoomType());
			preparedStatement.setInt(3, rooms.getCost());
			preparedStatement.setInt(4, rooms.getHotel().getHotelId());
			int status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Room Registered Successfully in Hotel");
			}
		} catch (Exception e) {
			throw new HotelSearchDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void display(String city) throws HotelSearchDaoException {
		int count = 0;
		sql = "select h.hotelId,h.hotelname,r.roomNumber,r.roomType,r.cost from hotel h inner join rooms r on h.hotelId=r.hotelId where h.city=?";
		try {

			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, city);
			result = preparedStatement.executeQuery();
			System.out.println("HotelId\tHotelName\tRoomNum\tRoomType\tCost");
			while (result.next()) {
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t\t" + result.getInt(3) + "\t"
						+ result.getString(4) + "\t\t" + result.getInt(5));
				count = 1;
			}
			if (count == 0) {
				throw new HotelSearchDaoException("No Such City Are There");
			}
		} catch (HotelSearchDaoException e) {
			throw new HotelSearchDaoException(e);
		} catch (Exception e) {
			throw new HotelSearchDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public Hotel getHotelById(int hotelId) throws HotelSearchDaoException {
		Hotel hotel = new Hotel();
		int count = 0;
		sql = "select * from hotel where hotelId=" + hotelId;
		try {
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				hotel = new Hotel(result.getInt(1), result.getString(2), result.getString(3));
				count = 1;
			}
		} catch (SQLException e) {
			throw new HotelSearchDaoException(e);
		}

		try {
			if (count == 0) {
				throw new HotelSearchDaoException("No Hotels Found");
			}
		} catch (HotelSearchDaoException e) {
			System.out.println(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

		return hotel;
	}

}
