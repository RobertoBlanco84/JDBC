package com.jdbc.java_bean;

import java.util.LinkedList;
import java.util.List;

public class DogKeeperBean {

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

	public void setKeeperList(List<String> KeeperList) {
		this.KeeperList = KeeperList;
	}

	public String getKeeperId() {
		return keeperId;
	}

	public void setKeeperId(String keeperId) {
		this.keeperId = keeperId;
	}

	public String getKeeperFirstName() {
		return keeperFirstName;
	}

	public void setKeeperFirstName(String keeperFirstName) {
		this.keeperFirstName = keeperFirstName;
	}

	public String getKeeperLastName() {
		return keeperLastName;
	}

	public void setKeeperLastName(String keeperLastName) {
		this.keeperLastName = keeperLastName;
	}

}
