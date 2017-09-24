package com.jdbc.main;

import java.sql.SQLException;

import com.jdbc.mysql_logic.Queries;

public class Main {

	public static void main(String[] args) {
		
		Queries queries = new Queries();
		try {
		    //Select Queries
			queries.selectKeeper();
			//queries.selectDog();
			//queries.selectNewOwner();
			
			//Insert Queries
			//queries.insertDog();
			//queries.insertNewOwner();
			//queries.insertKeeper();
			
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
