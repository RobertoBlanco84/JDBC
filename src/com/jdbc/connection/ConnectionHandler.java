package com.jdbc.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.LinkedList;
import java.sql.PreparedStatement;

import com.jdbc.java_bean.JavaBean;
import com.jdbc.menu.Input;
import com.jdbc.queries.Queries;


public class ConnectionHandler  {

	//Con
	private JavaBean javaBean = new JavaBean();
	private Queries queries = new Queries();
	private String url = "jdbc:mysql://localhost:3306/dog_shelter";
	private String user = "root";
	private String password = "";
	Connection connection;
	PreparedStatement preparedStmt;
	PreparedStatement preparedStmtSelect;
	Statement statement;
	CallableStatement callableStatement;
	ResultSet resultSet;
	LinkedList<String> list = new LinkedList<>();
	
	// SELECT connections
	public void  selectDog() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(queries.selectDog());

		while(resultSet.next()) {
			System.out.println(resultSet.getInt(javaBean.getKeeper()) + " " +
					resultSet.getString(javaBean.getDogName()) + " " +
					resultSet.getString(javaBean.getDogGender()) + " " + 
					resultSet.getString(javaBean.getDogRace()) + " " + 
					resultSet.getInt(javaBean.getAdoptionId()));
		}
	}

	public void selectKeeper() throws SQLException{
		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(queries.selectKeeper());
		String id = javaBean.getKeeperId();
		String fname = javaBean.getKeeperFirstName();
		String lname = javaBean.getKeeperLastName();
		list.add(id);
		list.add(fname);
		list.add(lname);

		while(resultSet.next()) {

			System.out.println(resultSet.getInt(id) + " : " + 
					resultSet.getString(fname)+ " : " + 
					resultSet.getString(lname));
			/*	for(int i=0 ; i<list.size(); i++) {
				resultSet.getString(list.get(i));
				System.out.println(i);
			}*/

			/*System.out.println(resultSet.getInt(javaBean.getKeeperId()) + " " + 
					resultSet.getString(javaBean.getKeeperFirstName()) + " " +
					resultSet.getString(javaBean.getKeeperLastName()));*/


		}
	}

	public void selectNewOwner() throws SQLException{
		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();	
		resultSet = statement.executeQuery(queries.selectNewOwner());

		while(resultSet.next()) {
			System.out.println(resultSet.getInt(javaBean.getOwnerId()) + " " + 
					resultSet.getString(javaBean.getOwnerFirstName()) + " " +
					resultSet.getString(javaBean.getOwnerLastName()) + " " + 
					resultSet.getString(javaBean.getSSNumber()) + " " +
					resultSet.getString(javaBean.getOwnerPhoneNumber()));
		}
	}

	public void selectDeletedOwners() throws SQLException{
		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();	
		resultSet = statement.executeQuery(queries.selectDeletedOwners());

		while(resultSet.next()) {
			System.out.println(resultSet.getInt(javaBean.getOwnerId()) + " " + 
					resultSet.getString(javaBean.getOwnerFirstName()) + " " +
					resultSet.getString(javaBean.getOwnerLastName()) + " " + 
					resultSet.getString(javaBean.getSSNumber()) + " " +
					resultSet.getString(javaBean.getOwnerPhoneNumber()) + " " +
					resultSet.getDate(javaBean.getDateTime()));
		}
	}
	//End of SELECT connections

	//INSERT connections
	public void insertDog() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.insertDog());
		preparedStmt.setInt(1, Input.getId());
		preparedStmt.setString(2, Input.getDogName());
		preparedStmt.setString(3, Input.getDogGender());
		preparedStmt.setString(4, Input.getDogRace());
		preparedStmt.setInt(5, Input.getAdoptionId());
		preparedStmt.executeUpdate();
		preparedStmtSelect = connection.prepareStatement(queries.displayDogInsert());
		resultSet = preparedStmtSelect.executeQuery();

		if(resultSet.last()) {
			String result = resultSet.getInt(javaBean.getKeeper()) + " " + resultSet.getString(javaBean.getDogName()) + " " +
					resultSet.getString(javaBean.getDogGender()) + " " + resultSet.getString(javaBean.getDogRace()) + " " +  	
					resultSet.getInt(javaBean.getAdoptionId());
			System.out.println(result);
		}

	}

	public void insertKeeper() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.insertKeeper());
		preparedStmt.setString(1, Input.getSurName());
		preparedStmt.setString(2, Input.getLastName());
		preparedStmt.executeUpdate();
		preparedStmtSelect = connection.prepareStatement(queries.displayKeeperInsert());
		resultSet = preparedStmtSelect.executeQuery();

		if(resultSet.last()) {
			String result = resultSet.getInt(javaBean.getKeeperId()) + " " + 
					resultSet.getString(javaBean.getKeeperFirstName()) + " " +
					resultSet.getString(javaBean.getKeeperLastName());
			System.out.println(result);

		}

	}

	public void insertNewOwner() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);	
		preparedStmt = connection.prepareStatement(queries.insertNewOwner());
		preparedStmt.setString(1, Input.getSurName());
		preparedStmt.setString(2, Input.getLastName());
		preparedStmt.setString(3, Input.getSSNumber());
		preparedStmt.setString(4, Input.getPhoneNumber());
		preparedStmt.executeUpdate();
		preparedStmtSelect = connection.prepareStatement(queries.displayNewOwner());
		resultSet = preparedStmtSelect.executeQuery();

		if(resultSet.last()) {
			System.out.println(resultSet.getString(javaBean.getOwnerId()) + " " + 
					resultSet.getString(javaBean.getOwnerFirstName()) + " " +
					resultSet.getString(javaBean.getOwnerLastName()) + " " + 
					resultSet.getString(javaBean.getSSNumber())+ " " + 
					resultSet.getString(javaBean.getOwnerPhoneNumber()));

		}

	}
	//End of Insert connections

	//Update connections
	public void updateDog() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.updateDog());
		preparedStmt.setInt(1, Input.getId());
		preparedStmt.setString(2, Input.getDogName());
		preparedStmt.setString(3, Input.getDogGender());
		preparedStmt.setString(4, Input.getDogRace());
		preparedStmt.setInt(5, Input.getAdoptionId());
		int rows = preparedStmt.executeUpdate();
		System.out.println(rows + " row(s) updated.");

	}

	public void updateKeeper() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.updateKeeper());
		preparedStmt.setString(1, Input.getSurName());
		preparedStmt.setString(2, Input.getLastName());
		int rows = preparedStmt.executeUpdate();
		System.out.println(rows + " row(s) updated.");

	}
	public void updateNewOwner() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.updateNewOwner());
		preparedStmt.setString(1, Input.getSurName());
		preparedStmt.setString(2, Input.getLastName());
		preparedStmt.setString(3, Input.getSSNumber());
		preparedStmt.setString(4, Input.getPhoneNumber());
		int rows = preparedStmt.executeUpdate();
		System.out.println(rows + " row(s) updated.");

	}
	//End of UPDATE connections

	//DELETE connections
	public void deleteKeeper() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.deleteKeeper());
		preparedStmt.setInt(1, Input.getId());
		int rows = preparedStmt.executeUpdate();
		System.out.println(rows+" row(s) deleted.");

	}

	public void deleteNewOwnerAndDog() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.deleteNewOwnerAndDog());
		preparedStmt.setInt(1, Input.getId());
		int rows = preparedStmt.executeUpdate();
		System.out.println(rows+" row(s) deleted.");

	}
	//End of DELETE connections

	//Stored procedure connection
	public void dogCount() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);		
		callableStatement = connection.prepareCall("{call dog_count(?,?)}");
		callableStatement.setInt(1, 1);
		callableStatement.registerOutParameter(2, Types.INTEGER);
		callableStatement.executeQuery();
		int count = callableStatement.getInt(2);
		System.out.println("Number of dogs in table 'Dog': " + count);

	}

	//Search connection
	public void searchNewOwner() throws SQLException{
		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();	
		resultSet = statement.executeQuery(queries.searchNewOwner());

		if(resultSet.next()) {
			System.out.println(resultSet.getInt(javaBean.getOwnerId()) + " " + 
					resultSet.getString(javaBean.getOwnerFirstName()) + " " +
					resultSet.getString(javaBean.getOwnerLastName()) + " " + 
					resultSet.getString(javaBean.getSSNumber()) + " " +
					resultSet.getString(javaBean.getOwnerPhoneNumber()));
		}
		else {
			System.out.println("Owner_id doesnt exist.");
		}

	}

	/*
	public void display() throws SQLException {
		resultSet = statement.executeQuery(queries.searchNewOwner());

		if(resultSet.next()) {
			System.out.println(resultSet.getInt(javaBean.getOwnerId()) + " " + 
					resultSet.getString(javaBean.getOwnerFirstName()) + " " +
					resultSet.getString(javaBean.getOwnerLastName()) + " " + 
					resultSet.getString(javaBean.getSSNumber()) + " " +
					resultSet.getString(javaBean.getOwnerPhoneNumber()));
		}
		else {
			System.out.println("Owner_id doesnt exist.");
		}
		//return resultSet;
	}
	 */
}


