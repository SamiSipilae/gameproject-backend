package com.gameproject.level;

import java.util.List;
import javax.sql.DataSource;

public interface LevelDAO {

	public void setDataSource(DataSource ds);

	public void create(Level level);

	public Level getLevel(int levelid);
	public Level getLevel(String name);
	
	public List<Level> listLevels();
	
	public void delete(Integer levelid);

	public void updateTopTime(Integer levelid, float time, int userid);

}
