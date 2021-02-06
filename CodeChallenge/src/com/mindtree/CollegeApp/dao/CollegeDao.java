package com.mindtree.CollegeApp.dao;

import com.mindtree.CollegeApp.customException.dao.CollegeDaoException;
import com.mindtree.CollegeApp.entity.College;
import com.mindtree.CollegeApp.entity.Student;

public interface CollegeDao {
	void insertCollege(College college) throws CollegeDaoException;

	void insertStudent(Student student) throws CollegeDaoException;

	void display() throws CollegeDaoException;

	void search(String collegeName, int subjectId) throws CollegeDaoException;

	College getCollegeById(int collegeId) throws CollegeDaoException;

	void updateTotalStrength(College college) throws CollegeDaoException;

}
