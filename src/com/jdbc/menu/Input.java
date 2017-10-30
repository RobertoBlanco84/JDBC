package com.jdbc.menu;

/**
 * Serves as Dog_shelter console menu and  holds getters for user input.
 * @author RobertoBlanco
 *
 */

import java.util.Scanner;
import com.jdbc.connection.ConnectionHandler;

public class Input {

	private static String surName;
	private static String lastName;
	private static String Id;
	private static String ssNumber;
	private static String phoneNumber;

	private static String dogName;
	private static String updateName;
	private static String gender;
	private static String race;
	private static String adoptionId;

	private ConnectionHandler connectionHandler = new ConnectionHandler();
	private Scanner scan = new Scanner(System.in);
	private static Scanner scanId = new Scanner(System.in);
	private boolean isActive = true;

	private String menu = "\n Dog_shelter Menu \n What do you want to do? \n 1.Select \n 2.Insert "
			+ "\n 3.Update \n 4.Delete \n 5.Search \n 6.Dog Count \n 7.Exit \n";
	/**
	 * Shows menu and options until the loop is exited.
	 */
	public void Menu()  {
		System.out.println(menu);
		String option = scan.next();
		while(isActive) {

			//SELECT
			if (option.equals("1")){
				System.out.println("SELECT * FROM:\n 1.Dog\n 2.Dog_keeper\n 3.New_owner\n 4.Deleted_owners\n"
						+ " 5.Back to Menu");
				option = scan.next();
				if(option.equals("1")) {
					connectionHandler.selectDogConnection();
					System.out.println(menu);
					option = scan.next();
				}
				if(option.equals("2")) {
					connectionHandler.selectKeeperConnection();
					System.out.println(menu);
					option = scan.next();

				}
				if(option.equals("3")) {
					connectionHandler.selectNewOwnerConnection();
					System.out.println(menu);
					option = scan.next();
				}
				if(option.equals("4")) {
					connectionHandler.selectDeletedOwnersConnection();
					System.out.println(menu);
					option = scan.next();
				}
				if(option.equals("5")) {
					System.out.println(menu);
					option = scan.next();

				}


			}
			//INSERT
			if (option.equals("2")){
				System.out.println("INSERT:\n 1.Dog\n 2.Dog_keeper\n 3.New_owner \n 4.Back to Menu");
				option = scan.next();
				if(option.equals("1")) {
					System.out.print("Enter a keeper Id: ");
					//Id = scan.next();
					System.out.print("Enter a dog name: ");
					dogName = scan.next();
					System.out.print("Enter a gender: ");
					gender = scan.next();
					System.out.print("Enter a race: ");
					race = scan.next();
					System.out.print("Enter a adoption id: ");
					adoptionId = scan.next();
					connectionHandler.insertDogConnection();
					System.out.println(menu);
					option = scan.next();
				}
				if(option.equals("2")) {
					System.out.println("Enter a surname:");
					surName = scan.next();
					System.out.println("Enter a lastname");
					lastName = scan.next();
					connectionHandler.insertKeeperConnection();
					System.out.println(menu);
					option = scan.next();
				}
				if(option.equals("3")) {
					System.out.print("Enter a surname: ");
					surName = scan.next();
					System.out.print("Enter a lastname: ");
					lastName = scan.next();
					System.out.print("Enter a social security number: ");
					ssNumber = scan.next();
					System.out.print("Enter a phone number: ");
					phoneNumber = scan.next();
					connectionHandler.insertNewOwnerConnection();
					System.out.println(menu);
					option = scan.next();

				}
				if(option.equals("4")) {
					System.out.println(menu);
					option = scan.next();
				}

			}

			//UPDATE
			if (option.equals("3")){
				System.out.println("Update:\n 1.Dog\n 2.Dog_keeper\n 3.New_owner \n 4.Back to Menu");
				option = scan.next();
				if(option.equals("1")) {
					System.out.print("Update dog WHERE keeper: ");
					//Id = scan.next();
					System.out.print("Enter a dog name: ");
					dogName = scan.next();
					System.out.print("Enter a gender: ");
					gender = scan.next();
					System.out.print("Enter a race: ");
					race = scan.next();
					System.out.print("Enter a adoption id: ");
					adoptionId = scan.next();
					connectionHandler.updateDogConnection();
					System.out.println(menu);
					option = scan.next();
				}
				if(option.equals("2")) {
					//System.out.println("Update keeper WHERE keeper_id: ");
					//Id = scan.next();
					//System.out.println("Update surname:");
					//surName = scan.next();
					//System.out.println("Update lastname");
					//lastName = scan.next();
					connectionHandler.updateKeeperConnection();
					System.out.println(menu);
					option = scan.next();
				}
				if(option.equals("3")) {
					System.out.print("Update New_owner WHERE owner_id: ");
					//Id = scan.next();
					System.out.print("Update surname: ");
					surName = scan.next();
					System.out.print("Update lastname: ");
					lastName = scan.next();
					System.out.print("Update social security number: ");
					ssNumber = scan.next();
					System.out.print("Update phone number: ");
					phoneNumber = scan.next();
					connectionHandler.updateNewOwnerConnection();
					System.out.println(menu);
					option = scan.next();
				}
				if(option.equals("4")) {
					System.out.println(menu);
					option = scan.next();
				}

			}

			//DELETE
			if (option.equals("4")){
				System.out.println("DELETE FROM:\n 1.Dog_keeper\n 2.New_owner and Dog\n 3.Back to Menu");
				option = scan.next();
				if(option.equals("1")) {
					System.out.println("Enter a keeper_id");
					//Id = scan.next();
					connectionHandler.deleteKeeperConnection();
					System.out.println(menu);
					option = scan.next();
				}
				if(option.equals("2")) {
					System.out.println("Enter a owner_id");
					//Id = scan.next();
					connectionHandler.deleteNewOwnerAndDogConnection();
					System.out.println(menu);
					option = scan.next();
				}
				if(option.equals("3")) {
					System.out.println(menu);
					option = scan.next();
					System.out.println(menu);
					option = scan.next();
				}
			}
			if (option.equals("5")){
				System.out.println("Search in table 'New_owner' by id: ");	
				//Id = scan.next();
				connectionHandler.searchNewOwnerConnection();
				System.out.println(menu);
				option = scan.next();
			}
			if (option.equals("6")){
				connectionHandler.dogCountConnection();
				System.out.println(menu);
				option = scan.next();
			}

			if(option.equals("7")) {
				System.out.println("Bye.");
				System.exit(0); 
			}


		}

	}

	// GETTERS
	/**
	 * A set of getters for private static fields
	 * @return user input
	 */
	public static String setSurName(String surName) {
		System.out.println("Update first name: ");
		surName = scanId.next();
		return surName;
	}
	
	public static String setLastName(String surName) {
		System.out.println("Update first name: ");
		surName = scanId.next();
		return surName;
	}
	
	public static String setId(String myId) {
		System.out.println("Update keeper WHERE keeper_id: ");
		myId = scanId.next();
		return myId;
	}
	
	public static String getSurName() {
		return surName;
	}
	
	public static String getLastName() {		
		return lastName;
	}

	public static String getId() {
		return Id;
	}
	
	public static String getDogName() {
		return dogName;
	}
	public static String getUpdatedName() {
		return updateName;
	}
	public static String getDogGender() {
		return gender;
	}
	public static String getDogRace() {
		return race;
	}
	public static String getAdoptionId() {
		return adoptionId;
	}

	public static String getSSNumber() {
		return ssNumber;
	}
	public static String getPhoneNumber() {
		return phoneNumber;
	}
}
