package com.jdbc.java_bean;

/**a Javabean class for the entity table "dog",
 *containing private fields with the Dog table columns' name
 *and getters/setter to each field
 * @author marianna
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DogBean {
	
	List<String> list= new LinkedList<>();
	Queue<String> queue = new LinkedList<>();
	
	private String keeper = "keeper";
	private String dogName = "name";
	private String dogGender = "gender";
	private String dogRace = "race";
	private String adoptionId = "adoption_id";
	
	
	/**
	 * a list containing all "dog" table's attributes 
	 * @return a list of row/s in "dog" table  
	 */
	public List<String> getDogList(){
		list.add(keeper);
		list.add(dogName);
		list.add(dogGender);
		list.add(dogRace);
		list.add(adoptionId);
		return list;
	}
	
	/**
	 * A Queue containing all "dog" table's attributes
	 *except first attribute since it is auto increment,
	 * @return a queue, one row, in  "dog"
	 */
	public Queue<String> getDogQueue() {
		queue.add(keeper);
		queue.add(dogName);
		queue.add(dogGender);
		queue.add(dogRace);
		queue.add(adoptionId);
		return queue;
	}
		
	/**
	 * a set of getters/setter for all private fields
	 * @return
	 */
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

}
