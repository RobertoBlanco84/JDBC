package com.jdbc.java_bean;

/**
 *a Javabean class for the entity table "dog_keeper",
 *containing private fields with the dog_keeper table columns' name
 *and getters/setter to each field
 * @author marianna
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DogKeeperBean {
	
	Queue<String> queue = new LinkedList<>();
	List<String> KeeperList = new LinkedList<>();
	private String keeperId = "keeper_id";
	private String keeperFirstName = "fname";
	private String keeperLastName = "lname";

	
	/**
	 * a list containing all "dog_keeper" table's attributes 
	 * @return a list of row/s in "dog_keeper" table  
	 */
	public List<String> getKeeperList() {
		KeeperList.add(keeperId);
		KeeperList.add(keeperFirstName);
		KeeperList.add(keeperLastName);
		return KeeperList;
	}
	public Queue<String> getDogKeeperQueue() {
		//queue.add(keeperId);
		queue.add(keeperFirstName);
		queue.add(keeperLastName);	
		return queue;
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

}
