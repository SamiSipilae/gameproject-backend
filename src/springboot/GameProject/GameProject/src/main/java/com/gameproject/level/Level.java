package com.gameproject.level;

import java.sql.Timestamp;

public class Level {

	private int levelid;
	private float toptime = 0;
	private Integer toptimeuserid = 0;
	private String leveldata;
	private String name;

	
	public void setId(int levelid) {
		this.levelid = levelid;
	}

	public Integer getId() {
		return levelid;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
	public void setTopTime(float toptime) {
		this.toptime = toptime;
	}

	public float getTopTime() {
		return toptime;
	}
	public void setTopTimeUserId(int toptimeuserid) {
		this.toptimeuserid = toptimeuserid;
	}

	public Integer getTopTimeUserId() {
		return toptimeuserid;
	}

	

	public String getLevelData() {
		return leveldata;
	}

	public void setLevelData(String leveldata) {
		this.leveldata = leveldata;
	}

	public Integer getLevelId() {
		return levelid;
	}

}
