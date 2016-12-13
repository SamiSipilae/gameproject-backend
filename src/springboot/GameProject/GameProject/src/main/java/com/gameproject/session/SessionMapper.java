package com.gameproject.session;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SessionMapper implements RowMapper<Session> {
	public Session mapRow(ResultSet rs, int rowNum) throws SQLException {
		Session session = new Session();
		session.setUserId(rs.getInt("userid"));
		session.setSessionId(rs.getString("sessionid"));
		session.setTimestamp(rs.getTimestamp("lastupdate"));
		return session;
	}
}
