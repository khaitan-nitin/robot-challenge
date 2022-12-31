package com.peoplebank.robotchallenge.robot.bean;

import com.peoplebank.robotchallenge.robot.constant.Direction;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

import lombok.Data;

@Data
public class Position {
	private int xCoordinate;
	private int yCoordinate;
	private Direction direction;

	public Position(int xCoordinate, int yCoordinate, Direction direction) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.direction = direction;
	}

	@Override
	public String toString() {
		return String.format(MessageConstant.POSITION_AS_STRING, this.getXCoordinate(), this.getYCoordinate(),
				this.getDirection());
	}
}
