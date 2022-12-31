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
public class RobotFilePlaceCommandTest extends RobotBaseTest {

	@Test
	void robot_file_place_command_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_valid.txt");
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

		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 0, Direction.EAST.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_place_command_invalid_direction() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_invalid_direction.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE 0,0,EAST_INVALID");

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_place_command_invalid_x() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_invalid_x.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE A,0,EAST");

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_place_command_invalid_y() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_invalid_y.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE 0,B,EAST");

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_place_command_x_out_of_table() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_x_out_of_table.txt");
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

		Response.appendPlaceCommandUnsuccessful(expectedResponse);

		Response.appendReportRobotWithoutPosition(expectedResponse, 1, true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_place_command_y_out_of_table() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_y_out_of_table.txt");
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

		Response.appendPlaceCommandUnsuccessful(expectedResponse);

		Response.appendReportRobotWithoutPosition(expectedResponse, 1, true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_place_command_negative_x_out_of_table() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_negative_x_out_of_table.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE -5,0,EAST");

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_place_command_negative_y_out_of_table() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_negative_y_out_of_table.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE 0,-5,EAST");

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_place_command_without_x_y() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_without_x_y.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE EAST");

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_place_command_without_direction() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_without_direction.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE 0,0");

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_place_command_without_x_y_and_direction() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_place_command_without_x_y_and_direction.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "PLACE");

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_two_place_command_valid() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_two_place_command_valid.txt");
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
}
