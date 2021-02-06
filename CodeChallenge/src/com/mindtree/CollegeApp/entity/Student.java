package com.mindtree.CollegeApp.entity;

public class Student {
	private int studentId;
	private String studentname;
	private int age;
	private int subjectId;
	private College college;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentId, String studentname, int age, int subjectId, College college) {
		super();
		this.studentId = studentId;
		this.studentname = studentname;
		this.age = age;
		this.subjectId = subjectId;
		this.college = college;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

}
