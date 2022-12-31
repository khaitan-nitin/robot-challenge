package com.peoplebank.robotchallenge.robot.bean;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Challenge {
	private Table table;

	private Robot activeRobot = null;

	private Map<Integer, Robot> robots = new HashMap<>();

	public Challenge() {
		this.setTable(new Table());
	}
}
