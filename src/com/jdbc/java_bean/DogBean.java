package com.jdbc.java_bean;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DogBean {
	
	List<String> list= new LinkedList<>();
	Queue<String> queue = new LinkedList<>();
	Deque<String> queues = new LinkedList<>();
	
	private String keeper = "keeper";
	private String dogName = "name";
	private String dogGender = "gender";
	private String dogRace = "race";
	private String adoptionId = "adoption_id";
	
	public List<String> getDogList(){
		list.add(keeper);
		list.add(dogName);
		list.add(dogGender);
		list.add(dogRace);
		list.add(adoptionId);
		return list;
	}
	
	public Queue<String> getDogQueue() {
		queue.add(keeper);
		queue.add(dogName);
		queue.add(dogGender);
		queue.add(dogRace);
		queue.add(adoptionId);
		return queue;
	}
	
	public Deque<String> getDogDeque() {
		queues.add(keeper);
		queues.add(dogName);
		queues.add(dogGender);
		queues.add(dogRace);
		queues.add(adoptionId);
		return queues;
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
