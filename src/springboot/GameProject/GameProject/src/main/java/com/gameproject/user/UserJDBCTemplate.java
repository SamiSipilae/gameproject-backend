package com.gameproject.user;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public boolean checkIfNameExists(String name) {
		String SQL = "SELECT count(*) FROM users where name= ?";

		Integer cnt = jdbcTemplateObject.queryForObject(SQL, Integer.class, name);

		return cnt != null && cnt > 0;
	}

	public void create(String name, String password) {
		String SQL = "insert into Users (name, password) values (?, ?)";

		jdbcTemplateObject.update(SQL, name, password);
		return;
	}

	public User getUser(Integer id) {
		String SQL = "select * from Users where id = ?";
		User user = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new UserMapper());
		return user;
	}

	public User getUserByName(String name) {
		String SQL = "select * from Users where name = ?";
		User user = jdbcTemplateObject.queryForObject(SQL, new Object[] { name }, new UserMapper());
		return user;
	}

	public List<User> listUsers() {
		String SQL = "select * from Users";
		List<User> users = jdbcTemplateObject.query(SQL, new UserMapper());
		return users;
	}

	public void delete(Integer id) {
		String SQL = "delete from Users where id = ?";
		jdbcTemplateObject.update(SQL, id);
		return;
	}

	public void update(Integer id, String password) {
		String SQL = "update Users set password = ? where id = ?";
		jdbcTemplateObject.update(SQL, password, id);
		return;
	}

}