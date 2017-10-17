package com.jdbc.java_bean;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class JavaBean {
	List<String> list = new LinkedList<>();
	private String keeper = "keeper";
	private String dogName = "name";
	private String dogGender = "gender";
	private String dogRace = "race";
	private String adoptionId = "adoption_id";
	
	private String keeperId = "keeper_id";
	private String keeperFirstName = "fname";
	private String keeperLastName = "lname";
	
	private String ownerId = "owner_id";
	private String ownerFirstName = "fname";
	private String ownerLastName = "lname";
	private String socialSecurityNumber = "ss_number";
	private String phoneNumber = "phone_number";
	private String dateTime = "date_time";
	
	public List<String> getDogList() {
		list.add(keeper);
		list.add(dogName);
		list.add(dogGender);
		list.add(dogRace);
		list.add(adoptionId);
		/*for(int i = 0; i <list.size(); i++) {
			list.get(i);
		}*/
		//list.toString();
		return list;
	}
	
	
	public List<String> getKeeperList(){
		list.add(keeperId);
		list.add(keeperFirstName);
		list.add(keeperLastName);
		return list;
	}
	
	public List<String> getOwnerList(){
		list.add(ownerId);
		list.add(ownerFirstName);
		list.add(ownerLastName);
		list.add(socialSecurityNumber);
		list.add(phoneNumber);
		list.add(dateTime);
		return list;
	}
	
	public String getKeeper() {
		return keeper;
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
	public String getAdoptionId() {
		return adoptionId;
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
	
	public String getSSNumber() {
		return socialSecurityNumber;
	}
	
	public String getOwnerPhoneNumber() {
		return phoneNumber;
	}
	
	public String getDateTime() {
		return dateTime;
	}
}
