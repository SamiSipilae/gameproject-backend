package com.gameproject.responses;

public class CreateUserResponse {

	private final String status;

	public CreateUserResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
