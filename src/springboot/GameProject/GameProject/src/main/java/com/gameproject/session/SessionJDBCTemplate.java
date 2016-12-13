package com.gameproject.session;

import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class SessionJDBCTemplate implements SessionDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private static final float TIMEOUT = 30 * 60 * 1000;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String sessionid, int userid, Timestamp timestamp) {
		String SQL = "insert into Sessions (sessionid, userid, lastupdate) values (?, ?, ?)";
		jdbcTemplateObject.update(SQL, sessionid, userid, timestamp);
		return;
	}
	
	public boolean checkIfSessionIsValid(String sessionid) {
		String SQL = "SELECT count(*) FROM sessions where sessionid= ?";

		Integer cnt = jdbcTemplateObject.queryForObject(SQL, Integer.class, sessionid);
		if(!(cnt != null && cnt > 0))
		{

			return false;
		}
		
		Session session = getSessionBySessionId(sessionid);
		
		if(session.getTimestamp().getTime() <= System.currentTimeMillis() - TIMEOUT)
		{
			delete(sessionid);
			return false;
		}
		
		return true;
	}
	
	public boolean checkIfSessionExists(int userid) {
		String SQL = "SELECT count(*) FROM sessions where userid= ?";

		Integer cnt = jdbcTemplateObject.queryForObject(SQL, Integer.class, userid);

		return cnt != null && cnt > 0;
	}

	public Session getSessionBySessionId(String sessionid) {
		String SQL = "select * from Sessions where sessionid = ?";
		Session session = jdbcTemplateObject.queryForObject(SQL, new Object[] { sessionid }, new SessionMapper());
		return session;
	}

	public Session getSessionByUserId(int userid) {
		String SQL = "select * from Sessions where userid = ?";
		Session session = jdbcTemplateObject.queryForObject(SQL, new Object[] { userid }, new SessionMapper());
		return session;
	}

	public List<Session> listSessions() {
		String SQL = "select * from Sessions";
		List<Session> session = jdbcTemplateObject.query(SQL, new SessionMapper());
		return session;
	}

	public void delete(Integer userid) {
		String SQL = "delete from Sessions where userid = ?";
		jdbcTemplateObject.update(SQL, userid);
		return;
	}
	public void delete(String sessionid) {
		String SQL = "delete from Sessions where sessionid = ?";
		jdbcTemplateObject.update(SQL, sessionid);
		return;
	}

	public void update(Integer userid, Timestamp timestamp) {
		String SQL = "update Sessions set lastupdate = ? where userid = ?";
		jdbcTemplateObject.update(SQL, timestamp, userid);
		return;
	}

}