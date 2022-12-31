package com.peoplebank.robotchallenge.robot.bean;

import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

import lombok.Data;

@Data
public class Robot {
	private int number;

	private Position currentPosition = null;

	public Robot(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		String robot;
		if (this.getCurrentPosition() != null) {
			robot = String.format(MessageConstant.ROBOT_AS_STRING_WITH_POSITION, this.getNumber(),
					this.getCurrentPosition());
		} else {
			robot = String.format(MessageConstant.ROBOT_AS_STRING_WITHOUT_POSITION, this.getNumber());
		}
		return robot;
	}
}
