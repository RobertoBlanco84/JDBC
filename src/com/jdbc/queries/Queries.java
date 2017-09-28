package com.jdbc.queries;

import com.jdbc.java_bean.JavaBean;

public class Queries {

	JavaBean javaBean = new JavaBean();
	private String keeper= javaBean.getKeeper();
	private String dogName = javaBean.getDogName();
	private String dogGender = javaBean.getDogGender();
	private String dogRace = javaBean.getDogRace();
	private String adoptionId = javaBean.getAdoptionId();
	private String keeperId = javaBean.getKeeperId();
	private String keeperFirstName = javaBean.getKeeperFirstName();
	private String keeperLastName = javaBean.getKeeperLastName();
	private String ownerId = javaBean.getOwnerId();
	private String ownerFirstName = javaBean.getOwnerFirstName();
	private String ownerLastName = javaBean.getOwnerLastName();
	private String socialSecurityNumber = javaBean.getSSNumber();
	private String phone_number = javaBean.getOwnerPhoneNumber();

	//SELECT Queries
	public String selectDog(String selectQuery) {
		selectQuery = "SELECT * FROM dog";
		return selectQuery;
	}

	public String selectKeeper(String selectQuery) {
		selectQuery = "SELECT * FROM dog_keeper";
		return selectQuery;
	}

	public String selectNewOwner(String selectQuery) {
		selectQuery = "SELECT * FROM new_owner";
		return selectQuery;
	}
	//End of SELECT Queries

	//INSERT Queries
	public String insertDog(String insertQuery) {
		insertQuery = "INSERT INTO Dog ("+ keeper + ", "+ dogName + ", " + dogGender +
				", " + dogRace + " ," + adoptionId + ") VALUES (?,?,?,?,?)";
		return insertQuery;
	}

	public String displayDogInsert(String display) {
		System.out.println("Inserted into 'Dog' table: ");
		display = "SELECT "+ keeper + "," + dogName + ", "+ dogGender +
				"," + dogRace + "," + adoptionId + " FROM Dog";

		return display;
	}
	
	public String insertKeeper(String insertQuery) {
		insertQuery = "INSERT INTO Dog_keeper ("+ keeperFirstName + ", " + keeperLastName + ") VALUES (?,?)";
		return insertQuery;
	}
	
	public String displayKeeperInsert(String display) {
		System.out.println("Inserted into 'Dog_keeper' table: ");
		display = "SELECT "+ keeperId + "," + keeperFirstName + ", "+ keeperLastName + " FROM Dog_keeper";
		return display;
	}
	
	public String insertNewOwner(String insertQuery) {
		insertQuery = "INSERT INTO New_owner (" + ownerFirstName + ", " + ownerLastName + ", " 
				+ socialSecurityNumber + ", " + phone_number + ") VALUES(?,?,?,?)";
		return insertQuery;
	}
	
	public String displayNewOwner(String display) {
		System.out.println("Inserted into 'New_owner' table: ");
		display = "SELECT "+ ownerId + "," +ownerFirstName + ", "+ ownerLastName+ "," + socialSecurityNumber 
				+ " ," + phone_number+ " FROM New_owner";
		return display;
	}
	//End of INSERT Queries
	
	//UPDATE Queries
	public String updateDog(String updateQuery) {
		 updateQuery = "UPDATE Dog SET keeper=? WHERE name='Tracy'";
		return updateQuery;	
	}
	
	public String updateKeeper(String updateQuery) {
		 updateQuery = "UPDATE Dog_keeper SET fname=?,lname=? WHERE keeper_id=8";
		return updateQuery;	
	}
	
	public String updateNewOwner(String updateQuery) {
		updateQuery = "UPDATE New_owner SET fname=?,lname=? WHERE owner_id=10";
		return updateQuery;	
	}
	//End of UPDATE queries
	
	//DELETE Queries
	public String deleteKeeper(String deleteQuery) {
		deleteQuery = "DELETE FROM New_owner WHERE "+ keeperId +" = ?";
		return deleteQuery;	
	}
	
	public String deleteNewOwnerAndDog(String deleteQuery) {
		deleteQuery = "DELETE FROM New_owner WHERE "+ ownerId  +" = ?";
		return deleteQuery;	
	}
}
