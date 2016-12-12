package com.gameproject.level;

import java.sql.Timestamp;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gameproject.session.Session;
import com.gameproject.session.SessionDAO;
import com.gameproject.session.SessionMapper;
import com.gameproject.user.User;
import com.gameproject.user.UserDAO;
import com.gameproject.user.UserMapper;

public class LevelJDBCTemplate implements LevelDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(Level level) {
		String SQL = "insert into Levels (name, data) values (?, ?)";
		jdbcTemplateObject.update(SQL, level.getName(), level.getLevelData());
		return;
	}
	public void create(LevelJSON level) {
		String SQL = "insert into Levels (name, data) values (?, ?)";
		jdbcTemplateObject.update(SQL, level.getName(), level.getData());
		return;
	}


	public Level getLevel(int levelid) {
		String SQL = "select * from Levels where levelid = ?";
		Level level = jdbcTemplateObject.queryForObject(SQL, new Object[] { levelid }, new LevelMapper());
		return level;
	}


	public Level getLevel(String name) {
		String SQL = "select * from Levels where name = ?";
		Level level = jdbcTemplateObject.queryForObject(SQL, new Object[] { name }, new LevelMapper());
		return level;
	}
	
	public List<Level> listLevels() {
		String SQL = "select * from Levels";
		List<Level> levels = jdbcTemplateObject.query(SQL, new LevelMapper());
		return levels;
	}

	public void delete(Integer levelid) {
		String SQL = "delete from Levels where levelid = ?";
		jdbcTemplateObject.update(SQL, levelid);
		return;
	}

	public void updateTopTime(Integer levelid, float time, int userid){
		String SQL = "update Levels set toptime = ?,topuser = ? where levelid = ?";
		jdbcTemplateObject.update(SQL, time, userid, levelid);
		return;
	}

}