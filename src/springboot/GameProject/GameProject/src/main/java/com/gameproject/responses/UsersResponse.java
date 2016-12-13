package com.gameproject.responses;

import java.util.List;

import com.gameproject.user.User;

public class UsersResponse {

	private List<User> users;

	public UsersResponse(List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

}
