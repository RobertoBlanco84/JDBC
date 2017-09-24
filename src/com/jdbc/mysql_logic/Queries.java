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
	
	JavaBean javaBean = new JavaBean();
	private String url = "jdbc:mysql://localhost:3306/dog_shelter";
	private String user = "root";
	private String password = "";
	
	String keeper_id = javaBean.getKeeperId();
	
	String owner_id = javaBean.getOwnerId();
	String fname = javaBean.getOwnerFirstName();
	String lname = javaBean.getOwnerLastName();
	String phone_number = javaBean.getOwnerPhoneNumber();
	
	public void select() throws SQLException{
		Connection connection;
		Statement statement;
		ResultSet resultSet;
		
		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();
		String selectQuery = "SELECT * FROM new_owner";	
		resultSet = statement.executeQuery(selectQuery);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(owner_id) + " " + resultSet.getString(fname) + " " +
					resultSet.getString(lname) + " " + resultSet.getInt(phone_number));
		}
	}


	public void insert() throws SQLException {
		Connection connection;
		PreparedStatement preparedStmt;
		PreparedStatement preparedStmtSelect;
		ResultSet resultSet;
	
 		
		connection = DriverManager.getConnection(url,user,password);
		
		
		String insertQuery = "INSERT INTO New_owner (" + owner_id + ", " + fname + ", " + lname +
				", " + phone_number + ") VALUES(?,?,?,?)";
		
		
		preparedStmt = connection.prepareStatement(insertQuery);
		preparedStmt.setInt(1, 19);
		preparedStmt.setString(2, "Börje");
		preparedStmt.setString(3, "Salming");
		preparedStmt.setInt(4, 11223344);
		preparedStmt.executeUpdate();

		System.out.println("Inserted into 'New_owner' table: ");
		String selectQuery = "SELECT "+ owner_id + "," +fname + ", "+ lname+ "," + phone_number+ " FROM New_owner";
		preparedStmtSelect = connection.prepareStatement(selectQuery);
		resultSet = preparedStmtSelect.executeQuery();
		
		if(resultSet.last()) {
			System.out.println(resultSet.getInt(owner_id) + " " + resultSet.getString(fname) + " " +
			resultSet.getString(lname) + " " + resultSet.getInt(phone_number));
			
		}
		
	}
	
	public void delete() throws SQLException {
		Connection connection;
		PreparedStatement preparedStatement;
		
		connection = DriverManager.getConnection(url,user,password);
		String deleteQuery = "DELETE FROM New_owner WHERE "+ owner_id +" = ?";
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
