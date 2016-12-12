package com.gameproject.responses;

public class LoginResponse {

	private final String session;

	public LoginResponse(String session) {
		this.session = session;
	}

	public String getSession() {
		return session;
	}

}
