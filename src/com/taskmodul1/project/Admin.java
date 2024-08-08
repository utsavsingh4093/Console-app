package com.taskmodul1.project;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin {
	public static boolean checkNameValid(String name) {
		String regexName = "[a-zA-Z]+[\\s]*[a-zA-Z]{0,50}";
		boolean check = name.matches(regexName);
		return check;
	}

	public static boolean checkValidEmail(String emai) {
		String regxEmail = "[a-zA-Z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-Z]{2,3}";
		boolean check = emai.matches(regxEmail);
		return check;
	}

	public static boolean checkValidPhone(String number) {
		String regxPhone = "[6-9][0-9]{9}";
		boolean check = number.matches(regxPhone);
		return check;
	}

	public static void main(String[] args) {
		ArrayList<UserProcess> arrayList = new ArrayList<UserProcess>();
		Scanner scr1 = new Scanner(System.in);// For Integer
		Scanner scr2 = new Scanner(System.in);// For String

		while (true) {
			System.out.println("Tab Number 1 For Create User");
			System.out.println("Tab Number 2 For Fetch All User");
			System.out.println("Tab Number 3 For Fetch any One User");
			System.out.println("Tab Number 4 For Delete any User");
			System.out.println("Tab Number 5 For Update User");
			System.out.println("Tab Number 6 For Delete All User");
			System.out.println("Tab Number 7 For Exit");
			System.out.println("Tab Any Number for Operation Performing");

			String operation = scr2.nextLine();

			switch (operation) {
			case "1":
				System.out.println("-------------------------------------------------------------");
				System.out.println("Enter User Name : ");
				String userName = scr2.nextLine().trim();
				if (Admin.checkNameValid(userName)) {
					System.out.print("");
				} else if (!Admin.checkNameValid(userName)) {
					System.out.println("You Enter Invalid Name");
					break;
				}
				System.out.println("Enter User Email : ");
				String userEmail = scr2.nextLine();
				if (!Admin.checkValidEmail(userEmail)) {
					System.err.println("Invalid Email Try again:");
					break;
				}
				System.out.println("Enetr Number of Phone Number User Have : ");
				int count = scr1.nextInt();// Here is count of number
				String phoneNum = "";
				int flag = 0;
				for (int i = 0; i < count; i++) {
					System.out.println("Enter User Phone Number : ");
					String userPhone = scr2.nextLine();
					if (Admin.checkValidPhone(userPhone)) {
						phoneNum += userPhone + " ";
						flag = 0;
					} else {
						System.err.println("Invalid Phone Number Try Again ");
						flag = 1;
						break;
					}
				}
				boolean found = false;
				if (flag == 0) {
					for (UserProcess u : arrayList) {
						if (u.getEmail().equals(userEmail)) {
							found = true;
							break;
						}
					}
					if (!found) {
						arrayList.add(new UserProcess(userName, userEmail, phoneNum));
						System.out.println("User Added Successfully");
					} else {
						System.err.println("User is Alerady Exist with this Email create new Email");
					}
				}
				System.out.println("-------------------------------------------------------------");
				break;
			case "2":
				System.out.println("-------------------------------------------------------------");
				for (UserProcess userProcess : arrayList) {
					System.out.println(
							userProcess.getName() + " : " + userProcess.getEmail() + " : " + userProcess.getPhone());
				}
				System.out.println("-------------------------------------------------------------");
				break;

			case "3":

				try {
					System.out.println("-------------------------------------------------------------");
					System.out.println("Enter name For Search : ");
					String name1 = scr2.nextLine();
					boolean found1 = false;
					for (UserProcess userProcess : arrayList) {
						if (userProcess.getName().equalsIgnoreCase(name1)) {
							System.out.println(userProcess.getName() + " : " + userProcess.getEmail() + " : "
									+ userProcess.getPhone());
							found1 = true;
						}
					}
					if (!found1) {
						throw new RuntimeException("UserNotFound Exception");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("-------------------------------------------------------------");
				break;

			case "4":
				System.out.println("-------------------------------------------------------------");
				System.out.println("Enter name you want to delete : ");
				userName = scr2.nextLine();
				found = false;
				ListIterator<UserProcess> listIterator = arrayList.listIterator();
				while (listIterator.hasNext()) {
					UserProcess u = listIterator.next();
					if (u.getName().equalsIgnoreCase(userName)) {
						listIterator.remove();
						System.out.println("User Deleted Successfully");
						found = true;
					}
				}
				if (!found) {
					System.err.println("No User Found");
				}
				System.out.println("-------------------------------------------------------------");
				break;

			case "5":
				System.out.println("-------------------------------------------------------------");
				System.out.println("Enter name you want to Update All Details : ");
				userName = scr2.nextLine();
				listIterator = arrayList.listIterator();
				found = false;
				while (listIterator.hasNext()) {
					UserProcess userProcess = listIterator.next();
					if (userProcess.getName().equalsIgnoreCase(userName)) {
						System.out.println("-------------------------------------------------------------");
						System.out.println("Enter What You Want to Update : ");
						System.out.println("press 1 to Update Name : ");
						System.out.println("press 2 to Update Email ");
						System.out.println("press 3 to Update Phone Number : ");
						System.out.println("press 4 to Update All :");
						int num = scr1.nextInt();// For Inner Switch Case Condition
						switch (num) {
						case 1:
							System.out.println("-------------------------------------------------------------");
							System.out.println("Enter new name ");
							String newUserName = scr2.nextLine();
							if (Admin.checkNameValid(newUserName)) {
								userProcess.setName(newUserName);
								found = true;
							}
							System.out.println("-------------------------------------------------------------");
							break;
						case 2:
							System.out.println("-------------------------------------------------------------");
							System.out.println("Enter new email ");
							String newUserEmail = scr2.nextLine();

							if (Admin.checkValidEmail(newUserEmail)) {
								userProcess.setEmail(newUserEmail);
								found = true;
							} else {
								System.err.println("Invalid Email Try again");
							}
							System.out.println("-------------------------------------------------------------");
							break;
						case 3:
							System.out.println("-------------------------------------------------------------");
							String demoNumber = userProcess.getPhone();
							System.out.println("You have That Number in your List: " + demoNumber);
							String stringArray[] = demoNumber.split(" ");// This array is For Containing the number in
																			// it
							String addNewPhone = "";// for Adding new Phone Number
							ArrayList<String> arrayListnew = new ArrayList<>();// new Array List for Storing the number
																				// in it
							for (int i = 0; i < stringArray.length; i++) {
								arrayListnew.add(stringArray[i]);
							}

							System.out.println("Enetr a how many number you want to update: ");
							int numCount = scr1.nextInt();// For Number CountStoing
							for (int k = 0; k < numCount; k++) {
								System.out.println("Eneter a number you want to update : ");
								String oldPhone = scr2.nextLine();// User need to enter old phone number at here
								if (Admin.checkValidPhone(oldPhone)) {
									for (int i = 0; i < arrayListnew.size(); i++) {
										if (arrayListnew.get(i).equals(oldPhone)) {
											System.out.println("Eneter a New Phone Number : ");
											String newPhoneNumber = scr2.nextLine();
											arrayListnew.set(i, newPhoneNumber);// Changing the number at particular
																				// List Index Position
										}

									}
								} else {
									System.err.println("Invalid Phone Number");
								}
							}
							System.out.println(arrayListnew);
							for (int i = 0; i < arrayListnew.size(); i++) {
								addNewPhone += arrayListnew.get(i) + " ";
							}
							userProcess.setPhone(addNewPhone);
							found = true;
							System.out.println("-------------------------------------------------------------");
							break;
						case 4:
							System.out.println("-------------------------------------------------------------");
							System.out.println("Enter New Name ");
							newUserName = scr2.nextLine();
							if (Admin.checkNameValid(newUserName)) {
								System.out.println("Enter New Email ");
								newUserEmail = scr2.nextLine();
								System.out.println("For Phone Number ");
								if (Admin.checkValidEmail(newUserEmail)) {
									demoNumber = userProcess.getPhone();
									System.out.println("You have That Number in your List: " + demoNumber);
									String stringArray1[] = demoNumber.split(" ");
									addNewPhone = "";
									ArrayList<String> ali1 = new ArrayList<>();
									for (int i = 0; i < stringArray1.length; i++) {
										ali1.add(stringArray1[i]);
									}

									System.out.println("Enetr a how many number you want to update: ");

									numCount = scr1.nextInt();
									for (int k = 0; k < numCount; k++) {
										System.out.println("Eneter a number you want to update : ");
										String oldPhone = scr2.nextLine();
										if (Admin.checkValidPhone(oldPhone)) {
											for (int i = 0; i < ali1.size(); i++) {
												if (ali1.get(i).equals(oldPhone)) {
													System.out.println("Eneter a New Number : ");
													String newPhoneNumber = scr2.nextLine();
													ali1.set(i, newPhoneNumber);
												}

											}
										} else {
											System.err.println("Invalid Phone");
										}
									}
									System.out.println(ali1);
									for (int i = 0; i < ali1.size(); i++) {
										addNewPhone += ali1.get(i) + " ";
									}
									listIterator.set(new UserProcess(newUserName, newUserEmail, addNewPhone));

									found = true;
								} else {
									System.err.println("Invalid Email");
								}
							} else {
								System.err.println("Invalid Name");
							}

							break;
						}
					}
				}
				if (!found) {
					System.err.println("Record Not found");
				} else {
					System.out.println("Record is Updated");
				}
				System.out.println("-------------------------------------------------------------");
				break;
			case "6":
				System.out.println("-------------------------------------------------------------");
				arrayList.clear();
				System.out.println("All Record is Deleted From The Console App again Enter");
				System.out.println("-------------------------------------------------------------");
				break;
			case "7":
				System.out.println("---------------------------Program is End----------------------------------");
				System.exit(0);

			default:
				System.out.println("-----------------------------------------------------------------");
				System.out.println("You Press Wrong Thing your program is out now again run it");
				System.out.println("-----------------------------------------------------------------");
				break;

			}
		}
	}
}