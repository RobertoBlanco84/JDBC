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

	//SELECT Queries
	public String selectDog() {
		String selectQuery = "SELECT " + dogBean.getDogList().toString().replace("[", "").replace("]", "") +" FROM dog";
		return selectQuery;
	}

	public String selectKeeper() {
		String selectQuery = "SELECT " + dogKeeperBean.getKeeperList().toString().replace("[", "").replace("]", "") +" FROM dog_keeper";
		//String selectQuery = "SELECT " + dogKeeperBean.getDogKeeperQueue().toString().replace("[", "").replace("]", "") + " FROM dog_keeper";
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
		String insertQuery = "INSERT INTO Dog (" + dogBean.getDogQueue().toString().replace("[", "").replace("]", "")
				+ ") VALUES (?,?,?,?,?)";
		return insertQuery;
	}

	public String displayDogInsert() {
		System.out.println("Inserted into 'Dog' table: ");
		String display = "SELECT " + dogBean.getDogQueue().
				toString().replace("[", "").replace("]", "") + " FROM dog";
		return display;
	}

	public String insertKeeper() {
		String insertQuery = "INSERT INTO Dog_keeper ("+ dogKeeperBean.getDogKeeperQueue().
				toString().replace("[", "").replace("]", "") + ") VALUES (?,?)";
		return insertQuery;
	}

	public String displayKeeperInsert() {
		System.out.println("Inserted into 'Dog_keeper' table: ");
		String display = "SELECT " + dogKeeperBean.getDogKeeperQueue().
				toString().replace("[", "").replace("]", "") +" FROM Dog_keeper";
		return display;
	}

	public String insertNewOwner() {
		String insertQuery = "INSERT INTO New_owner ("+ newOwnerBean.getNewOwnerQueue().
				toString().replace("[", "").replace("]", "") +") VALUES(?,?,?,?)";
		return insertQuery;
	}

	public String displayNewOwner() {
		System.out.println("Inserted into 'New_owner' table: ");
		String display = "SELECT "+newOwnerBean.getNewOwnerQueue().
				toString().replace("[", "").replace("]", "") +" FROM New_owner";
		return display;
	}
	//End of INSERT Queries

	//UPDATE Queries
	public String updateDog() {
		String updateQuery = "UPDATE Dog SET "+ 
				dogBean.getDogName() +" = ?, "+ 
				dogBean.getDogGender() +"=?, "+
				dogBean.getDogRace()+"=?, " +
				dogBean.getAdoptionId()+"=?  WHERE keeper="+Input.getId();

		return updateQuery;    
	}
	
	public String updateKeeper() {
		String updateQuery = "Update Dog_keeper SET " + dogKeeperBean.getKeeperFirstName() + "=?, "  +
				dogKeeperBean.getKeeperLastName() + "=? WHERE keeper_id="+Input.getId() ;
		return updateQuery;    
	}

	public String updateNewOwner() {
		String updateQuery = "UPDATE New_owner SET " + newOwnerBean.getOwnerFirstName() + "=?, " +
				newOwnerBean.getOwnerLastName() + "=?, " +
				newOwnerBean.getSocialSecurityNumber() + "=?, " +
				newOwnerBean.getPhoneNumber() + "=? WHERE owner_id =" +Input.getId();
		return updateQuery;    
	}
	//End of UPDATE queries

	//DELETE Queries
	public String deleteKeeper() {
		String deleteQuery = "DELETE FROM Dog_keeper WHERE "+ dogKeeperBean.getKeeperId()  +" = ?";
		return deleteQuery;    
	}

	public String deleteNewOwnerAndDog() {
		String deleteQuery = "DELETE FROM New_owner WHERE "+ newOwnerBean.getOwnerId()  +" = ?";
		return deleteQuery;    
	}

	//Search query
	public String searchNewOwner() {
		String searchQuery = "SELECT * FROM New_owner where owner_id = " +Input.getId()+"";
		return searchQuery;
	}
}