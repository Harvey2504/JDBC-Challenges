package com.mindtree.campusMindsProject.entity;

public class MindtreeMinds {
	private int mindId;
	private String name;
	private int trackId;
	private String phone;
	private String role;

	public MindtreeMinds(int mindId, String name, int trackId, String phone, String role) {
		super();
		this.mindId = mindId;
		this.name = name;
		this.trackId = trackId;
		this.phone = phone;
		this.role = role;
	}

	public MindtreeMinds() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMindId() {
		return mindId;
	}

	public void setMindId(int mindId) {
		this.mindId = mindId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
