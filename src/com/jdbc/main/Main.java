package com.jdbc.main;

import java.sql.SQLException;

import com.jdbc.connection.ConnectionHandler;

public class Main {

	public static void main(String[] args) {

		ConnectionHandler queries = new ConnectionHandler();
		try {
			//Select Queries
			//queries.selectKeeper();
			queries.selectDog();
			//queries.selectNewOwner();

			//Insert Queries
			//queries.insertDog();
			//queries.insertKeeper();
			//queries.insertNewOwner();

			//queries.delete();
			//queries.update();

			//Stored Procedure
			//queries.dogCount();
		}

		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
