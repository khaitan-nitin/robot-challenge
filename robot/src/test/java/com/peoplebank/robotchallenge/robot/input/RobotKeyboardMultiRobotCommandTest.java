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
public class RobotKeyboardMultiRobotCommandTest extends RobotBaseTest {

	@Test
	void robot_keyboard_two_place_command_same_robot_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "PLACE 4,4,EAST", "REPORT",
				"EXIT", "EXIT");
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
		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 4, 4, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_first_robot_with_robot_command() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "ROBOT 1", "PLACE 4,4,EAST", "REPORT", "EXIT",
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

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 4, 4, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_two_place_command_different_robots_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "ROBOT 2", "PLACE 4,4,EAST",
				"REPORT", "EXIT", "EXIT");
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
		Response.appendRobotAddCommand(expectedResponse, 2);
		Response.appendRobotActiveCommand(expectedResponse, 2);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.EAST.toString(), false);
		Response.appendReportRobotWithPosition(expectedResponse, 2, 4, 4, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_two_robot_at_same_place_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "ROBOT 2", "PLACE 0,0,EAST",
				"REPORT", "EXIT", "EXIT");
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
		Response.appendRobotAddCommand(expectedResponse, 2);
		Response.appendRobotActiveCommand(expectedResponse, 2);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.EAST.toString(), false);
		Response.appendReportRobotWithPosition(expectedResponse, 2, 0, 0, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_two_robot_move_first_robot_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "ROBOT 2", "PLACE 0,0,EAST",
				"ROBOT 1", "MOVE", "REPORT", "EXIT", "EXIT");
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
		Response.appendRobotAddCommand(expectedResponse, 2);
		Response.appendRobotActiveCommand(expectedResponse, 2);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendRobotActiveCommand(expectedResponse, 1);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 0, Direction.EAST.toString(), true);
		Response.appendReportRobotWithPosition(expectedResponse, 2, 0, 0, Direction.EAST.toString(), false);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_two_robot_move_first_robot_then_2nd_robot_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "ROBOT 2", "PLACE 0,0,EAST",
				"ROBOT 1", "MOVE", "ROBOT 2", "MOVE", "MOVE", "REPORT", "EXIT", "EXIT");
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
		Response.appendRobotAddCommand(expectedResponse, 2);
		Response.appendRobotActiveCommand(expectedResponse, 2);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendRobotActiveCommand(expectedResponse, 1);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendRobotActiveCommand(expectedResponse, 2);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendMoveCommand(expectedResponse, 2, 0);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 0, Direction.EAST.toString(), false);
		Response.appendReportRobotWithPosition(expectedResponse, 2, 2, 0, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_2nd_robot_invalid_number_greater_than_added_robots() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "ROBOT 3", "PLACE 1,1,EAST",
				"REPORT", "EXIT", "EXIT");
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
		Response.appendRobotInvalidSequenceNo(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 1, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_2nd_robot_invalid_number_less_than_added_robots() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "ROBOT 0", "PLACE 1,1,EAST",
				"REPORT", "EXIT", "EXIT");
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
		Response.appendRobotInvalidSequenceNo(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 1, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_2nd_robot_command_with_negative_sequence_number() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "ROBOT -2", "PLACE 4,4,EAST",
				"REPORT", "EXIT", "EXIT");
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
		Response.appendInvalidCommand(expectedResponse, "ROBOT -2");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 4, 4, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_2nd_robot_command_with_alphanumeric_sequence_number() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "ROBOT abc", "PLACE 4,4,EAST",
				"REPORT", "EXIT", "EXIT");
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
		Response.appendInvalidCommand(expectedResponse, "ROBOT abc");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendPlaceCommand(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithPosition(expectedResponse, 1, 4, 4, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}
}
