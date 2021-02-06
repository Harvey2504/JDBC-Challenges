package com.mindtree.campusMindsProject.entity;

public class Track {
	private int trackId;
	private String trackName;
	private int numberOfMinds;

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTrackName() {
		return trackName;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public int getNumberOfMinds() {
		return numberOfMinds;
	}

	public void setNumberOfMinds(int numberOfMinds) {
		this.numberOfMinds = numberOfMinds;
	}

	public Track(int trackId, String trackName, int numberOfMinds) {
		super();
		this.trackId = trackId;
		this.trackName = trackName;
		this.numberOfMinds = numberOfMinds;
	}

	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}

}
