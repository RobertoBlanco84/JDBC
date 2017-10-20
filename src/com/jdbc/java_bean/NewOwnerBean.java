package com.jdbc.java_bean;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NewOwnerBean {

	List<String> newOwnerList = new LinkedList<>();
	Queue<String> queue = new LinkedList<>();
	
	Deque<String> deQue = new LinkedList<>();	
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
	
	public Queue<String> getNewOwnerQueue(){
		//newOwnerList.add(ownerId);
		queue.add(ownerFirstName);
		queue.add(ownerLastName);
		queue.add(socialSecurityNumber);
		queue.add(phoneNumber);
		return queue;
	}

	public void setNewOwnerList(List<String> newOwnerList) {
		this.newOwnerList = newOwnerList;
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
