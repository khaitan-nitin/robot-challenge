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
public class RobotFileGenericCommandTest extends RobotBaseTest {

	@Test
	void robot_file_invalid_commands() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_invalid_commands.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("FILE", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "asfdas");
		Response.appendInvalidCommand(expectedResponse, "asfdasf");
		Response.appendInvalidCommand(expectedResponse, "");
		Response.appendInvalidCommand(expectedResponse, "");
		Response.appendInvalidCommand(expectedResponse, "asfas");
		Response.appendInvalidCommand(expectedResponse, "afsasf");
		Response.appendInvalidCommand(expectedResponse, "");
		Response.appendInvalidCommand(expectedResponse, "");
		Response.appendInvalidCommand(expectedResponse, "asfa");

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_invalid_commands_lowercase() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_invalid_commands.txt");
		Mockito.when(mockScanner.nextLine()).thenReturn("file", commandFile, "EXIT", "EXIT");
		robotChallenge.takeInput();

		System.setOut(stdout);
		String outputText = byteArrayOutputStream.toString();

		List<String> output = new ArrayList(Arrays.asList(outputText.split("\n")));

		List<String> expectedResponse = new ArrayList<>();
		Response.appendInitCommand(expectedResponse);
		Response.appendFileInitCommand(expectedResponse);

		Response.appendInvalidCommand(expectedResponse, "asfdas");
		Response.appendInvalidCommand(expectedResponse, "asfdasf");
		Response.appendInvalidCommand(expectedResponse, "");
		Response.appendInvalidCommand(expectedResponse, "");
		Response.appendInvalidCommand(expectedResponse, "asfas");
		Response.appendInvalidCommand(expectedResponse, "afsasf");
		Response.appendInvalidCommand(expectedResponse, "");
		Response.appendInvalidCommand(expectedResponse, "");
		Response.appendInvalidCommand(expectedResponse, "asfa");

		Response.appendNoRobotFound(expectedResponse);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}

	@Test
	void robot_file_command_with_space() throws Exception {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(byteArrayOutputStream);
		PrintStream stdout = System.out;
		System.setOut(ps);

		String commandFile = FileUtils.getResourceFilePath(getClass(),
				"scenarios" + File.separator + "robot_file_command_with_space.txt");
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

		Response.appendLeftCommand(expectedResponse);

		Response.appendRightCommand(expectedResponse);

		Response.appendMoveCommand(expectedResponse, 0, 1);

		Response.appendReportRobotWithPosition(expectedResponse, 1, 0, 1, Direction.NORTH.toString(), true);

		Response.appendInitCommand(expectedResponse);
		Response.appendExitCommand(expectedResponse);

		Assertions.assertEquals(expectedResponse, output);
	}
}
