package com.task.module;
import java.util.List;
import java.util.stream.Collectors;

public class FetchUser {
	public static void fetchAllUser(List<UserProcess> userList) {
		userList.forEach(
				user -> System.out.println(user.getName() + " : " + user.getEmail() + " : " + user.getPhone()));
	}

	public static void fetchSingleUser(List<UserProcess> userList, String userEmail) {
		UserProcess userFetch = userList.stream().filter(user ->user.getEmail().equalsIgnoreCase(userEmail.trim())).collect(Collectors.toList()).get(0);
		if (userFetch != null) {
			System.out.println(userFetch.getName() + " : " + userFetch.getEmail() + " : " + userFetch.getPhone());
		} else {
			throw new RuntimeException("UserNotFound Exception");
		}
	}
}
