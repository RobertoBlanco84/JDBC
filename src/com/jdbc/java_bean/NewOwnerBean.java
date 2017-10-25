package com.jdbc.java_bean;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NewOwnerBean {
	
	List<String> newOwnerList = new LinkedList<>();
	Queue<String> queue = new LinkedList<>();
	
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

	public String getOwnerId() {
		return ownerId;
	}

	public String getOwnerFirstName() {
		return ownerFirstName;
	}

	public String getOwnerLastName() {
		return ownerLastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}
