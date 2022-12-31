package com.peoplebank.robotchallenge.robot.constant;

public enum Direction {
	NORTH, EAST, SOUTH, WEST;

	static public final Direction[] directions = values();

	public Direction left() {
		return directions[(ordinal() - 1 + directions.length) % directions.length];
	}

	public Direction right() {
		return directions[(ordinal() + 1) % directions.length];
	}
}
