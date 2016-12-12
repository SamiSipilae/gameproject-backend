package com.gameproject.user;

import java.util.List;
import javax.sql.DataSource;

public interface UserDAO {

	public void setDataSource(DataSource ds);

	public void create(String name, String password);

	public User getUser(Integer id);

	public User getUserByName(String name);
	public boolean checkIfNameExists(String name);

	public List<User> listUsers();

	public void delete(Integer id);

	public void update(Integer id, String password);

}
