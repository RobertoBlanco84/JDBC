package com.jdbc.java_bean;
import java.util.LinkedList;
import java.util.List;

public class DeletedOwnerBean {

	List<String> deletedOwnerList = new LinkedList<>();
	private String ownerId = "owner_id";
	private String ownerFirstName = "fname";
	private String ownerLastName = "lname";
	private String socialSecurityNumber = "ss_number";
	private String phoneNumber = "phone_number";
	private String dateTime = "date_time";

	public List<String> getDeletedOwnerList() {
		deletedOwnerList.add(ownerId);
		deletedOwnerList.add(ownerFirstName);
		deletedOwnerList.add(ownerLastName);
		deletedOwnerList.add(socialSecurityNumber);
		deletedOwnerList.add(phoneNumber);
		deletedOwnerList.add(dateTime);
		return deletedOwnerList;
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

	public String getDateTime() {
		return dateTime;
	}
	

}
