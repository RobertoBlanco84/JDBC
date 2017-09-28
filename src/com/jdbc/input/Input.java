package com.jdbc.input;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.connection.ConnectionHandler;

public class Input {

	Scanner scan = new Scanner(System.in);
	ConnectionHandler connectionHandler = new ConnectionHandler();
	boolean isOn = true;

	public void Menu() throws SQLException{
		String menu = " Dog_shelter Menu \n What do you want to do? \n 1.Select \n 2.Insert "
				+ "\n 3.Update \n 4.Delete \n 5.Dog Count \n 6.Exit \n";
		System.out.println(menu);

		while(isOn)
			try {
				String option = scan.next();

				if (option.equals("1")){
					System.out.println("SELECT * FROM:\n 1.Dog\n 2.Dog_keeper\n 3.New_owner \n 4.Back to Menu");
					option = scan.next();
					if(option.equals("1")) {
						connectionHandler.selectDog();
						System.out.println(menu);
						option = scan.next();
					}
					if(option.equals("2")) {
						connectionHandler.selectKeeper();
						System.out.println(menu);
						option = scan.next();
					}
					if(option.equals("3")) {
						connectionHandler.selectNewOwner();
						System.out.println(menu);
						option = scan.next();
					}
					if(option.equals("4")) {
						System.out.println(menu);
						option = scan.next();
						System.out.println(menu);
						option = scan.next();
					}
					else {
						System.out.println("Strings are invalid. Try again.");
						System.out.println(menu);

					}

				}
				if (option.equals("2")){
					System.out.println("INSERT:\n 1.Dog\n 2.Dog_keeper\n 3.New_owner \n 4.Back to Menu");
					option = scan.next();
					if(option.equals("1")) {
						connectionHandler.insertDog();
					}
					if(option.equals("2")) {
						connectionHandler.insertKeeper();
					}
					if(option.equals("3")) {
						connectionHandler.insertNewOwner();
					}
					if(option.equals("4")) {
						System.out.println(menu);
						option = scan.next();
					}
					else {
						System.out.println("Strings are invalid. Try again.");
						System.out.println(menu);

					}

				}
				if (option.equals("3")){
					System.out.println("Update:\n 1.Dog\n 2.Dog_keeper\n 3.New_owner \n 4.Back to Menu");
					option = scan.next();
					if(option.equals("1")) {
						connectionHandler.updateDog();
					}
					if(option.equals("2")) {
						connectionHandler.updateKeeper();
					}
					if(option.equals("3")) {
						connectionHandler.updateNewOwner();
					}
					if(option.equals("4")) {
						System.out.println(menu);
						option = scan.next();
					}
					else {
						System.out.println("Strings are invalid. Try again.");
						System.out.println(menu);

					}

				}
				if (option.equals("4")){
					System.out.println("DELETE FROM:\n 1.Dog_keeper\n 2.New_owner and Dog\n 3.Back to Menu");
					option = scan.next();
					if(option.equals("1")) {
						connectionHandler.deleteKeeper();
					}
					if(option.equals("2")) {
						connectionHandler.deleteNewOwner();
					}
					if(option.equals("3")) {
						System.out.println(menu);
						option = scan.next();
					}
					else {
						System.out.println("Strings are invalid. Try again.");
						System.out.println(menu);

					}
				}
				if (option.equals("5")){
					connectionHandler.dogCount();
					System.out.println(menu);
					option = scan.next();

				}
				if(option.equals("6")) {
					System.out.println("Bye.");
					System.exit(0); 
				}
				else {
					System.out.println("Strings are invalid. Try again.");
					System.out.println(menu);

				}
			}

		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
