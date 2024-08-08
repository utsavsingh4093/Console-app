package com.task.module;

import java.util.*;
public class Admin {
	public static boolean checkNameValid(String name) {
		String regexName = "[\\s]{0}[a-zA-Z]+[\\s]{0,1}[a-zA-Z]{0,50}[\\s]*";
		boolean check = name.matches(regexName);
		return check;
	}

	public static boolean checkValidEmail(String emai) {
		String regxEmail = "[\\s]{0}[a-zA-Z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-Z]{2,3}[\\s]*";
		boolean check = emai.matches(regxEmail);
		return check;
	}

	public static boolean checkValidPhone(String number) {
		String regxPhone = "[\\s]{0}[6-9][0-9]{9}[\\s]*";
		boolean check = number.matches(regxPhone);
		return check;
	}

	public static void main(String[] args) {
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
              if(operation.equals("")||(operation.endsWith(" "))){
            	  continue;
              }
              else {
			switch (operation) {
			case "1":
				System.out.println("-------------------------------------------------------------");
				try {
				System.out.println("Enter User Name : ");
				String userName = stringInput.nextLine();
				if (Admin.checkNameValid(userName)) {
					System.out.print("");
				} else if (!Admin.checkNameValid(userName)) {
					System.err.println("You Name is Invalid");
					break;
				}
				System.out.println("Enter User Email : ");
				String userEmail = stringInput.nextLine();
				if (!Admin.checkValidEmail(userEmail.trim())) {
					System.err.println("Invalid Email Try again:");
					break;
				}
				int flag = 0;
				String phoneNum = "";
				System.out.println("User can have number within 1 to 7 range : ");
				int count = integerInput.nextInt();// Here is count of number
				if(count<=7)
				{
					phoneNum = "";
				for (int i = 0; i < count; i++) {
					System.out.println("Enter User Phone Number : ");
					String userPhone = stringInput.nextLine().trim();
					if (Admin.checkValidPhone(userPhone)) {
						phoneNum += userPhone + " ";
						flag = 0;
					} else {
						System.err.println("Invalid Phone Number Try Again ");
						flag = 1;
						break;
					}
				}
				}else {
					System.out.println("you Eneter the number outof Range");
    				break;
				}
				boolean found = false;
				if (flag == 0) {
					for (UserProcess u : userList) {
						if (u.getEmail().equals(userEmail)) {
							found = true;
							break;
						}
					}
					if (!found) {
						userList.add(new UserProcess(userName.trim(), userEmail.trim(), phoneNum.trim()));
						System.out.println("User Added Successfully");
					} else {
						System.err.println("User is Alerady Exist with this Email create new Email");
					}
				}
				}
				catch (Exception e) {
					e.printStackTrace();	// TODO: handle exception
				}
				System.out.println("-------------------------------------------------------------");
				 
				break;
			case "2":
				
				System.out.println("-------------------------------------------------------------");
				try {
				if(userList.size()==0)
				{
					System.out.println("No User Avalilable Empty");
				}
				else {
				for (UserProcess userProcess : userList) {
					System.out.println(
							userProcess.getName() + " : " + userProcess.getEmail() + " : " + userProcess.getPhone());
				}
				}
				}catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("-------------------------------------------------------------");
				break;

			case "3":
				try {
					System.out.println("-------------------------------------------------------------");
					System.out.println("Enter name For Search : ");
					String name1 = stringInput.nextLine();
					boolean found1 = false;
					for (UserProcess userProcess : userList) {
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
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("-------------------------------------------------------------");
				break;

			case "5":
				System.out.println("-------------------------------------------------------------");
				System.out.println("Enter name you want to Update All Details : ");
				String userName = stringInput.nextLine();
			       ListIterator<UserProcess>  userIterator = userList.listIterator();
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
							try {
							System.out.println("Enter new name ");
							String newName = stringInput.nextLine();
							if (Admin.checkNameValid(newName)) {
								String newUserName=newName.trim();
								userProcess.setName(newUserName);
								found = true;
							}
							if (!found) {
								System.err.println("Record Not found");
							} else {
								System.out.println("Record is Updated");
							}
							}catch (Exception e) {
								e.printStackTrace();
							}
							 
							System.out.println("-------------------------------------------------------------");
							break;
						case 2:
							System.out.println("-------------------------------------------------------------");
							try {
							System.out.println("Enter new email ");
							String newEmail = stringInput.nextLine();

							if (Admin.checkValidEmail(newEmail.trim())) {
								String newUserEmail=newEmail;
								if(userProcess.getEmail().equalsIgnoreCase(newUserEmail)){
								userProcess.setEmail(newUserEmail);
								found = true;
								}else {
									System.err.println("User alerady have that Email Try again");
									break;
								}
							} else {
								System.err.println("Invalid Email Try again");
							}
							if (!found) {
								System.err.println("Record Not found");
							} else {
								System.out.println("Record is Updated");
							}
							}catch (Exception e) {
								e.printStackTrace();
							}
							 
							System.out.println("-------------------------------------------------------------");
							break;
						case 3:
							System.out.println("-------------------------------------------------------------");
							try {
							String demoNumber = userProcess.getPhone();
							String stringArray[] = demoNumber.split(" ");// This array is For Containing the number in
																			// it
							String addNewPhone = "";// for Adding new Phone Number
							ArrayList<String> numberList = new ArrayList<>();// new Array List for Storing the number
																				// in it
							for (int i = 0; i < stringArray.length; i++) {
								numberList.add(stringArray[i]);
							}

							System.out.println("Enetr a how many number you want to update: ");
							int numCount = integerInput.nextInt();// For Number CountStoing
							if(numCount<=numberList.size()) {
							for (int k = 0; k < numCount; k++) {
								System.out.println("Eneter a number you want to update : ");
								String oldPhone = stringInput.nextLine();// User need to enter old phone number at here
								if (Admin.checkValidPhone(oldPhone)) {
									for (int i = 0; i < numberList.size(); i++) {
										if (numberList.get(i).equals(oldPhone)) {
											System.out.println("Eneter a New Phone Number : ");
											String newPhoneNumber = stringInput.nextLine().trim();
											numberList.set(i, newPhoneNumber);// Changing the number at particular
																				// List Index Position
										}

									}
								} else {
									System.err.println("Invalid Phone Number");
								}
							}
							}
							else {
								System.err.println("You need to Enetr a number according to size if array your array size is : "+numberList.size());
							}
							for (int i = 0; i < numberList.size(); i++) {
								addNewPhone += numberList.get(i) + " ";
							}
							userProcess.setPhone(addNewPhone);
							found = true;
							if (!found) {
								System.err.println("Record Not found");
							} else {
								System.out.println("Record is Updated");
							}
							}
							catch (Exception e) {
								e.printStackTrace();
							}
							System.out.println("-------------------------------------------------------------");
							break;
						case 4:
							System.out.println("-------------------------------------------------------------");
							try {
							System.out.println("Enter New Name ");
						String newName = stringInput.nextLine();
							if (Admin.checkNameValid(newName)) {
								String newUserName=newName.trim();
								System.out.println("Enter New Email ");
								String newEmail = stringInput.nextLine();
								System.out.println("For Phone Number ");
								String newUserEamil="";
								if (Admin.checkValidEmail(newEmail)) {
									 newUserEamil=newEmail.trim();
									String demoNumber = userProcess.getPhone();
									System.out.println("You have That Number in your List: " + demoNumber);
									String stringArrayy[] = demoNumber.split(" ");
									String addNewPhone = "";
									ArrayList<String> ali1 = new ArrayList<>();
									for (int i = 0; i < stringArrayy.length; i++) {
										ali1.add(stringArrayy[i]);
									}

									System.out.println("Enetr a how many number you want to update: ");

									int numCount = integerInput.nextInt();
									for (int k = 0; k < numCount; k++) {
										System.out.println("Eneter a number you want to update : ");
										String oldPhone = stringInput.nextLine();
										if (Admin.checkValidPhone(oldPhone)) {
											for (int i = 0; i < ali1.size(); i++) {
												if (ali1.get(i).equals(oldPhone)) {
													System.out.println("Eneter a New Number : ");
													String newPhoneNumber = stringInput.nextLine();
													ali1.set(i, newPhoneNumber);
												}

											}
										} else {
											System.err.println("Invalid Phone");
											break;
										}
									}
									System.out.println(ali1);
									for (int i = 0; i < ali1.size(); i++) {
										addNewPhone += ali1.get(i) + " ".trim();
									}
									userIterator.set(new UserProcess(newUserName, newUserEamil, addNewPhone));

									found = true;
								} else {
									System.err.println("Invalid Email");
									break;
								}
							} else {
								System.err.println("Invalid Name");
								break;
							}
							if (!found) {
								System.err.println("Record Not found");
							} else {
								System.out.println("Record is Updated");
							}
							}
							catch (Exception e) {
								e.printStackTrace();
							}
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
				}catch (Exception e) {
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
}