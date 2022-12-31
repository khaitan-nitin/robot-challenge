package com.peoplebank.robotchallenge.robot.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
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
import com.peoplebank.robotchallenge.utility.FileUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class RobotFileMultiRobotCommandTest extends RobotBaseTest {

	@Test
	void robot_file_two_place_command_same_robot_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_two_place_command_same_robot_valid.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 4, 4, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_first_robot_with_robot_command() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_first_robot_with_robot_command.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);

		Response.appendFileInitCommand(expectedResponse);
		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 4, 4, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_two_place_command_different_robots_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_two_place_command_different_robots_valid.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 2);
		Response.appendRobotActiveCommand(expectedResponse, 2);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.EAST.toString(), false);
		Response.appendReportRobotWithPosition(expectedResponse, 2, 4, 4, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_two_robot_at_same_place_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_two_robot_at_same_place_valid.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 2);
		Response.appendRobotActiveCommand(expectedResponse, 2);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.EAST.toString(), false);
		Response.appendReportRobotWithPosition(expectedResponse, 2, 0, 0, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_two_robot_move_first_robot_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_two_robot_move_first_robot_valid.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 2);
		Response.appendRobotActiveCommand(expectedResponse, 2);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendRobotActiveCommand(expectedResponse, 1);

		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 0, Direction.EAST.toString(), true);
		Response.appendReportRobotWithPosition(expectedResponse, 2, 0, 0, Direction.EAST.toString(), false);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_two_robot_move_first_robot_then_2nd_robot_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_two_robot_move_first_robot_then_2nd_robot_valid.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 2);
		Response.appendRobotActiveCommand(expectedResponse, 2);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendRobotActiveCommand(expectedResponse, 1);

		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendRobotActiveCommand(expectedResponse, 2);

		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendMoveCommand(expectedResponse, 2, 0);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 0, Direction.EAST.toString(), false);
		Response.appendReportRobotWithPosition(expectedResponse, 2, 2, 0, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_2nd_robot_invalid_number_greater_than_added_robots() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_2nd_robot_invalid_number_greater_than_added_robots.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendRobotInvalidSequenceNo(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 1, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_2nd_robot_invalid_number_less_than_added_robots() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_2nd_robot_invalid_number_less_than_added_robots.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendRobotInvalidSequenceNo(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 1, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_2nd_robot_command_with_negative_sequence_number() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_2nd_robot_command_with_negative_sequence_number.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "ROBOT -2");

		Response.appendPlaceCommand(expectedResponse);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 4, 4, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_2nd_robot_command_with_alphanumeric_sequence_number() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_2nd_robot_command_with_alphanumeric_sequence_number.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendRobotAddCommand(expectedResponse, 1);
		Response.appendRobotActiveCommand(expectedResponse, 1);
		Response.appendRobotDefaultCommand(expectedResponse);

		Response.appendPlaceCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "ROBOT abc");

		Response.appendPlaceCommand(expectedResponse);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 4, 4, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}
}
