package com.jdbc.main;

import java.sql.SQLException;

import com.jdbc.mysql_logic.Queries;

public class Main {

	public static void main(String[] args) {
		
		Queries queries = new Queries();
		try {
		queries.insertIntoDog();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
