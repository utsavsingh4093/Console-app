package com.task.module;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class UpdateAllDetailsClass {
public static void updateAllDeatilUser(ListIterator<UserProcess> userIterator,UserProcess userProcess,Scanner stringInput,Scanner integerInput)
{
	try {
		boolean found=true;
		System.out.println("Enter New Name ");
		String newName = stringInput.nextLine();
		if (ValidationChecker.checkNameValid(newName)) {
			String newUserName = newName.trim();
			System.out.println("Enter New Email ");
			String newEmail = stringInput.nextLine();
			System.out.println("For Phone Number ");
			String newUserEamil = "";
			if (ValidationChecker.checkValidEmail(newEmail)) {
				newUserEamil = newEmail.trim();
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
					if (ValidationChecker.checkValidPhone(oldPhone)) {
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
					addNewPhone += ali1.get(i) + " ";
				}
				userIterator.set(new UserProcess(newUserName, newUserEamil, addNewPhone));

				found = true;
			} else {
				System.err.println("Invalid Email");
				Admin.AdminForUser();
			}
		} else {
			System.err.println("Invalid Name");
			Admin.AdminForUser();
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
}

