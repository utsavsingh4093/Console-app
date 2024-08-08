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
		ArrayList<UserProcess> arrayList = new ArrayList<UserProcess>();
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
             if(operation.contains("\s") || operation.equalsIgnoreCase("")) {
            	 continue;
             }
             else {
			switch (operation) {
			case "1":
				System.out.println("-------------------------------------------------------------");
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
				if (!Admin.checkValidEmail(userEmail)) {
					System.err.println("Invalid Email Try again:");
					break;
				}
				System.out.println("Enetr Number of Phone Number User Have : ");
				int count = integerInput.nextInt();// Here is count of number
				String phoneNum = "";
				int flag = 0;
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
				boolean found = false;
				if (flag == 0) {
					for (UserProcess u : arrayList) {
						if (u.getEmail().equals(userEmail)) {
							found = true;
							break;
						}
					}
					if (!found) {
						arrayList.add(new UserProcess(userName.trim(), userEmail.trim(), phoneNum.trim()));
						System.out.println("User Added Successfully");
					} else {
						System.err.println("User is Alerady Exist with this Email create new Email");
					}
				}
				System.out.println("-------------------------------------------------------------");
				break;
			case "2":
				System.out.println("-------------------------------------------------------------");
				if(arrayList.size()==0)
				{
					System.out.println("No User Avalilable Empty");
				}
				else {
				for (UserProcess userProcess : arrayList) {
					System.out.println(
							userProcess.getName() + " : " + userProcess.getEmail() + " : " + userProcess.getPhone());
				}
				}
				System.out.println("-------------------------------------------------------------");
				break;

			case "3":
				try {
					System.out.println("-------------------------------------------------------------");
					System.out.println("Enter name For Search : ");
					String name1 = stringInput.nextLine();
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
				userName = stringInput.nextLine();
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
				userName = stringInput.nextLine();
				listIterator = arrayList.listIterator();
				for(UserProcess u:arrayList)
				{
					System.out.println(u);
				}
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
						int num = integerInput.nextInt();// For Inner Switch Case Condition
						switch (num) {
						case 1:
							System.out.println("-------------------------------------------------------------");
							System.out.println("Enter new name ");
							String newName = stringInput.nextLine();
							if (Admin.checkNameValid(newName)) {
								String newUserName=newName.trim();
								userProcess.setName(newUserName);
								found = true;
							}
							System.out.println("-------------------------------------------------------------");
							break;
						case 2:
							System.out.println("-------------------------------------------------------------");
							System.out.println("Enter new email ");
							String newEmail = stringInput.nextLine();

							if (Admin.checkValidEmail(newEmail)) {
								String newUserEmail=newEmail;
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
							String stringArray[] = demoNumber.split(" ");// This array is For Containing the number in
																			// it
							String addNewPhone = "";// for Adding new Phone Number
							ArrayList<String> arrayListnew = new ArrayList<>();// new Array List for Storing the number
																				// in it
							for (int i = 0; i < stringArray.length; i++) {
								arrayListnew.add(stringArray[i]);
							}

							System.out.println("Enetr a how many number you want to update: ");
							int numCount = integerInput.nextInt();// For Number CountStoing
							if(numCount<=arrayListnew.size()) {
							for (int k = 0; k < numCount; k++) {
								System.out.println("Eneter a number you want to update : ");
								String oldPhone = stringInput.nextLine();// User need to enter old phone number at here
								if (Admin.checkValidPhone(oldPhone)) {
									for (int i = 0; i < arrayListnew.size(); i++) {
										if (arrayListnew.get(i).equals(oldPhone)) {
											System.out.println("Eneter a New Phone Number : ");
											String newPhoneNumber = stringInput.nextLine().trim();
											arrayListnew.set(i, newPhoneNumber);// Changing the number at particular
																				// List Index Position
										}

									}
								} else {
									System.err.println("Invalid Phone Number");
								}
							}
							}
							else {
								System.err.println("You need to Enetr a number according to size if array your array size is : "+arrayListnew.size());
							}
//							System.out.println(arrayListnew);
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
							newName = stringInput.nextLine();
							if (Admin.checkNameValid(newName)) {
								String newUserName=newName.trim();
								System.out.println("Enter New Email ");
								newEmail = stringInput.nextLine();
								System.out.println("For Phone Number ");
								String newUserEamil="";
								if (Admin.checkValidEmail(newEmail)) {
									 newUserEamil=newEmail.trim();
									demoNumber = userProcess.getPhone();
									System.out.println("You have That Number in your List: " + demoNumber);
									String stringArrayy[] = demoNumber.split(" ");
									addNewPhone = "";
									ArrayList<String> ali1 = new ArrayList<>();
									for (int i = 0; i < stringArrayy.length; i++) {
										ali1.add(stringArrayy[i]);
									}

									System.out.println("Enetr a how many number you want to update: ");

									numCount = integerInput.nextInt();
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
										addNewPhone += ali1.get(i) + ",".trim();
									}
									listIterator.set(new UserProcess(newUserName, newUserEamil, addNewPhone));

									found = true;
								} else {
									System.err.println("Invalid Email");
									break;
								}
							} else {
								System.err.println("Invalid Name");
								break;
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