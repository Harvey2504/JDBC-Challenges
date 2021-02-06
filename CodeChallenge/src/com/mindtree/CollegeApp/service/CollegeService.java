package com.mindtree.CollegeApp.service;

import com.mindtree.CollegeApp.customException.service.CollegeServiceException;

public interface CollegeService {
	void insertCollege() throws CollegeServiceException;

	void insertStudent() throws CollegeServiceException;

	void display() throws CollegeServiceException;

	void search() throws CollegeServiceException;

}
