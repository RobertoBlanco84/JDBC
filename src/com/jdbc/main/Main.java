package com.jdbc.main;

import java.sql.SQLException;

import com.jdbc.menu.Input;

public class Main {

	public static void main(String[] args) {
		Input menu = new Input();
		try {
			menu.Menu();

		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
