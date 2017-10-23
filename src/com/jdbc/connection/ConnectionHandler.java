package com.jdbc.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.PreparedStatement;

import com.jdbc.java_bean.DeletedOwnerBean;
import com.jdbc.java_bean.DogBean;
import com.jdbc.java_bean.DogKeeperBean;
import com.jdbc.java_bean.NewOwnerBean;
import com.jdbc.menu.Input;
import com.jdbc.queries.Queries;


public class ConnectionHandler  {

	private DogBean dogBean = new DogBean();
	private DogKeeperBean dogKeeperBean = new DogKeeperBean();
	private NewOwnerBean newOwnerBean = new NewOwnerBean();
	private DeletedOwnerBean deletedOwnerBean = new DeletedOwnerBean();
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

	//ÄNDRA METOD NAMN!!!	
	// SELECT connections
	public void selectDog() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queries.selectDog());
			
			while (resultSet.next()) {
				for (int j = 0; j < 5 ; j++) {
					System.out.print(resultSet.getString(dogBean.getDogList().get(j)) + " ");
				} 
				System.out.println();
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectKeeper() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queries.selectKeeper());
			
			while (resultSet.next()) {
				for (int j = 0; j < 3 ; j++) {
					System.out.print(resultSet.getString(dogKeeperBean.getKeeperList().get(j)) + " ");
				} 
				System.out.println();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectNewOwner(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();	
			resultSet = statement.executeQuery(queries.selectNewOwner());
			
			while (resultSet.next()) {
				for (int j = 0; j < 5; j++) {
					System.out.print(resultSet.getString(newOwnerBean.getNewOwnerList().get(j)) + " ");
				} 
				System.out.println();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void selectDeletedOwners(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();	
			resultSet = statement.executeQuery(queries.selectDeletedOwners());

			while (resultSet.next()) {
				for (int j = 0; j < 6; j++) {
					System.out.print(resultSet.getString(deletedOwnerBean.getDeletedOwnerList().get(j)) + " ");
				} 
				System.out.println();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//End of SELECT connections

	//INSERT connections
	public void insertDog(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			preparedStmt = connection.prepareStatement(queries.insertDog());
			preparedStmt.setString(1, Input.getId());
			preparedStmt.setString(2, Input.getDogName());
			preparedStmt.setString(3, Input.getDogGender());
			preparedStmt.setString(4, Input.getDogRace());
			preparedStmt.setString(5, Input.getAdoptionId());
			preparedStmt.executeUpdate();
			preparedStmtSelect = connection.prepareStatement(queries.displayDogInsert());
			resultSet = preparedStmtSelect.executeQuery();


			if(resultSet.last()) {
				/*String result = resultSet.getString(dogBean.getDogList().get(0) + " " +
					resultSet.getString(dogBean.getDogList().get(1)) + " " +
					resultSet.getString(dogBean.getDogList().get(2)) + " " +
					resultSet.getString(dogBean.getDogList().get(3)); //+ " " +
					resultSet.getString(dogBean.getDogList().get(4)));*/
				//System.out.println(result);
				//System.out.println(resultSet.getString(dogBean.getDogQueue().peek()));
				for(String element : dogBean.getDogQueue()) {
					System.out.print(resultSet.getString(element.toString()) + " ");
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertKeeper(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			preparedStmt = connection.prepareStatement(queries.insertKeeper());
			preparedStmt.setString(1, Input.getSurName());
			preparedStmt.setString(2, Input.getLastName());
			preparedStmt.executeUpdate();
			preparedStmtSelect = connection.prepareStatement(queries.displayKeeperInsert());
			resultSet = preparedStmtSelect.executeQuery();

			if (resultSet.last()) {
	
				for(String element : dogKeeperBean.getDogKeeperQueue()) {
					System.out.print(resultSet.getString(element.toString()) + " ");
				}

			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertNewOwner() {
		try {
			connection = DriverManager.getConnection(url,user,password);	
			preparedStmt = connection.prepareStatement(queries.insertNewOwner());
			preparedStmt.setString(1, Input.getSurName());
			preparedStmt.setString(2, Input.getLastName());
			preparedStmt.setString(3, Input.getSSNumber());
			preparedStmt.setString(4, Input.getPhoneNumber());
			preparedStmt.executeUpdate();
			preparedStmtSelect = connection.prepareStatement(queries.displayNewOwner());
			resultSet = preparedStmtSelect.executeQuery();

			if (resultSet.last()) {
				for (String element : newOwnerBean.getNewOwnerQueue()) {
					System.out.print(resultSet.getString(element.toString()) + " ");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//End of Insert connections

	//Update connections
	public void updateDog(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			preparedStmt = connection.prepareStatement(queries.updateDog());
			preparedStmt.setString(1, Input.getDogName());
			preparedStmt.setString(2, Input.getDogGender());
			preparedStmt.setString(3, Input.getDogRace());
			preparedStmt.setString(4, Input.getAdoptionId());
			int rows = preparedStmt.executeUpdate();
			System.out.println(rows + " row(s) updated.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateKeeper() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			preparedStmt = connection.prepareStatement(queries.updateKeeper());
			preparedStmt.setString(1, Input.getSurName());
			preparedStmt.setString(2, Input.getLastName());
			int rows = preparedStmt.executeUpdate();
			System.out.println(rows + " row(s) updated.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
	public void updateNewOwner() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			preparedStmt = connection.prepareStatement(queries.updateNewOwner());
			preparedStmt.setString(1, Input.getSurName());
			preparedStmt.setString(2, Input.getLastName());
			preparedStmt.setString(3, Input.getSSNumber());
			preparedStmt.setString(4, Input.getPhoneNumber());
			int rows = preparedStmt.executeUpdate();
			System.out.println(rows + " row(s) updated.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
	//End of UPDATE connections

	//DELETE connections
	public void deleteKeeper(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			preparedStmt = connection.prepareStatement(queries.deleteKeeper());
			preparedStmt.setString(1, Input.getId());
			int rows = preparedStmt.executeUpdate();
			System.out.println(rows+" row(s) deleted.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteNewOwnerAndDog(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			preparedStmt = connection.prepareStatement(queries.deleteNewOwnerAndDog());
			preparedStmt.setString(1, Input.getId());
			int rows = preparedStmt.executeUpdate();
			System.out.println(rows+" row(s) deleted.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
	//End of DELETE connections

	//Stored procedure connection
	public void dogCount() {
		try {
			connection = DriverManager.getConnection(url,user,password);		
			callableStatement = connection.prepareCall("{call dog_count(?,?)}");
			callableStatement.setInt(1, 1);
			callableStatement.registerOutParameter(2, Types.INTEGER);
			callableStatement.executeQuery();
			int count = callableStatement.getInt(2);
			System.out.println("Number of dogs in table 'Dog': " + count);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

	//Search connection
	public void searchNewOwner(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();	
			resultSet = statement.executeQuery(queries.searchNewOwner());

			if(resultSet.next()) {
			for (int j = 0; j < 5; j++) {
				System.out.print(resultSet.getString(newOwnerBean.getNewOwnerList().get(j)) + " ");
			} 
			System.out.println();
			
			}
			/*if(resultSet.next()) {
				System.out.println(
						resultSet.getString(newOwnerBean.getOwnerId()) + " " + 
						resultSet.getString(newOwnerBean.getOwnerFirstName()) + " " +
						resultSet.getString(newOwnerBean.getOwnerLastName()) + " " + 
						resultSet.getString(newOwnerBean.getSocialSecurityNumber()) + " " +
						resultSet.getString(newOwnerBean.getPhoneNumber()));
			}*/
			else {
				System.out.println("Owner_id doesnt exist.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}
}