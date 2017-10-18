package com.jdbc.java_bean;

import java.util.LinkedList;
import java.util.List;

public class DogBean {
	List<String> DogList = new LinkedList<>();
	private String keeper = "keeper";
	private String dogName = "name";
	private String dogGender = "gender";
	private String dogRace = "race";
	private String adoptionId = "adoption_id";

	public List<String> getDogList() {
		DogList.add(keeper);
		DogList.add(dogName);
		DogList.add(dogGender);
		DogList.add(dogRace);
		DogList.add(adoptionId);
		return DogList;
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
