package com.gameproject.responses;

import java.util.List;

import com.gameproject.level.Level;
import com.gameproject.session.Session;
import com.gameproject.user.User;

public class SessionsResponse {

	private List<Session> session;

	public SessionsResponse(List<Session> session) {
		this.session = session;
	}

	public List<Session> getSession() {
		return session;
	}

}
