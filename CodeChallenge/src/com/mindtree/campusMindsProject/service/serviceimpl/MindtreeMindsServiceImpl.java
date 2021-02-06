package com.mindtree.campusMindsProject.service.serviceimpl;

import java.util.Scanner;

import com.mindtree.campusMindsProject.customException.MindtreeMindsAppException;
import com.mindtree.campusMindsProject.customException.dao.MindtreeMindsDaoException;
import com.mindtree.campusMindsProject.customException.service.MindtreeMindsServiceException;
import com.mindtree.campusMindsProject.dao.daoimpl.MindtreeMindsDaoImpl;
import com.mindtree.campusMindsProject.entity.MindtreeMinds;
import com.mindtree.campusMindsProject.service.MindtreeMindsService;

public class MindtreeMindsServiceImpl implements MindtreeMindsService {
	static Scanner sc = new Scanner(System.in);
	static MindtreeMindsDaoImpl dao = new MindtreeMindsDaoImpl();

	@Override
	public void insert() throws MindtreeMindsServiceException {
		System.out.println("Enter Id");
		int mindId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name");
		String name = sc.nextLine();
		System.out.println("Enter Track Id");
		int trackId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Phone");
		String phone = sc.nextLine();
		System.out.println("Enter Role 1.Lead 2.CampusMind");
		String role = "";
		int input = sc.nextInt();
		try {
			if (input == 1) {
				role = "Lead";
			} else if (input == 2) {
				role = "Campus Mind";
			} else {
				throw new MindtreeMindsAppException("Invalid Input");
			}

		} catch (MindtreeMindsAppException e) {
			System.out.println(e);
		}
		MindtreeMinds mindtreeMinds = new MindtreeMinds();
		mindtreeMinds = new MindtreeMinds(mindId, name, trackId, phone, role);
		try {
			dao.insert(mindtreeMinds);
		} catch (MindtreeMindsDaoException e) {
			throw new MindtreeMindsServiceException(e);
		}

	}

	@Override
	public void delete() throws MindtreeMindsServiceException {
		System.out.println("Enter an Id to Delete");
		int id = sc.nextInt();
		try {
			dao.delete(id);
		} catch (MindtreeMindsDaoException e) {
			throw new MindtreeMindsServiceException(e);
		}

	}

	@Override
	public void update() throws MindtreeMindsServiceException {
		System.out.println("Enter Mindtree Id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter New Phone Number");
		String phone = sc.nextLine();
		try {
			dao.update(id, phone);
		} catch (MindtreeMindsDaoException e) {
			throw new MindtreeMindsServiceException(e);
		}

	}

	@Override
	public void display() throws MindtreeMindsServiceException {
		System.out.println("Enter the Track Name");
		String track = sc.nextLine();
		try {
			dao.display(track);
		} catch (MindtreeMindsDaoException e) {
			throw new MindtreeMindsServiceException(e);
		}

	}

}
