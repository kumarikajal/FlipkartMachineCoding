package com.flipkart.entity;

public class User {
	
	String email;
	String userName;
	String vaccineType;
	int slotsBooked;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getVaccineType() {
		return vaccineType;
	}
	public void setVaccineType(String vaccineType) {
		this.vaccineType = vaccineType;
	}
	public int getSlotsBooked() {
		return slotsBooked;
	}
	public void setSlotsBooked(int slotsBooked) {
		this.slotsBooked = slotsBooked;
	}
	public User(String email, String userName, String vaccineType, int slotsBooked) {
		super();
		this.email = email;
		this.userName = userName;
		this.vaccineType = vaccineType;
		this.slotsBooked = slotsBooked;
	}
	
	
	

}
