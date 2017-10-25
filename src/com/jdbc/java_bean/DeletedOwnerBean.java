package com.jdbc.java_bean;
/**
 * a Javabean class for the entity table "Deleted_owner",
 * containing private fields with the Dog table columns' name
 * and getters/setter to each field
 * @author marianna
 */


import java.util.LinkedList;
import java.util.List;

public class DeletedOwnerBean {

	private List<String> deletedOwnerList = new LinkedList<>();
	private String ownerId = "owner_id";
	private String ownerFirstName = "fname";
	private String ownerLastName = "lname";
	private String socialSecurityNumber = "ss_number";
	private String phoneNumber = "phone_number";
	private String dateTime = "date_time";

	
	/**
	 * a list containing all "deleted_owner" table's attributes 
	 * @return a list of row/s in "deleted_owners" table  
	 */
	public List<String> getDeletedOwnerList() {
		deletedOwnerList.add(ownerId);
		deletedOwnerList.add(ownerFirstName);
		deletedOwnerList.add(ownerLastName);
		deletedOwnerList.add(socialSecurityNumber);
		deletedOwnerList.add(phoneNumber);
		deletedOwnerList.add(dateTime);
		return deletedOwnerList;
	}
	
	/**
	 * a set of getters/setter for all private fields
	 * @return
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

	public String getDateTime() {
		return dateTime;
	}

	public void setDeletedOwnerList(List<String> deletedOwnerList) {
		this.deletedOwnerList = deletedOwnerList;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public void setOwnerFirstName(String ownerFirstName) {
		this.ownerFirstName = ownerFirstName;
	}

	public void setOwnerLastName(String ownerLastName) {
		this.ownerLastName = ownerLastName;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	

}
