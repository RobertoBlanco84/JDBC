package com.jdbc.java_bean;

public class JavaBean {
	
	private int dogId;
	private String dogName;
	private String dogGender;
	private String dogRace;
	private int newDogOwner;
	
	private int keeperId;
	private String keeperFirstName;
	private String keeperLastName;
	
	private String owner_id = "owner_id";
	private String fname = "fname";
	private String lname = "lname";
	private String phone_number = "phone_number";
	
	public int getDogId() {
		return dogId;
	}
	public String getDogName() {
		return dogName;
	}
	public String getDogGender() {
		return dogGender;
	}
	public String getDogRace() {
		return dogRace;
	}
	public int getNewDogOwner() {
		return newDogOwner;
	}
	public int getKeeperId() {
		return keeperId;
	}
	public String getKeeperFirstName() {
		return keeperFirstName;
	}
	public String getKeeperLastName() {
		return keeperLastName;
	}
	public String getOwnerId() {
		return owner_id;
	}
	public String getOwnerFirstName() {
		return fname;
	}
	public String getOwnerLastName() {
		return lname;
	}
	public String getOwnerPhoneNumber() {
		return phone_number;
	}
	
}
