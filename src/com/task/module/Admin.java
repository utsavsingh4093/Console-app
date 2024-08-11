package com.task.module;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Admin {
	public static void AdminForUser() {
		ArrayList<UserProcess> userList = new ArrayList<UserProcess>();
		Scanner integerInput = new Scanner(System.in);// For Integer
		Scanner stringInput = new Scanner(System.in);// For String

		while (true) {
			System.out.println("-------------------------------------------------------------");
			System.out.println("Tab Number 1 For Create User");
			System.out.println("Tab Number 2 For Fetch All User");
			System.out.println("Tab Number 3 For Fetch any One User");
			System.out.println("Tab Number 4 For Delete any User");
			System.out.println("Tab Number 5 For Update User");
			System.out.println("Tab Number 6 For Delete All User");
			System.out.println("Tab Number 7 For Exit");
			System.out.println("-------------------------------------------------------------");
			System.out.println("Tab Any Number for Operation Performing");

			String operation = stringInput.nextLine();
			if (operation.equals("") || (operation.endsWith(" "))) {
				continue;
			} else {
				switch (operation) {
				//CREATE
				case "1":
					System.out.println("-------------------------------------------------------------");
					try {
						CreateUserClass.createUser(userList, integerInput, stringInput);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("-------------------------------------------------------------");
					break;
					//Fetch
				case "2":

					System.out.println("-------------------------------------------------------------");
					try {
						if (userList.size() == 0) {
							System.out.println("No User Avalilable Empty");
						} else {
							FetchUser.fetchAllUser(userList);
							// userList.forEach(user -> System.out.println(user.getName()+ " :
							// "+user.getEmail()+" : "+user.getPhone( )));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("-------------------------------------------------------------");
					break;
                         
				case "3":
					try {
						System.out.println("-------------------------------------------------------------");
						System.out.println("Enter Email For Search : ");
						String userEmail = stringInput.nextLine();
						FetchUser.fetchSingleUser(userList, userEmail);
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("-------------------------------------------------------------");
					break;

				case "4":
					System.out.println("-------------------------------------------------------------");
					try {
						System.out.println("Enter name you want to delete : ");
						String userName = stringInput.nextLine();
						boolean found = false;
						ListIterator<UserProcess> userIterator = userList.listIterator();
						while (userIterator.hasNext()) {
							UserProcess u = userIterator.next();
							if (u.getName().equalsIgnoreCase(userName)) {
								userIterator.remove();
								System.out.println("User Deleted Successfully");
								found = true;
							}
						}
						if (!found) {
							System.err.println("No User Found");
						}
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					System.out.println("-------------------------------------------------------------");
					break;

				case "5":
					System.out.println("-------------------------------------------------------------");
					String userName="";
					try {
					System.out.println("Enter name you want to Update All Details : ");
					 userName = stringInput.nextLine();
					}
					catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					ListIterator<UserProcess> userIterator = userList.listIterator();
					boolean found = false;
					while (userIterator.hasNext()) {
						UserProcess userProcess = userIterator.next();
						if (userProcess.getName().equalsIgnoreCase(userName)) {
							System.out.println("-------------------------------------------------------------");
							System.out.println("Enter What You Want to Update : ");
							System.out.println("press 1 to Update Name : ");
							System.out.println("press 2 to Update Email ");
							System.out.println("press 3 to Update Phone Number : ");
							System.out.println("press 4 to Update All :");
							int num = integerInput.nextInt();// For Inner Switch Case Condition
							switch (num) {
							case 1:
								System.out.println("-------------------------------------------------------------");
								CreateUserClass.createNewUserName(userProcess, stringInput);
								System.out.println("-------------------------------------------------------------");
								break;
							case 2:
								System.out.println("-------------------------------------------------------------");
								 CreateUserClass.createNewUserEmail(userProcess, stringInput);
								System.out.println("-------------------------------------------------------------");
								break;
							case 3:
								System.out.println("-------------------------------------------------------------");
								CreateUserClass.createNewUserPhone(userProcess, stringInput, integerInput);
								System.out.println("-------------------------------------------------------------");
								break;
							case 4:
								System.out.println("-------------------------------------------------------------");
								UpdateAllDetailsClass.updateAllDeatilUser(userIterator, userProcess, stringInput, integerInput);
								System.out.println("-------------------------------------------------------------");	
								break;
							}
						}
						}
					System.out.println("-------------------------------------------------------------");
					break;

				case "6":
					System.out.println("-------------------------------------------------------------");
					try {
						userList.clear();
						System.out.println("All Record is Deleted From The Console App again Enter");
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("-------------------------------------------------------------");
					break;
				case "7":
					System.err.println("---------------------------Program is End----------------------------------");
					System.exit(0);

				default:
					System.out.println("-----------------------------------------------------------------");
					System.err.println("You Press Wrong Thing your program is out now again run it");
					System.out.println("-----------------------------------------------------------------");
					break;
                     }
			}
		}
		}

	public static void main(String[] args) {
		Admin.AdminForUser();
	}
}