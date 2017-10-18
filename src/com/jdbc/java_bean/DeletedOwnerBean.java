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

	public void setDeletedOwnerList(List<String> deletedOwnerList) {
		this.deletedOwnerList = deletedOwnerList;
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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
