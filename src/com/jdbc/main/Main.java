package com.jdbc.main;

import java.sql.SQLException;

import com.jdbc.menu.Input;

public class Main {

	public static void main(String[] args) {
		Input in = new Input();
		try {

			in.Menu();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
