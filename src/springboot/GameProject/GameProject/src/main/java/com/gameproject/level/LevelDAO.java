package com.gameproject.level;

import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;

import com.gameproject.session.Session;
import com.gameproject.user.User;

public interface LevelDAO {

	public void setDataSource(DataSource ds);

	public void create(Level level);

	public Level getLevel(int levelid);
	public Level getLevel(String name);
	
	public List<Level> listLevels();
	
	public void delete(Integer levelid);

	public void updateTopTime(Integer levelid, float time, int userid);

}
