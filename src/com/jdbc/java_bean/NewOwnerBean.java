package com.jdbc.java_bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * A Javabean class for the entity table "NewOwnerBean",
 * containing private fields with the Dog table columns' name
 * and getters/setter to each field
 * @author RobertoBlanco
 *
 */
public class NewOwnerBean {
	
	private List<String> newOwnerList = new LinkedList<>();
	private Queue<String> queue = new LinkedList<>();
	private String ownerId = "owner_id";
	private String ownerFirstName = "fname";
	private String ownerLastName = "lname";
	private String socialSecurityNumber = "ss_number";
	private String phoneNumber = "phone_number";
	
	/**
	 * A list containing all "New_owner" table's attributes
	 * @return a list of row/s in "New_owner"
	 */
	public List<String> getNewOwnerList() {
		newOwnerList.add(ownerId);
		newOwnerList.add(ownerFirstName);
		newOwnerList.add(ownerLastName);
		newOwnerList.add(socialSecurityNumber);
		newOwnerList.add(phoneNumber);
		return newOwnerList;
	}
	
	/**
	 * A Queue containing all "New_owner" table's attributes
	 * , except first attribute since it is auto increment,
	 * @return a queue, one row, in  "New_owner"
	 */
	public Queue<String> getNewOwnerQueue(){
		queue.add(ownerFirstName);
		queue.add(ownerLastName);
		queue.add(socialSecurityNumber);
		queue.add(phoneNumber);
		return queue;
	}
	
	/**
	 * A set of getters for private fields
	 * @return ownerId, ownerFirstName, ownerLastName, socialSecurityNumber and phoneNumber
	 */
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
