package com.jdbc.connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.sql.PreparedStatement;
import com.jdbc.menu.Input;
import com.jdbc.queries.Queries;

public class ConnectionHandler  {

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
	public void selectDogConnection() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queries.selectDog());
			ResultSetUtil.displayDogResult(resultSet);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { resultSet.close(); } catch (Exception e) { /* ignored */ }
			try { statement.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}

	public void selectKeeperConnection() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(queries.selectKeeper());
			ResultSetUtil.displayDogKeeperResult(resultSet);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { resultSet.close(); } catch (Exception e) { /* ignored */ }
			try { statement.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}

	public void selectNewOwnerConnection(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();	
			resultSet = statement.executeQuery(queries.selectNewOwner());
			ResultSetUtil.displayNewOwnerResult(resultSet);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { resultSet.close(); } catch (Exception e) { /* ignored */ }
			try { statement.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}

	public void selectDeletedOwnersConnection(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();	
			resultSet = statement.executeQuery(queries.selectDeletedOwners());
			ResultSetUtil.displayDeletedOwnerResult(resultSet);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { resultSet.close(); } catch (Exception e) { /* ignored */ }
			try { statement.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}
	//End of SELECT connections

	//INSERT connections
	public void insertDogConnection(){
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
			ResultSetUtil.displayInsertDogResult(resultSet);

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { resultSet.close(); } catch (Exception e) { /* ignored */ }
			try { preparedStmt.close(); } catch (Exception e) { /* ignored */ }
			try { preparedStmtSelect.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}

	public void insertKeeperConnection(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			preparedStmt = connection.prepareStatement(queries.insertKeeper());
			preparedStmt.setString(1, Input.getSurName());
			preparedStmt.setString(2, Input.getLastName());
			preparedStmt.executeUpdate();
			preparedStmtSelect = connection.prepareStatement(queries.displayKeeperInsert());
			resultSet = preparedStmtSelect.executeQuery();
			ResultSetUtil.displayInsertKeeperResult(resultSet);

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { resultSet.close(); } catch (Exception e) { /* ignored */ }
			try { preparedStmt.close(); } catch (Exception e) { /* ignored */ }
			try { preparedStmtSelect.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}

	public void insertNewOwnerConnection() {
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
			ResultSetUtil.displayInsertNewOwnerResult(resultSet);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { resultSet.close(); } catch (Exception e) { /* ignored */ }
			try { preparedStmt.close(); } catch (Exception e) { /* ignored */ }
			try { preparedStmtSelect.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}
	//End of Insert connections

	//Update connections
	public void updateDogConnection(){
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
		finally {
			try { preparedStmt.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}

	}

	public void updateKeeperConnection() {
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
		finally {
			try { preparedStmt.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}

	}
	public void updateNewOwnerConnection() {
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
		finally {
			try { preparedStmt.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}
	//End of UPDATE connections

	//DELETE connections
	public void deleteKeeperConnection(){
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
		finally {
			try { preparedStmt.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}

	public void deleteNewOwnerAndDogConnection(){
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
		finally {
			try { preparedStmt.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}
	//End of DELETE connections

	//Stored procedure connection
	public void dogCountConnection() {
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
		finally {
			try { callableStatement.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}
	}

	//Search connection
	public void searchNewOwnerConnection(){
		try {
			connection = DriverManager.getConnection(url,user,password);
			statement = connection.createStatement();	
			resultSet = statement.executeQuery(queries.searchNewOwner());
			ResultSetUtil.displaySearchtNewOwnerResult(resultSet);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { connection.close(); } catch (Exception e) { /* ignored */ }
			try { statement.close(); } catch (Exception e) { /* ignored */ }
			try { connection.close(); } catch (Exception e) { /* ignored */ }
		}

	}
}