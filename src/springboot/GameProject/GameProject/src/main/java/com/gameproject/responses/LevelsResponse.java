package com.gameproject.responses;

import java.util.List;

import com.gameproject.level.Level;

public class LevelsResponse {

	private List<Level> levels;

	public LevelsResponse(List<Level> levels) {
		this.levels = levels;
	}

	public List<Level> getLevels() {
		return levels;
	}

}
