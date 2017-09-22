package com.jdbc.mysql_logic;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jdbc.java_bean.JavaBean;

public class Queries {
	
	JavaBean javaBean = new JavaBean();
	private String url = "jdbc:mysql://localhost:3306/dog_shelter";
	private String user = "root";
	private String password = "";


	public void insertIntoDog() throws SQLException {
		Connection connection;
		CallableStatement callableStatement;
		ResultSet resultSet;
		
		int dog_id = javaBean.getDogId();
		String name = javaBean.getDogName();
		String gender = javaBean.getDogGender();
		String race = javaBean.getDogRace();
		int new_owner = javaBean.getNewDogOwner();
 		
		connection = DriverManager.getConnection(url,user,password);
		
		String insert =
		
		/*
		callableStatement = connection
				.prepareCall("{call insertDog(?,?,?,?,?)}");
		
		callableStatement.setInt(1,1);
		callableStatement.setString(2,"Buster");
		callableStatement.setString(3,"Male");
		callableStatement.setString(4,"Bulldog");
		callableStatement.setInt(5,3);
		callableStatement.executeUpdate();
		*/
		
		//resultSet = callableStatement.executeQuery();
		
		System.out.println("Inserted into Dog table: ");
		/*while(resultSet.next()) {
			
			System.out.println(resultSet.getInt(dog_id) + " " + resultSet.getString(name) + " " +
			resultSet.getString(gender) + " " + resultSet.getString(race) + " " +
					resultSet.getString(new_owner));
			
		}*/

	}
}
