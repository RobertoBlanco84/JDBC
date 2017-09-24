package com.jdbc.mysql_logic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.PreparedStatement;

import com.jdbc.java_bean.JavaBean;



public class Queries {

	private JavaBean javaBean = new JavaBean();
	private String url = "jdbc:mysql://localhost:3306/dog_shelter";
	private String user = "root";
	private String password = "";


	private String dogId= javaBean.getDogId();
	private String dogName = javaBean.getDogName();
	private String dogGender = javaBean.getDogGender();
	private String dogRace = javaBean.getDogRace();
	private String newDogOwner = javaBean.getNewDogOwner();

	private String keeperId = javaBean.getKeeperId();
	private String keeperFirstName = javaBean.getKeeperFirstName();
	private String keeperLastName = javaBean.getKeeperLastName();

	private String ownerId = javaBean.getOwnerId();
	private String ownerFirstName = javaBean.getOwnerFirstName();
	private String ownerLastName = javaBean.getOwnerLastName();
	private String phone_number = javaBean.getOwnerPhoneNumber();
	
	// SELECT methods
	public void selectDog() throws SQLException{
		Connection connection;
		Statement statement;
		ResultSet resultSet;

		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();
		String selectQuery = "SELECT * FROM dog";	
		resultSet = statement.executeQuery(selectQuery);

		while(resultSet.next()) {
			System.out.println(resultSet.getInt(dogId) + " " + resultSet.getString(dogName) + " " +
					resultSet.getString(dogGender) + " " + resultSet.getString(dogRace) + " " + 												resultSet.getInt(newDogOwner));
		}
	}
	
	public void selectKeeper() throws SQLException{
		Connection connection;
		Statement statement;
		ResultSet resultSet;

		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();
		String selectQuery = "SELECT * FROM Dog_keeper";	
		resultSet = statement.executeQuery(selectQuery);

		while(resultSet.next()) {
			System.out.println(resultSet.getInt(keeperId) + " " + resultSet.getString(keeperFirstName) + " " +
					resultSet.getString(keeperLastName));
		}
	}
	
	public void selectNewOwner() throws SQLException{
		Connection connection;
		Statement statement;
		ResultSet resultSet;

		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();
		String selectQuery = "SELECT * FROM new_owner";	
		resultSet = statement.executeQuery(selectQuery);

		while(resultSet.next()) {
			System.out.println(resultSet.getInt(ownerId) + " " + resultSet.getString(ownerFirstName) + " " +
					resultSet.getString(ownerLastName) + " " + resultSet.getInt(phone_number));
		}
	}
	//End of SELECT methods
	
	//INSERT methods
	public void insertDog() throws SQLException {
		Connection connection;
		PreparedStatement preparedStmt;
		PreparedStatement preparedStmtSelect;
		ResultSet resultSet;


		connection = DriverManager.getConnection(url,user,password);


		String insertQuery = "INSERT INTO Dog ("+ dogName + ", " + dogGender +
				", " + dogRace + " ," + newDogOwner+ ") VALUES (?,?,?,?)";


		preparedStmt = connection.prepareStatement(insertQuery);
		preparedStmt.setString(1, "Jackie");
		preparedStmt.setString(2, "female");
		preparedStmt.setString(3, "Terrier");
		preparedStmt.setInt(4, 7);
		preparedStmt.executeUpdate();

		System.out.println("Inserted into 'Dog' table: ");
		String selectQuery = "SELECT "+ dogId + "," + dogName + ", "+ dogGender + "," + dogRace + "," + newDogOwner + " FROM 									  Dog";
		preparedStmtSelect = connection.prepareStatement(selectQuery);
		resultSet = preparedStmtSelect.executeQuery();

		if(resultSet.last()) {
			System.out.println(resultSet.getInt(dogId) + " " + resultSet.getString(dogName) + " " +
					resultSet.getString(dogGender) + " " + resultSet.getString(dogRace) + " " +  												resultSet.getInt(newDogOwner));

		}

	}
	
	public void insertKeeper() throws SQLException {
		Connection connection;
		PreparedStatement preparedStmt;
		PreparedStatement preparedStmtSelect;
		ResultSet resultSet;


		connection = DriverManager.getConnection(url,user,password);


		String insertQuery = "INSERT INTO Dog_keeper ("+ keeperFirstName + ", " + keeperLastName + ") VALUES (?,?)";


		preparedStmt = connection.prepareStatement(insertQuery);
		preparedStmt.setString(1, "Lowe");
		preparedStmt.setString(2, "Karlsson");
		preparedStmt.executeUpdate();

		System.out.println("Inserted into 'Dog_keeper' table: ");
		String selectQuery = "SELECT "+ keeperId + "," + keeperFirstName + ", "+ keeperLastName + " FROM Dog_keeper";
		preparedStmtSelect = connection.prepareStatement(selectQuery);
		resultSet = preparedStmtSelect.executeQuery();

		if(resultSet.last()) {
			System.out.println(resultSet.getInt(keeperId) + " " + resultSet.getString(keeperFirstName) + " " +
					resultSet.getString(keeperLastName));

		}

	}
	
	public void insertNewOwner() throws SQLException {
		Connection connection;
		PreparedStatement preparedStmt;
		PreparedStatement preparedStmtSelect;
		ResultSet resultSet;


		connection = DriverManager.getConnection(url,user,password);


		String insertQuery = "INSERT INTO New_owner (" + ownerId + ", " + ownerFirstName + ", " + ownerLastName +
				", " + phone_number + ") VALUES(?,?,?,?)";


		preparedStmt = connection.prepareStatement(insertQuery);
		preparedStmt.setInt(1, 19);
		preparedStmt.setString(2, "Börje");
		preparedStmt.setString(3, "Salming");
		preparedStmt.setInt(4, 11223344);
		preparedStmt.executeUpdate();

		System.out.println("Inserted into 'New_owner' table: ");
		String selectQuery = "SELECT "+ ownerId + "," +ownerFirstName + ", "+ ownerLastName+ "," + phone_number+ " FROM 									  New_owner";
		preparedStmtSelect = connection.prepareStatement(selectQuery);
		resultSet = preparedStmtSelect.executeQuery();

		if(resultSet.last()) {
			System.out.println(resultSet.getInt(ownerId) + " " + resultSet.getString(ownerFirstName) + " " +
					resultSet.getString(ownerLastName) + " " + resultSet.getInt(phone_number));

		}

	}
	//End of Insert methods
	
public void delete() throws SQLException {
		Connection connection;
		PreparedStatement preparedStatement;

		connection = DriverManager.getConnection(url,user,password);
		String deleteQuery = "DELETE FROM New_owner WHERE "+ ownerId +" = ?";
		preparedStatement = connection.prepareStatement(deleteQuery);
		preparedStatement.setInt(1, 19);
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows+" row(s) deleted.");

	}

	public void update() throws SQLException {
		Connection connection;
		PreparedStatement preparedStatement;
		connection = DriverManager.getConnection(url,user,password);
		String updateQuery = "UPDATE New_owner SET lname=? WHERE owner_id=18";
		preparedStatement = connection.prepareStatement(updateQuery);
		preparedStatement.setString(1, "Troeng");
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows + " row(s) updated.");

	}

	//Stored procedure
	public void dogCount() throws SQLException {
		Connection connection;
		CallableStatement callableStatement;

		connection = DriverManager.getConnection(url,user,password);		
		callableStatement = connection.prepareCall("{call dog_count(?,?)}");

		callableStatement.setInt(1, 1);
		callableStatement.registerOutParameter(2, Types.INTEGER);

		callableStatement.executeQuery();
		int count = callableStatement.getInt(2);
		System.out.println("Number of dogs in table 'Dog': "  + count);

	}
}
