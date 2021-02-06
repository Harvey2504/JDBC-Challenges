package com.mindtree.CollegeApp.entity;

public class College {
	private int collegeId;
	private String collegeName;
	private int totalStrength;

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public College(int collegeId, String collegeName, int totalStrength) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.totalStrength = totalStrength;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public int getTotalStrength() {
		return totalStrength;
	}

	public void setTotalStrength(int totalStrength) {
		this.totalStrength = totalStrength;
	}

}
