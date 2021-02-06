package com.mindtree.CollegeApp.dao;

import com.mindtree.CollegeApp.customException.dao.CollegeDaoException;
import com.mindtree.CollegeApp.entity.College;

public interface CollegeDao {
	void insertCollege() throws CollegeDaoException;

	void insertStudent() throws CollegeDaoException;

	void display() throws CollegeDaoException;

	void search() throws CollegeDaoException;

	College getCollegeById() throws CollegeDaoException;

}
