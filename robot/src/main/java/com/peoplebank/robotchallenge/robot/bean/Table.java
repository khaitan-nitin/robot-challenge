package com.peoplebank.robotchallenge.robot.bean;

import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

import lombok.Data;

@Data
public class Table {
	private int xAxis;

	private int yAxis;

	public Table() {
		this.xAxis = 5;
		this.yAxis = 5;
	}

	public Table(int xAxis, int yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}

	public boolean isValidPosition(int xCoordinate, int yCoordinate) {
		boolean isValid = false;
		if (xCoordinate >= 0 && xCoordinate < this.xAxis && yCoordinate >= 0 && yCoordinate < this.yAxis) {
			isValid = true;
		}

		return isValid;
	}

	@Override
	public String toString() {
		return String.format(MessageConstant.TABLE_AS_STRING, this.getXAxis(), this.getYAxis());
	}
}
