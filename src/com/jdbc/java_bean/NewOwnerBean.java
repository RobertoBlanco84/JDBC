package com.jdbc.java_bean;

import java.util.LinkedList;
import java.util.List;

public class NewOwnerBean {

	List<String> newOwnerList = new LinkedList<>();
	private String ownerId = "owner_id";
	private String ownerFirstName = "fname";
	private String ownerLastName = "lname";
	private String socialSecurityNumber = "ss_number";
	private String phoneNumber = "phone_number";

	public List<String> getNewOwnerList() {
		newOwnerList.add(ownerId);
		newOwnerList.add(ownerFirstName);
		newOwnerList.add(ownerLastName);
		newOwnerList.add(socialSecurityNumber);
		newOwnerList.add(phoneNumber);
		return newOwnerList;
	}

	public void setNewOwnerList(List<String> newOwnerList) {
		newOwnerList = newOwnerList;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}