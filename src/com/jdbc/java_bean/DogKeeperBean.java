package com.jdbc.java_bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DogKeeperBean {
	
	Queue<String> queue = new LinkedList<>();
	List<String> KeeperList = new LinkedList<>();
	private String keeperId = "keeper_id";
	private String keeperFirstName = "fname";
	private String keeperLastName = "lname";

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
