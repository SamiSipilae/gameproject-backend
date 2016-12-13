package com.gameproject.session;

import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;

public interface SessionDAO {

	public void setDataSource(DataSource ds);

	public void create(String sessionid, int userid, Timestamp timestamp);

	public Session getSessionBySessionId(String sessionid);

	public boolean checkIfSessionIsValid(String sessionid);
	public boolean checkIfSessionExists(int userid);

	public Session getSessionByUserId(int userid);

	public List<Session> listSessions();

	public void delete(Integer userid);
	public void delete(String sessionid);

	public void update(Integer userid, Timestamp timestamp);

}
