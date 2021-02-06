package com.mindtree.CollegeApp.service.serviceImpl;

import java.util.Scanner;

import com.mindtree.CollegeApp.customException.dao.CollegeDaoException;
import com.mindtree.CollegeApp.customException.service.CollegeServiceException;
import com.mindtree.CollegeApp.dao.daoImpl.CollegeDaoImpl;
import com.mindtree.CollegeApp.entity.College;
import com.mindtree.CollegeApp.entity.Student;
import com.mindtree.CollegeApp.service.CollegeService;

public class CollegeServiceImpl implements CollegeService {
	static Scanner sc = new Scanner(System.in);
	static CollegeDaoImpl dao = new CollegeDaoImpl();

	@Override
	public void insertCollege() throws CollegeServiceException {
		System.out.println("Enter College Id");
		int collegeId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter College Name");
		String collegeName = sc.nextLine();
		int totalStrength = 0;

		College college = new College();
		college = new College(collegeId, collegeName, totalStrength);
		try {
			dao.insertCollege(college);
		} catch (CollegeDaoException e) {
			throw new CollegeServiceException(e);
		}

	}

	@Override
	public void insertStudent() throws CollegeServiceException {
		System.out.println("Enter Student Id");
		int studentId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Student Name");
		String studentName = sc.nextLine();
		System.out.println("Enter Age");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Subject Id\n1.Arts 2.Science 3.Commerce");
		int subjectId = sc.nextInt();
		System.out.println("Enter College Id");
		int collegeId = sc.nextInt();
		try {
			College college = dao.getCollegeById(collegeId);
			Student student = new Student();
			student = new Student(studentId, studentName, age, subjectId, college);
			dao.insertStudent(student);
			dao.updateTotalStrength(college);
		} catch (CollegeDaoException e) {
			throw new CollegeServiceException(e);
		}

	}

	@Override
	public void display() throws CollegeServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void search() throws CollegeServiceException {
		System.out.println("Enter College Name");
		String collegeName = sc.nextLine();
		System.out.println("Enter Subject\n1.Arts 2.Science 3.Commerce");
		int subjectId = sc.nextInt();
		try {
			dao.search(collegeName, subjectId);
		} catch (CollegeDaoException e) {
			throw new CollegeServiceException(e);
		}

	}

}
