package com.peoplebank.robotchallenge.robot.output;

import java.util.List;

import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

public class Response {

	public static void appendInitCommand(List<String> response) {
		response.add(MessageConstant.INIT_COMMAND);
	}

	public static void appendKeyboardInitCommand(List<String> response) {
		response.add(MessageConstant.INIT_KEYBOARD_COMMAND);
	}

	public static void appendFileInitCommand(List<String> response) {
		response.add(MessageConstant.INIT_FILE_COMMAND);
	}

	public static void appendInvalidCommand(List<String> response, String command) {
		response.add(String.format(MessageConstant.KEYBOARD_INVALID_COMMAND, command));
	}

	public static void appendRobotAddCommand(List<String> response, int robotInstance) {
		response.add(String.format(MessageConstant.ROBOT_ADDED_SUCCESSFULLY, robotInstance));
	}

	public static void appendRobotActiveCommand(List<String> response, int robotInstance) {
		response.add(String.format(MessageConstant.ROBOT_ACTIVATED_SUCCESSFULLY, robotInstance));
	}

	public static void appendRobotInvalidSequenceNo(List<String> response) {
		response.add(MessageConstant.ROBOT_INVALID_SEQUENCE_NUMBER);
	}

	public static void appendRobotDefaultCommand(List<String> response) {
		response.add(MessageConstant.ROBOT_COMMAND_DEFAULT_SET);
	}

	public static void appendPlaceCommand(List<String> response) {
		response.add(MessageConstant.PLACE_COMMAND_SUCCESSFUL);
	}

	public static void appendPlaceCommandUnsuccessful(List<String> response) {
		response.add(MessageConstant.PLACE_COMMAND_UNSUCCESSFUL);
	}

	public static void appendLeftCommand(List<String> response) {
		response.add(MessageConstant.LEFT_COMMAND_SUCCESSFUL);
	}

	public static void appendRightCommand(List<String> response) {
		response.add(MessageConstant.RIGHT_COMMAND_SUCCESSFUL);
	}

	public static void appendMoveCommand(List<String> response, int x, int y) {
		response.add(String.format(MessageConstant.MOVE_COMMAND_SUCCESSFUL, x, y));
	}

	public static void appendMoveCommandUnsuccessful(List<String> response) {
		response.add(MessageConstant.MOVE_COMMAND_UNSUCCESSFUL);
	}

	public static void appendReportRobotWithPosition(List<String> response, int robotInstance, int x, int y,
			String direction, boolean isActive) {
		String activeString = "";
		if (isActive) {
			activeString = " (ACTIVE)";
		}

		String positionString = String.format(MessageConstant.POSITION_AS_STRING, x, y, direction);
		String robot = String.format(MessageConstant.ROBOT_AS_STRING_WITH_POSITION, robotInstance, positionString);

		response.add(robot + activeString);
	}

	public static void appendReportRobotWithoutPosition(List<String> response, int robotInstance, boolean isActive) {
		String activeString = "";
		if (isActive) {
			activeString = " (ACTIVE)";
		}

		String robot = String.format(MessageConstant.ROBOT_AS_STRING_WITHOUT_POSITION, robotInstance);

		response.add(robot + activeString);
	}

	public static void appendExitCommand(List<String> response) {
		response.add(MessageConstant.EXIT_COMMAND);
	}

	public static void appendNoRobotFound(List<String> response) {
		response.add(MessageConstant.NO_ROBOT_FOUND);
	}

	public static void appendNoActiveRobotFound(List<String> response) {
		response.add(MessageConstant.NO_ACTIVE_ROBOT);
	}
}
