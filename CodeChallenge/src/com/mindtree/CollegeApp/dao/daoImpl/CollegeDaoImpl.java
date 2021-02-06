package com.mindtree.CollegeApp.dao.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mindtree.CollegeApp.customException.dao.CollegeDaoException;
import com.mindtree.CollegeApp.dao.CollegeDao;
import com.mindtree.CollegeApp.dbUtil.Connect;
import com.mindtree.CollegeApp.entity.College;
import com.mindtree.CollegeApp.entity.Student;

public class CollegeDaoImpl implements CollegeDao {
	static PreparedStatement preparedStatement = null;
	static Statement statement = null;
	static ResultSet result = null;
	Connect connect = new Connect();
	static String sql = "";

	@Override
	public void insertCollege(College college) throws CollegeDaoException {
		try {
			sql = "insert into college (collegeId,collegeName,totalStrength) values (?,?,?)";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, college.getCollegeId());
			preparedStatement.setString(2, college.getCollegeName());
			preparedStatement.setInt(3, college.getTotalStrength());
			int status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("College Registered Successfully");
			}
		} catch (Exception e) {
			throw new CollegeDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void insertStudent(Student student) throws CollegeDaoException {
		try {
			sql = "insert into students (studentId,studentName,age,subjectId,collegeId) values (?,?,?,?,?)";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, student.getStudentId());
			preparedStatement.setString(2, student.getStudentName());
			preparedStatement.setInt(3, student.getAge());
			preparedStatement.setInt(4, student.getSubjectId());
			preparedStatement.setInt(5, student.getCollege().getCollegeId());
			int status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Student Registered Successfully in  : " + student.getCollege().getCollegeName());
			}
		} catch (Exception e) {
			throw new CollegeDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

	@Override
	public void display() throws CollegeDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void search(String collegeName, int subjectId) throws CollegeDaoException {
		int count = 0;
		sql = "select s1.studentId,s1.studentName,s1.age,s2.subjectName,c.collegeName from college c inner join students s1 on c.collegeId=s1.collegeId inner join subject s2 on s1.subjectId=s2.subjectId where c.collegeName=? and s1.subjectId=? order by s1.age desc,s1.studentName desc";
		try {
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setString(1, collegeName);
			preparedStatement.setInt(2, subjectId);
			result = preparedStatement.executeQuery();
			System.out.println("Id\tName\tAge\tSubject\tCollege");
			while (result.next()) {
				count = 1;
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getInt(3) + "\t"
						+ result.getString(4) + "\t" + result.getString(5));
			}
			if (count == 0) {
				throw new CollegeDaoException("No Results Found");
			}
		} catch (Exception e) {
			throw new CollegeDaoException(e);
		}

	}

	@Override
	public College getCollegeById(int collegeId) throws CollegeDaoException {
		College college = new College();
		int count = 0;
		sql = "select * from college where collegeId=" + collegeId;
		try {
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				college = new College(result.getInt(1), result.getString(2), result.getInt(3));
				count = 1;
			}
		} catch (SQLException e) {
			throw new CollegeDaoException(e);
		}

		try {
			if (count == 0) {
				throw new CollegeDaoException("No Such College with ID " + collegeId + " Found");
			}
		} catch (CollegeDaoException e) {
			System.out.println(e);
		}

		return college;
	}

	@Override
	public void updateTotalStrength(College college) throws CollegeDaoException {
		int totalStrength = 0;
		int collegeIdMatch = 0;

		try {
			int status = 0;
			collegeIdMatch = college.getCollegeId();
			sql = "select * from college where collegeId=" + collegeIdMatch;
			statement = (Statement) connect.getConnection().createStatement();
			result = statement.executeQuery(sql);
			while (result.next()) {
				status = 1;
				totalStrength = result.getInt(3);
			}
			if (status == 0) {
				throw new CollegeDaoException("No Such College Found");
			}

		} catch (Exception e) {
			throw new CollegeDaoException(e);
		}

		try {
			sql = "update college set totalStrength=? where collegeId=?";
			preparedStatement = (PreparedStatement) connect.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, totalStrength + 1);
			preparedStatement.setInt(2, college.getCollegeId());
			int status = preparedStatement.executeUpdate();
			if (status == 1) {
				System.out.println("Updated Total Strength Successfully");
			}
		} catch (Exception e) {
			throw new CollegeDaoException(e);
		} finally {
			connect.closeConnection(connect.getConnection());
		}

	}

}
