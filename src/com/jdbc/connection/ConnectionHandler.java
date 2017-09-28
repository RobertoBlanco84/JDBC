package com.jdbc.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.PreparedStatement;

import com.jdbc.java_bean.JavaBean;
import com.jdbc.queries.Queries;


public class ConnectionHandler {

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
	
	// SELECT methods
	public void  selectDog() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(queries.selectDog(""));

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
		resultSet = statement.executeQuery(queries.selectKeeper(""));

		while(resultSet.next()) {
			System.out.println(resultSet.getInt(javaBean.getKeeperId()) + " " + 
					resultSet.getString(javaBean.getKeeperFirstName()) + " " +
					resultSet.getString(javaBean.getKeeperLastName()));
		}
	}

	public void selectNewOwner() throws SQLException{
		connection = DriverManager.getConnection(url,user,password);
		statement = connection.createStatement();	
		resultSet = statement.executeQuery(queries.selectNewOwner(""));

		while(resultSet.next()) {
			System.out.println(resultSet.getInt(javaBean.getOwnerId()) + " " + 
					resultSet.getString(javaBean.getOwnerFirstName()) + " " +
					resultSet.getString(javaBean.getOwnerLastName()) + " " + 
					resultSet.getString(javaBean.getSSNumber()) + " " +
					resultSet.getString(javaBean.getOwnerPhoneNumber()));
		}
	}
	//End of SELECT methods

	//INSERT methods
	public void insertDog() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.insertDog(""));
		preparedStmt.setInt(1, 1);
		preparedStmt.setString(2, "Gary");
		preparedStmt.setString(3, "Male");
		preparedStmt.setString(4, "Sibierian Husky");
		preparedStmt.setInt(5, 15);
		preparedStmt.executeUpdate();
		preparedStmtSelect = connection.prepareStatement(queries.displayDogInsert(""));
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
		preparedStmt = connection.prepareStatement(queries.insertKeeper(""));
		preparedStmt.setString(1, "Johnny");
		preparedStmt.setString(2, "Löfkvist");
		preparedStmt.executeUpdate();
		preparedStmtSelect = connection.prepareStatement(queries.displayKeeperInsert(""));
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
		preparedStmt = connection.prepareStatement(queries.insertNewOwner(""));
		preparedStmt.setString(1, "Gunnar");
		preparedStmt.setString(2, "Dahlkvist");
		preparedStmt.setString(3, "1970-03-01-2222");
		preparedStmt.setString(4, "0705566771");
		preparedStmt.executeUpdate();
		preparedStmtSelect = connection.prepareStatement(queries.displayNewOwner(""));
		resultSet = preparedStmtSelect.executeQuery();

		if(resultSet.last()) {
			System.out.println(resultSet.getString(javaBean.getOwnerId()) + " " + 
					resultSet.getString(javaBean.getOwnerFirstName()) + " " +
					resultSet.getString(javaBean.getOwnerLastName()) + " " + 
					resultSet.getString(javaBean.getSSNumber())+ " " + 
					resultSet.getString(javaBean.getOwnerPhoneNumber()));

		}

	}
	//End of Insert methods
	
	//Update methods
	public void updateDog() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.updateDog(""));
		preparedStmt.setInt(1, 2);
		int rows = preparedStmt.executeUpdate();
		System.out.println(rows + " row(s) updated.");

	}
	
	public void updateKeeper() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.updateKeeper(""));
		preparedStmt.setString(1, "Kim");
		preparedStmt.setString(2, "Källström");
		int rows = preparedStmt.executeUpdate();
		System.out.println(rows + " row(s) updated.");

	}
	public void updateNewOwner() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.updateNewOwner(""));
		preparedStmt.setString(1, "Andreas");
		preparedStmt.setString(2, "Petterson");
		int rows = preparedStmt.executeUpdate();
		System.out.println(rows + " row(s) updated.");

	}
	//End of UPDATE methods
	
	//DELETE methods
	public void deleteKeeper() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.deleteKeeper(""));
		preparedStmt.setInt(1, 1);
		int rows = preparedStmt.executeUpdate();
		System.out.println(rows+" row(s) deleted.");

	}
	
	public void deleteNewOwner() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);
		preparedStmt = connection.prepareStatement(queries.deleteNewOwnerAndDog(""));
		preparedStmt.setInt(1, 1);
		int rows = preparedStmt.executeUpdate();
		System.out.println(rows+" row(s) deleted.");

	}
	//End of DELETE methods

	//Stored procedure
	public void dogCount() throws SQLException {
		connection = DriverManager.getConnection(url,user,password);		
		callableStatement = connection.prepareCall("{call dog_count(?,?)}");
		callableStatement.setInt(1, 1);
		callableStatement.registerOutParameter(2, Types.INTEGER);
		callableStatement.executeQuery();
		int count = callableStatement.getInt(2);
		System.out.println("Number of dogs in table 'Dog': " + count);

	} 

}
