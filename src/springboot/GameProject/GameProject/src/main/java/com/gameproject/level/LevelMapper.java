package com.gameproject.level;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.gameproject.session.Session;
import com.gameproject.user.User;

public class LevelMapper implements RowMapper<Level> {
	public Level mapRow(ResultSet rs, int rowNum) throws SQLException {
		Level level = new Level();
		level.setId(rs.getInt("levelid"));
		level.setName(rs.getString("name"));
		level.setTopTime(rs.getFloat("toptime"));
		level.setTopTimeUserId(rs.getInt("topuser"));
		level.setLevelData(rs.getString("data"));
		return level;
	}
}
