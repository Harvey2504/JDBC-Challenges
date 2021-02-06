package com.mindtree.campusMindsProject.service;

import com.mindtree.campusMindsProject.customException.service.MindtreeMindsServiceException;

public interface MindtreeMindsService {
	void insert() throws MindtreeMindsServiceException;

	void delete() throws MindtreeMindsServiceException;

	void update() throws MindtreeMindsServiceException;

	void display() throws MindtreeMindsServiceException;

}
