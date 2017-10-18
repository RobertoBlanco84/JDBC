package com.jdbc.queries;

import com.jdbc.java_bean.DeletedOwnerBean;
import com.jdbc.java_bean.DogBean;
import com.jdbc.java_bean.DogKeeperBean;
import com.jdbc.java_bean.NewOwnerBean;
import com.jdbc.menu.Input;

public class Queries {
	NewOwnerBean newOwnerBean = new NewOwnerBean();
	DogBean dogBean = new DogBean();
	DogKeeperBean dogKeeperBean = new DogKeeperBean();
	DeletedOwnerBean deletedOwnerBean = new DeletedOwnerBean();

	private String keeper= dogKeeperBean.getKeeperId();
	private String dogName = dogBean.getDogName();
	private String dogGender = dogBean.getDogGender();
	private String dogRace = dogBean.getDogRace();
	private String adoptionId = dogBean.getAdoptionId();
	private String keeperId = dogKeeperBean.getKeeperId();
	private String keeperFirstName = dogKeeperBean.getKeeperFirstName();
	private String keeperLastName = dogKeeperBean.getKeeperLastName();
	private String ownerId = newOwnerBean.getOwnerId();
	private String ownerFirstName = newOwnerBean.getOwnerFirstName();
	private String ownerLastName = newOwnerBean.getOwnerLastName();
	private String socialSecurityNumber = newOwnerBean.getSocialSecurityNumber();
	private String phone_number = newOwnerBean.getPhoneNumber();

	//SELECT Queries
	public String selectDog() {
		String selectQuery = "SELECT * FROM dog";
		return selectQuery;
	}

	public String selectKeeper() {
		String selectQuery = "SELECT * FROM dog_keeper";
		return selectQuery;
	}

	public String selectNewOwner() {
		String selectQuery = "SELECT * FROM new_owner";
		return selectQuery;
	}

	public String selectDeletedOwners() {
		String selectQuery = "SELECT * FROM deletedOwners";
		return selectQuery;
	}
	//End of SELECT Queries

	//INSERT Queries
	public String insertDog() {
		String insertQuery = "INSERT INTO Dog ("+ dogBean.getDogList().get(0) + ", " +
				dogBean.getDogList().get(1) + ", " +
				dogBean.getDogList().get(2) + ", " + 
				dogBean.getDogList().get(3) + " ," 
				+ dogBean.getDogList().get(4) + ") VALUES (?,?,?,?,?)";
		return insertQuery;
	}

	public String displayDogInsert() {
		System.out.println("Inserted into 'Dog' table: ");
		String display = "SELECT "+ dogBean.getDogList().get(0) + ","  + 
				dogBean.getDogList().get(1) + ", " + 
				dogBean.getDogList().get(2) + "," + 
				dogBean.getDogList().get(3) + "," + 
				dogBean.getDogList().get(4) + " FROM Dog";

		return display;
	}

	public String insertKeeper() {
		String insertQuery = "INSERT INTO Dog_keeper ("+ dogKeeperBean.getKeeperList().get(1) + ", " 
				+ dogKeeperBean.getKeeperList().get(2) + ") VALUES (?,?)";
		return insertQuery;
	}

	public String displayKeeperInsert() {
		System.out.println("Inserted into 'Dog_keeper' table: ");
		String display = "SELECT "+ dogKeeperBean.getKeeperList().get(0) + "," + 
				dogKeeperBean.getKeeperList().get(1) + ", " + 
				dogKeeperBean.getKeeperList().get(2) + " FROM Dog_keeper";
		return display;
	}

	public String insertNewOwner() {
		String insertQuery = "INSERT INTO New_owner (" + newOwnerBean.getNewOwnerList().get(1) + ", " + 
				newOwnerBean.getNewOwnerList().get(2) + ", " + 
				newOwnerBean.getNewOwnerList().get(3) + ", " +
				newOwnerBean.getNewOwnerList().get(4) + ") VALUES(?,?,?,?)";
		return insertQuery;
	}

	public String displayNewOwner() {
		System.out.println("Inserted into 'New_owner' table: ");
		String display = "SELECT "+ newOwnerBean.getNewOwnerList().get(0) + "," + 
				newOwnerBean.getNewOwnerList().get(1) + ", " + 
				newOwnerBean.getNewOwnerList().get(2)+ "," + 
				newOwnerBean.getNewOwnerList().get(3) 
				+ " ," + phone_number+ " FROM New_owner";
		return display;
	}
	//End of INSERT Queries

	//UPDATE Queries
	public String updateDog() {
		String updateQuery = "UPDATE Dog SET "+dogBean.getDogList().get(0)+"=?, " +
				dogBean.getDogList().get(1) + "=?, " +
				dogBean.getDogList().get(2) + "=?,"  + 
				dogBean.getDogList().get(3) + "=?, " + 
				dogBean.getDogList().get(4) + "=? WHERE keeper="+Input.getId()+"";
		return updateQuery;    
	}

	public String updateKeeper() {
		String updateQuery = "UPDATE Dog_keeper SET "+ dogKeeperBean.getKeeperList().get(1) +"=?," +
				dogKeeperBean.getKeeperList().get(2) 
				+"=? WHERE keeper_id="+Input.getId()+"";
		return updateQuery;    
	}

	public String updateNewOwner() {
		String updateQuery = "UPDATE New_owner SET "+newOwnerBean.getNewOwnerList().get(1)+"=?, " + 
				newOwnerBean.getNewOwnerList().get(2) +"=?, " 
				+newOwnerBean.getNewOwnerList().get(3) +"=?, "
				+newOwnerBean.getNewOwnerList().get(4)+"=? WHERE owner_id="+Input.getId()+"";
		return updateQuery;    
	}
	//End of UPDATE queries

	//DELETE Queries
	public String deleteKeeper() {
		String deleteQuery = "DELETE FROM Dog_keeper WHERE "+ keeper  +" = ?";
		return deleteQuery;    
	}

	public String deleteNewOwnerAndDog() {
		String deleteQuery = "DELETE FROM New_owner WHERE "+ ownerId  +" = ?";
		return deleteQuery;    
	}

	//Search query
	public String searchNewOwner() {
		String searchQuery = "SELECT * FROM New_owner where owner_id = " +Input.getId()+"";
		return searchQuery;
	}
}