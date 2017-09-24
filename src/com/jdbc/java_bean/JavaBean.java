package com.jdbc.java_bean;

public class JavaBean {
	
	private String dogId = "dog_id";
	private String dogName = "name";
	private String dogGender = "gender";
	private String dogRace = "race";
	private String newDogOwner = "new_owner";
	
	private String keeperId = "keeper_id";
	private String keeperFirstName;
	private String keeperLastName;
	
	private String ownerId = "owner_id";
	private String ownerFirstName = "fname";
	private String ownerLastName = "lname";
	private String phoneNumber = "phone_number";
	
	public String getDogId() {
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
	public String getNewDogOwner() {
		return newDogOwner;
	}
	public String getKeeperId() {
		return keeperId;
	}
	public String getKeeperFirstName() {
		return keeperFirstName;
	}
	public String getKeeperLastName() {
		return keeperLastName;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public String getOwnerFirstName() {
		return ownerFirstName;
	}
	public String getOwnerLastName() {
		return ownerLastName;
	}
	public String getOwnerPhoneNumber() {
		return phoneNumber;
	}
	
}
