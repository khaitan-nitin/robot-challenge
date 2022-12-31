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
public class RobotKeyboardPlaceCommandTest extends RobotBaseTest {

	@Test
	void robot_keyboard_place_command_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST", "REPORT", "EXIT", "EXIT");
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
		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.EAST.toString(), true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_place_command_invalid_direction() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0,EAST_INVALID", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE 0,0,EAST_INVALID");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_place_command_invalid_x() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE A,0,EAST", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE A,0,EAST");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_place_command_invalid_y() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,B,EAST", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE 0,B,EAST");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_place_command_x_out_of_table() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 5,0,EAST", "REPORT", "EXIT", "EXIT");
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

		Response.appendPlaceCommandUnsuccessful(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithoutPosition(expectedResponse, 1, true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_place_command_y_out_of_table() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,5,EAST", "REPORT", "EXIT", "EXIT");
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

		Response.appendPlaceCommandUnsuccessful(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendReportRobotWithoutPosition(expectedResponse, 1, true);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_place_command_negative_x_out_of_table() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE -5,0,EAST", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE -5,0,EAST");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_place_command_negative_y_out_of_table() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,-5,EAST", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE 0,-5,EAST");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_place_command_without_x_y() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE EAST", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE EAST");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_place_command_without_direction() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE 0,0", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE 0,0");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_place_command_without_x_y_and_direction() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		Mockito.when(mockScanner.nextLine()).thenReturn("KEYBOARD", "PLACE", "REPORT", "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE");

		Response.appendKeyboardInitCommand(expectedResponse);
		Response.appendNoRobotFound(expectedResponse);

		Response.appendKeyboardInitCommand(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_keyboard_two_place_command_valid() throws Exception {
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
}
