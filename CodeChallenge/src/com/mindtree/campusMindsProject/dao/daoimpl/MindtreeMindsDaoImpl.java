package com.mindtree.campusMindsProject.dao.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mindtree.campusMindsProject.customException.MindtreeMindsAppException;
import com.mindtree.campusMindsProject.customException.dao.MindtreeMindsDaoException;
import com.mindtree.campusMindsProject.dao.MindtreeMindsDao;
import com.mindtree.campusMindsProject.dbUtil.Connect;
import com.mindtree.campusMindsProject.entity.MindtreeMinds;

public class MindtreeMindsDaoImpl implements MindtreeMindsDao {
	static PreparedStatement preparedStatement = null;
	static Statement statement = null;
	static ResultSet result = null;
	Connect connect = new Connect();
	static String sql = "";

	@Override
	public void insert(MindtreeMinds mindtreeMinds) throws MindtreeMindsDaoException {
		int numberOfMinds = 0;
		int status = 0;
		int trackIdMatch = 0;
		try {
			trackIdMatch = mindtreeMinds.getTrackId();
			sql = "select * from track where track_id=" + trackIdMatch;
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				status = 1;
				numberOfMinds = result.getInt(3);
			}
			if (status == 0) {
				throw new MindtreeMindsDaoException("No Such Tracks Found");
			}

		} catch (Exception e) {
			throw new MindtreeMindsDaoException(e);
		}

		try {
			sql = "insert into mindtreeminds (mindId,mindName,track_id,phone,role) values (?,?,?,?,?)";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, mindtreeMinds.getMindId());
			preparedStatement.setString(2, mindtreeMinds.getName());
			preparedStatement.setInt(3, mindtreeMinds.getTrackId());
			preparedStatement.setString(4, mindtreeMinds.getPhone());
			preparedStatement.setString(5, mindtreeMinds.getRole());
			status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Registered Successfully");
			}
		} catch (Exception e) {
			throw new MindtreeMindsDaoException(e);
		}

		try {
			status = 0;
			sql = "update track set minds_in_track=? where track_id=?";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, (numberOfMinds + 1));
			preparedStatement.setInt(2, trackIdMatch);
			status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Increased Minds in Specified Track");
			}

		} catch (Exception e) {
			throw new MindtreeMindsDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void delete(int id) throws MindtreeMindsDaoException {
		int numberOfMinds = 0;
		int trackIdMatch = 0;
		try {
			int status = 0;
			sql = "select * from mindtreeminds where mindId=" + id;
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				status = 1;
				trackIdMatch = result.getInt(3);
			}
			if (status == 0) {
				throw new MindtreeMindsDaoException("No Data Found");
			}

		} catch (Exception e) {
			throw new MindtreeMindsDaoException(e);
		}

		try {
			int status = 0;
			sql = "select * from track where track_id=" + trackIdMatch;
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				status = 1;
				numberOfMinds = result.getInt(3);
			}
			if (status == 0) {
				throw new MindtreeMindsDaoException("No Such Tracks Found");
			}

		} catch (Exception e) {
			throw new MindtreeMindsDaoException(e);
		}

		try {
			sql = "delete from mindtreeminds where mindId=" + id;
			statement = (Statement) connect.getConnection().createStatement();
			int status = statement.executeUpdate(sql);
			if (status == 1) {
				System.out.println("Deleted Successfully");
			}

		} catch (Exception e) {
			throw new MindtreeMindsDaoException(e);
		}

		try {
			int status = 0;
			sql = "update track set minds_in_track=? where track_id=?";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, (numberOfMinds - 1));
			preparedStatement.setInt(2, trackIdMatch);
			status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Decreased Minds in Specified Track");
			}

		} catch (Exception e) {
			throw new MindtreeMindsDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void update(int id, String phone) throws MindtreeMindsDaoException {
		try {
			int status = 0;
			sql = "update mindtreeminds set phone=? where mindId=?";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, phone);
			preparedStatement.setInt(2, id);
			status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Updated Phone Details");
			} else {
				throw new MindtreeMindsAppException("Id Not Found");
			}

		} catch (Exception e) {
			throw new MindtreeMindsDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void display(String track) throws MindtreeMindsDaoException {
		try {
			int status = 0;
			sql = "select m.mindId,m.mindName,m.phone,m.role from mindtreeminds m inner join track t on m.track_id=t.track_id where t.track_name=?";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, track);
			result = preparedStatement.executeQuery();
			while (result.next()) {
				status = 1;
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getString(3) + "\t"
						+ result.getString(4));
			}
			if (status == 0) {
				throw new MindtreeMindsDaoException("No Such Track Found");
			}

		} catch (Exception e) {
			throw new MindtreeMindsDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

}
