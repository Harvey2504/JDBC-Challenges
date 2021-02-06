package com.mindtree.campusMindsProject.dao;

import com.mindtree.campusMindsProject.customException.dao.MindtreeMindsDaoException;
import com.mindtree.campusMindsProject.entity.MindtreeMinds;

public interface MindtreeMindsDao {
	void insert(MindtreeMinds mindtreeMinds) throws MindtreeMindsDaoException;

	void delete(int id) throws MindtreeMindsDaoException;

	void update(int id, String phone) throws MindtreeMindsDaoException;

	void display(String track) throws MindtreeMindsDaoException;

}
