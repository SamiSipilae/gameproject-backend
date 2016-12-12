package com.gameproject.user;

public class User {

	private String password;
	private String name;
	private Integer id;
	
	public User(String name, String password, int id)
	{
		this.name = name;
		this.password = password;
		this.id = id;
	}
	public User()
	{
		
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}
