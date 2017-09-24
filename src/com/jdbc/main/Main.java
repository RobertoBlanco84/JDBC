package com.jdbc.main;

import java.sql.SQLException;

import com.jdbc.mysql_logic.Queries;

public class Main {

	public static void main(String[] args) {
		
		Queries queries = new Queries();
		try {
		    
			queries.select();
			//queries.insert();
			//queries.dogCount();
			//queries.delete();
			//queries.update();
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
