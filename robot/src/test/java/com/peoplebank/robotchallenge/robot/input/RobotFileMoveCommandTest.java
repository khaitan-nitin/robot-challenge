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
public class RobotFileMoveCommandTest extends RobotBaseTest {

	@Test
	void robot_file_move_command_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_move_command_valid.txt");
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

		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 0, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_move_command_lowercase_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_move_command_lowercase_valid.txt");
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

		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 0, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_move_command_mixcase_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_move_command_mixcase_valid.txt");
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

		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 0, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_4_times_move_command_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_4_times_move_command_valid.txt");
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

		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendMoveCommand(expectedResponse, 2, 0);

		Response.appendMoveCommand(expectedResponse, 3, 0);

		Response.appendMoveCommand(expectedResponse, 4, 0);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 4, 0, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_move_without_place_command_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_move_without_place_command_valid.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendNoActiveRobotFound(expectedResponse);

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_move_command_after_invalid_place_command() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_move_command_after_invalid_place_command.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE 0,0,EAST_INVALID");

		Response.appendNoActiveRobotFound(expectedResponse);

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_move_command_after_right_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_move_command_after_right_valid.txt");
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

		Response.appendRightCommand(expectedResponse);

		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 1, 0, Direction.SOUTH.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_move_command_after_left_command() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_move_command_after_left_command.txt");
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

		Response.appendLeftCommand(expectedResponse);

		Response.appendMoveCommand(expectedResponse, 0, 1);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 1, Direction.NORTH.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_move_out_of_board() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_move_out_of_board.txt");
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

		Response.appendMoveCommand(expectedResponse, 1, 0);

		Response.appendMoveCommand(expectedResponse, 2, 0);

		Response.appendMoveCommand(expectedResponse, 3, 0);

		Response.appendMoveCommand(expectedResponse, 4, 0);

		Response.appendMoveCommandUnsuccessful(expectedResponse);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 4, 0, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}
}
