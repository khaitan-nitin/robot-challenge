package com.peoplebank.robotchallenge.robot.constant;

public class MessageConstant {
	private MessageConstant() {
	}

	public static String INIT_COMMAND = "Enter the KEYBOARD (K), FILE (F) or EXIT (E): ";

	public static String INVALID_INPUT_RESPONSE = "Invalid input!!! Try again.";

	public static String INIT_FILE_COMMAND = "Enter file path (txt file extension only): ";

	public static String INIT_FILE_COMMAND_INVALID = "Invalid file path/extension!!! Try again.";

	public static String INIT_KEYBOARD_COMMAND = "Enter the command or E to exit from keyboard mode: ";

	public static String CHALLENGE_NOT_INITIALIZED = "Challenge not initiated successfully. Skipping the move.";

	public static String NO_ACTIVE_ROBOT = "No active robot found. Skipping the move.";

	public static String CURRENT_POSITION_NOT_SET = "Current possition not found for the active robot. Skipping the move.";

	public static String KEYBOARD_INVALID_COMMAND = "Invalid command: %s";

	public static String INVALID_ROBOT_COMMAND = "Invalid Robot command: %s";

	public static String INVALID_PLACE_COMMAND = "Invalid Place command: %s";

	public static String LEFT_COMMAND_SUCCESSFUL = "LEFT movement done successfully.";

	public static String RIGHT_COMMAND_SUCCESSFUL = "RIGHT movement done successfully.";

	public static String MOVE_COMMAND_SUCCESSFUL = "Movement to (%d,%d) done successfully.";

	public static String MOVE_COMMAND_UNSUCCESSFUL = "New possition is not a valid position for the active robot. Skipping the move.";

	public static String PLACE_COMMAND_SUCCESSFUL = "PLACE command executed successfully.";

	public static String PLACE_COMMAND_UNSUCCESSFUL = "Invalid PLACE command. Skipping the command.";

	public static String ROBOT_COMMAND_DEFAULT_SET = "Default Robot set successfully.";

	public static String NO_ROBOT_FOUND = "No robot found.";

	public static String ROBOT_INVALID_SEQUENCE_NUMBER = "Invalid sequence number for the robot.";

	public static String ROBOT_ADDED_SUCCESSFULLY = "ROBOT %d added.";

	public static String ROBOT_ACTIVATED_SUCCESSFULLY = "ROBOT %d activated.";

	public static String EXIT_COMMAND = "Exit successfully.";

	public static String POSITION_AS_STRING = "X: %d, Y: %d, direction: %s";

	public static String ROBOT_AS_STRING_WITH_POSITION = "ROBOT %s current position is: %s";

	public static String ROBOT_AS_STRING_WITHOUT_POSITION = "ROBOT %s created but not placed yet.";

	public static String TABLE_AS_STRING = "X Length: %d, Y Length: %d";
}
