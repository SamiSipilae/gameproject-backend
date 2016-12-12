package com.gameproject.responses;

public class GetUserResponse {

	private final long id;
	private final String name;

	public GetUserResponse(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
