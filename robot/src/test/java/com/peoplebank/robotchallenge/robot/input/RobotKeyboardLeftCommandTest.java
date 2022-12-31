package com.peoplebank.robotchallenge.robot.input;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.peoplebank.robotchallenge.robot.constant.Direction;
import com.peoplebank.robotchallenge.robot.output.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class RobotKeyboardLeftCommandTest extends RobotBaseTest {

	@Test
	void robot_keyboard_left_command_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "LEFT", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.NORTH.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_left_command_lowercase_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "left", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.NORTH.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_left_command_mixcase_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "LeFt", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.NORTH.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_6_times_left_command_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "LEFT", "LEFT", "LEFT", "LEFT",
				"LEFT", "LEFT", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.WEST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_left_without_place_command_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "LEFT", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendNoActiveRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_left_command_after_invalid_place_command() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST_INVALID", "LEFT", "REPORT", "EXIT",
				"EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE 0,0,EAST_INVALID");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoActiveRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_left_command_after_move_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "MOVE", "LEFT", "REPORT", "EXIT",
				"EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 0, Direction.NORTH.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_left_command_before_move_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "LEFT", "MOVE", "REPORT", "EXIT",
				"EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendMoveCommand(expectedResponse, 0, 1);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 1, Direction.NORTH.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_left_command_after_right_command() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "RIGHT", "LEFT", "REPORT", "EXIT",
				"EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendRightCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendLeftCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}
}
