package com.jdbc.queries;

/**
 * This class implements and collects all required queries'
 * in the project and set them as variables to use them more
 * flexibly with the ConnectionHandler class 
 * instead of writing a whole sql query sentence and using it
 * 
 * @author marianna and RobertoBlanco
 * 
 */

import com.jdbc.java_bean.DeletedOwnerBean;
import com.jdbc.java_bean.DogBean;
import com.jdbc.java_bean.DogKeeperBean;
import com.jdbc.java_bean.NewOwnerBean;
import com.jdbc.menu.Input;
public class Queries {

	private NewOwnerBean newOwnerBean = new NewOwnerBean();
	private DogBean dogBean = new DogBean();
	private DogKeeperBean dogKeeperBean = new DogKeeperBean();
	private DeletedOwnerBean deletedOwnerBean = new DeletedOwnerBean();

	//SELECT Queries
	/**
	 * Contains (select * from dog) query
	 * @return the string selectQuery
	 */
	public String selectDog() {
		String selectQuery = "SELECT " + dogBean.getDogList().toString().replace("[", "").replace("]", "") +" FROM dog";
		return selectQuery;
	}
	
	/**
	 * Contains (select * from dogKeeper) query
	 * @return the string selectQuery
	 */
	public String selectKeeper() {
		String selectQuery = "SELECT " + dogKeeperBean.getKeeperList().toString().replace("[", "").replace("]", "") +" FROM dog_keeper";
		return selectQuery;
	}
	/**
	 * Contains (select * from New_owner) query
	 * @return the string selectQuery
	 */
	public String selectNewOwner() {
		String selectQuery = "SELECT * FROM new_owner";
		return selectQuery;
	}
	/**
	 * Contains (select * from deletedOwners) query
	 * @return the string selectQuery
	 */
	public String selectDeletedOwners() {
		String selectQuery = "SELECT * FROM deletedOwners";
		return selectQuery;
	}
	//End of SELECT Queries

	//INSERT Queries	
	/**
	 * Contains (insert into Dog) query
	 * @return the String insertQuery
	 */
	public String insertDog() {
		String insertQuery = "INSERT INTO Dog (" + dogBean.getDogQueue().toString().replace("[", "").replace("]", "")
				+ ") VALUES (?,?,?,?,?)";
		return insertQuery;
	}
	
	/**
	 * Contains message and (select * from Dog) query
	 * @return the string display
	 */
	public String displayDogInsert() {
		System.out.println("Inserted into 'Dog' table: ");
		String display = "SELECT " + dogBean.getDogQueue().
				toString().replace("[", "").replace("]", "") + " FROM dog";
		return display;
	}
	
	/**
	 * Contains (insert into Dog) query
	 * @return the string insertQuery
	 */
	public String insertKeeper() {
		String insertQuery = "INSERT INTO Dog_keeper ("+ dogKeeperBean.getDogKeeperQueue().
				toString().replace("[", "").replace("]", "") + ") VALUES (?,?)";
		return insertQuery;
	}
	
	/**
	 * Contains message and (select * from Dog_keeper) query
	 * @return the String display
	 */
	public String displayKeeperInsert() {
		System.out.println("Inserted into 'Dog_keeper' table: ");
		String display = "SELECT " + dogKeeperBean.getDogKeeperQueue().
				toString().replace("[", "").replace("]", "") +" FROM Dog_keeper";
		return display;
	}
	
	/**
	 * Contains (insert into New_owner) query
	 * @return the String insertQuery
	 */
	public String insertNewOwner() {
		String insertQuery = "INSERT INTO New_owner ("+ newOwnerBean.getNewOwnerQueue().
				toString().replace("[", "").replace("]", "") +") VALUES(?,?,?,?)";
		return insertQuery;
	}
	
	/**
	 * Contains message and (insert into New_owner) query
	 * @return the String display
	 */
	public String displayNewOwner() {
		System.out.println("Inserted into 'New_owner' table: ");
		String display = "SELECT "+newOwnerBean.getNewOwnerQueue().
				toString().replace("[", "").replace("]", "") +" FROM New_owner";
		return display;
	}
	//End of INSERT Queries

	//UPDATE Queries
	/**
	 * Contains (update Dog) query
	 * @return the String updateQuery
	 */
	public String updateDog() {
		String updateQuery = "UPDATE Dog SET "+ 
				dogBean.getDogName() +" = ?, "+ 
				dogBean.getDogGender() +"=?, "+
				dogBean.getDogRace()+"=?, " +
				dogBean.getAdoptionId()+"=?  WHERE keeper="+Input.getId();

		return updateQuery;    
	}
	
	/**
	 * Contains (update Dog_keeper) query
	 * @return the String updateQuery
	 */
	public String updateKeeper() {
		String updateQuery = "Update Dog_keeper SET " + dogKeeperBean.getKeeperFirstName() + "=?, "  +
				dogKeeperBean.getKeeperLastName() + "=? WHERE keeper_id="+Input.getId() ;
		return updateQuery;    
	}
	
	/**
	 * Contains (update New_owner) query
	 * @return the String updateQuery
	 */
	public String updateNewOwner() {
		String updateQuery = "UPDATE New_owner SET " + newOwnerBean.getOwnerFirstName() + "=?, " +
				newOwnerBean.getOwnerLastName() + "=?, " +
				newOwnerBean.getSocialSecurityNumber() + "=?, " +
				newOwnerBean.getPhoneNumber() + "=? WHERE owner_id =" +Input.getId();
		return updateQuery;    
	}
	//End of UPDATE queries

	//DELETE Queries
	/**
	 * Contains (delete from Dog_keeper) query
	 * @return the String deleteQuery
	 */
	public String deleteKeeper() {
		String deleteQuery = "DELETE FROM Dog_keeper WHERE "+ dogKeeperBean.getKeeperId()  +" = ?";
		return deleteQuery;    
	}
	
	/**
	 * Contains (delete from NewOwnerAndDog) query
	 * @return the String deleteQuery
	 */
	public String deleteNewOwnerAndDog() {
		String deleteQuery = "DELETE FROM New_owner WHERE "+ newOwnerBean.getOwnerId()  +" = ?";
		return deleteQuery;    
	}
	//End of DELETE queries

	//Search query
	/**
	 * Contains (select * from New_owner) query
	 * @return the String searchQuery
	 */
	public String searchNewOwner() {
		String searchQuery = "SELECT * FROM New_owner where owner_id = " +Input.getId()+"";
		return searchQuery;
	}
}