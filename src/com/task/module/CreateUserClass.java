package com.task.module;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class CreateUserClass {
	public static void createUser(List<UserProcess> userList,Scanner integerInput,Scanner stringInput)
	{
		try {
			System.out.println("Enter User Name : ");
			String userName = stringInput.nextLine();
			 if (!ValidationChecker.checkNameValid(userName)) {
				System.err.println("You Name is Invalid");
				Admin.AdminForUser();
			}
			System.out.println("Enter User Email : ");
			String userEmail = stringInput.nextLine();
			if (!ValidationChecker.checkValidEmail(userEmail.trim())) {
				System.err.println("Invalid Email Try again:");
				Admin.AdminForUser();
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
				if (ValidationChecker.checkValidPhone(userPhone)) {
					phoneNum += userPhone + " ";
					flag = 0;
				} else {
					System.err.println("Invalid Phone Number Try Again ");
					Admin.AdminForUser();
					flag = 1;
				}
			}
			}else {
				System.out.println("you Eneter the number outof Range");
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
	}
	public static void createNewUserName(UserProcess userProcess,Scanner stringInput)
	{
		try {
			boolean found=true;
			System.out.println("Enter new name ");
			String newName = stringInput.nextLine();
			if (ValidationChecker.checkNameValid(newName)) {
				String newUserName = newName.trim();
				userProcess.setName(newUserName);
				found = true;
			}
			if (!found) {
				System.err.println("Record Not found");
			} else {
				System.out.println("Record is Updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void createNewUserEmail(UserProcess userProcess,Scanner stringInput)
	{
		try {
			System.out.println("Enter new email ");
			String newEmail = stringInput.nextLine();
			boolean found=true;
			if (ValidationChecker.checkValidEmail(newEmail.trim())) {
					userProcess.setEmail(newEmail);
					found = true;
				} 
			 else {
				System.err.println("Invalid Email Try again");
			}
			if (!found) {
				System.err.println("Record Not found");
			} else {
				System.out.println("Record is Updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void createNewUserPhone(UserProcess userProcess,Scanner stringInput,Scanner integerInput)
	{
		try {
			boolean found=true;
			String demoNumber = userProcess.getPhone();
			System.out.println("You have That Number in your List: " + demoNumber);
			String stringArray[] = demoNumber.split(" ");// This array is For Containing the
															// number in
															// it
			String addNewPhone = "";// for Adding new Phone Number
			ArrayList<String> numberList = new ArrayList<>();// new Array List for Storing the
																// number
																// in it
			for (int i = 0; i < stringArray.length; i++) {
				numberList.add(stringArray[i]);
			}

			System.out.println("Enetr a how many number you want to update: ");
			int numCount = integerInput.nextInt();// For Number CountStoing
			if (numCount <= numberList.size()) {
				for (int k = 0; k < numCount; k++) {
					System.out.println("Eneter a number you want to update : ");
					String oldPhone = stringInput.nextLine();// User need to enter old phone
																// number at here
					if (ValidationChecker.checkValidPhone(oldPhone)) {
						for (int i = 0; i < numberList.size(); i++) {
							if (numberList.get(i).equals(oldPhone)) {
								System.out.println("Eneter a New Phone Number : ");
								String newPhoneNumber = stringInput.nextLine().trim();
								numberList.set(i, newPhoneNumber);// Changing the number at
																	// particular
																	// List Index Position
							}

						}
					} else {
						System.err.println("Invalid Phone Number");
					}
				}
			} else {
				System.err.println(
						"You need to Enetr a number according to size if array your array size is : "
								+ numberList.size());
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
