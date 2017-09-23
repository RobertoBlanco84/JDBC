package com.jdbc.mysql_logic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.PreparedStatement;

import com.jdbc.java_bean.JavaBean;



public class Queries {
	
	JavaBean javaBean = new JavaBean();
	private String url = "jdbc:mysql://localhost:3306/dog_shelter";
	private String user = "root";
	private String password = "";
	int test;


	public void insertIntoNewOwner() throws SQLException {
		Connection connection;
		PreparedStatement preparedStmt;
		PreparedStatement preparedStmtSelect;
		ResultSet resultSet;
	
 		
		connection = DriverManager.getConnection(url,user,password);
		String owner_id = javaBean.getOwnerId();
		String fname = javaBean.getOwnerFirstName();
		String lname = javaBean.getOwnerLastName();
		String phone_number = javaBean.getOwnerPhoneNumber();
		
		String insertQuery = "INSERT INTO New_owner (" + owner_id + ", " + fname + ", " + lname +
				", " + phone_number + ") VALUES(?,?,?,?)";
		
		
		preparedStmt = connection.prepareStatement(insertQuery);
		preparedStmt.setInt(1, 17);
		preparedStmt.setString(2, "Tobbe");
		preparedStmt.setString(3, "Karlsson");
		preparedStmt.setInt(4, 2927542);
		preparedStmt.executeUpdate();

		System.out.println("Inserted into New_owner table: ");
		String selectQuery = "SELECT "+ owner_id + "," +fname + ", "+ lname+ "," + phone_number+ " FROM New_owner";
		preparedStmtSelect = connection.prepareStatement(selectQuery);
		resultSet = preparedStmtSelect.executeQuery();
		if(resultSet.last()) {

			
			System.out.println(resultSet.getInt(owner_id) + " " + resultSet.getString(fname) + " " +
			resultSet.getString(lname) + " " + resultSet.getInt(phone_number));
			
		}
	}
	
	//Stored procedure
	public void dogCount() throws SQLException {
		Connection connection;
		CallableStatement callableStatement;
		
		connection = DriverManager.getConnection(url,user,password);		
		callableStatement = connection.prepareCall("{call dog_count(?,?)}");
		
		callableStatement.setInt(1, javaBean.getDogId());
		callableStatement.registerOutParameter(2, Types.INTEGER);
		
		callableStatement.execute();
		int count = callableStatement.getInt(2);
		System.out.println("Number of dogs in table 'Dog': "  + count);
		
	}
}
