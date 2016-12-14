package com.gameproject.level;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class LevelJDBCTemplate implements LevelDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(Level level) {
		String SQL = "insert into levels (name, data) values (?, ?)";
		jdbcTemplateObject.update(SQL, level.getName(), level.getLevelData());
		return;
	}
	public void create(LevelJSON level) {
		String SQL = "insert into levels (name, data) values (?, ?)";
		jdbcTemplateObject.update(SQL, level.getName(), level.getData());
		return;
	}


	public Level getLevel(int levelid) {
		String SQL = "select * from levels where levelid = ?";
		Level level = jdbcTemplateObject.queryForObject(SQL, new Object[] { levelid }, new LevelMapper());
		return level;
	}


	public Level getLevel(String name) {
		String SQL = "select * from levels where name = ?";
		Level level = jdbcTemplateObject.queryForObject(SQL, new Object[] { name }, new LevelMapper());
		return level;
	}
	
	public List<Level> listLevels() {
		String SQL = "select * from levels";
		List<Level> levels = jdbcTemplateObject.query(SQL, new LevelMapper());
		return levels;
	}

	public void delete(Integer levelid) {
		String SQL = "delete from levels where levelid = ?";
		jdbcTemplateObject.update(SQL, levelid);
		return;
	}

	public void updateTopTime(Integer levelid, float time, int userid){
		String SQL = "update levels set toptime = ?,topuser = ? where levelid = ?";
		jdbcTemplateObject.update(SQL, time, userid, levelid);
		return;
	}

}