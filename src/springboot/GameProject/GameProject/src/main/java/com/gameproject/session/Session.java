package com.gameproject.session;

import java.sql.Timestamp;

public class Session {

	private String sessionid;
	private Timestamp timestamp;
	private Integer userid;

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setSessionId(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getSessionId() {
		return sessionid;
	}

	public void setUserId(Integer userid) {
		this.userid = userid;
	}

	public Integer getUserId() {
		return userid;
	}

}
