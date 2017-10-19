package com.jdbc.java_bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DogBean {
	List<String> dogList = new LinkedList<>();
	Queue<String> que = new LinkedList<>();
	
	private String keeper = "keeper";
	private String dogName = "name";
	private String dogGender = "gender";
	private String dogRace = "race";
	private String adoptionId = "adoption_id";

	public List<String> getDogList() {
		dogList.add(keeper);
		dogList.add(dogName);
		dogList.add(dogGender);
		dogList.add(dogRace);
		dogList.add(adoptionId);
		return dogList;
	}
	public Queue<String> getDogQueue() {
		que.add(keeper);
		que.add(dogName);
		que.add(dogGender);
		que.add(dogRace);
		que.add(adoptionId);
		return que;
	}

	public String getKeeper() {
		return keeper;
	}

	public void setKeeper(String keeper) {
		this.keeper = keeper;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getDogGender() {
		return dogGender;
	}

	public void setDogGender(String dogGender) {
		this.dogGender = dogGender;
	}

	public String getDogRace() {
		return dogRace;
	}

	public void setDogRace(String dogRace) {
		this.dogRace = dogRace;
	}

	public String getAdoptionId() {
		return adoptionId;
	}

	public void setAdoptionId(String adoptionId) {
		this.adoptionId = adoptionId;
	}

}
