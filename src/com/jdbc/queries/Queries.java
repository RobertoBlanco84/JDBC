package com.jdbc.queries;

import com.jdbc.java_bean.JavaBean;
import com.jdbc.menu.Input;

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
	//End of SELECT Queries

	//INSERT Queries
	public String insertDog() {
		String insertQuery = "INSERT INTO Dog ("+ keeper + ", "+ dogName + ", " + dogGender +
				", " + dogRace + " ," + adoptionId + ") VALUES (?,?,?,?,?)";
		return insertQuery;
	}

	public String displayDogInsert() {
		System.out.println("Inserted into 'Dog' table: ");
		String display = "SELECT "+ keeper + "," + dogName + ", "+ dogGender +
				"," + dogRace + "," + adoptionId + " FROM Dog";

		return display;
	}
	
	public String insertKeeper() {
		String insertQuery = "INSERT INTO Dog_keeper ("+ keeperFirstName + ", " + keeperLastName + ") VALUES (?,?)";
		return insertQuery;
	}
	
	public String displayKeeperInsert() {
		System.out.println("Inserted into 'Dog_keeper' table: ");
		String display = "SELECT "+ keeperId + "," + keeperFirstName + ", "+ keeperLastName + " FROM Dog_keeper";
		return display;
	}
	
	public String insertNewOwner() {
		String insertQuery = "INSERT INTO New_owner (" + ownerFirstName + ", " + ownerLastName + ", " 
				+ socialSecurityNumber + ", " + phone_number + ") VALUES(?,?,?,?)";
		return insertQuery;
	}
	
	public String displayNewOwner() {
		System.out.println("Inserted into 'New_owner' table: ");
		String display = "SELECT "+ ownerId + "," +ownerFirstName + ", "+ ownerLastName+ "," + socialSecurityNumber 
				+ " ," + phone_number+ " FROM New_owner";
		return display;
	}
	//End of INSERT Queries
	
	//UPDATE Queries
	public String updateDog() {
		String updateQuery = "UPDATE Dog SET "+keeper+"=?, "+dogName+"=?, "+dogGender+"=?,"
		 		+ " "+dogRace+"=?, "+ adoptionId+"=? WHERE keeper="+Input.getId()+"";
		return updateQuery;	
	}
	
	public String updateKeeper() {
		String updateQuery = "UPDATE Dog_keeper SET "+ keeperFirstName +"=?," + keeperLastName 
				 +"=? WHERE keeper_id="+Input.getId()+"";
		return updateQuery;	
	}
	
	public String updateNewOwner() {
		String updateQuery = "UPDATE New_owner SET "+ownerFirstName+"=?, "+ownerLastName
				+"=?, "+socialSecurityNumber +"=?, "+phone_number+"=? WHERE owner_id="+Input.getId()+"";
		return updateQuery;	
	}
	//End of UPDATE queries
	
	//DELETE Queries
	public String deleteKeeper() {
		String deleteQuery = "DELETE FROM Dog_keeper WHERE "+ keeperId +" = ?";
		return deleteQuery;	
	}
	
	public String deleteNewOwnerAndDog() {
		String deleteQuery = "DELETE FROM New_owner WHERE "+ ownerId  +" = ?";
		return deleteQuery;	
	}
}
