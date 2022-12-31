package com.peoplebank.robotchallenge.robot.input;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.peoplebank.robotchallenge.robot.command.CommandInvoker;
import com.peoplebank.robotchallenge.robot.config.RobotScanner;
import com.peoplebank.robotchallenge.robot.constant.ReaderType;
import com.peoplebank.robotchallenge.robot.reader.FileReader;
import com.peoplebank.robotchallenge.robot.reader.KeyboardReader;
import com.peoplebank.robotchallenge.robot.reader.Reader;

public class RobotBaseTest {
	protected RobotChallenge robotChallenge;

	private KeyboardReader keyboardReader;

	private FileReader fileReader;

	@Mock
	protected RobotScanner mockScanner;

	@Autowired
	private CommandInvoker commandInvoker;

	@BeforeEach
	void setup() {
		keyboardReader = new KeyboardReader(commandInvoker, mockScanner);

		fileReader = new FileReader(commandInvoker, mockScanner);

		Map<String, Reader> readers = new HashMap<>();

		readers.put(ReaderType.FILE_READER.toString(), fileReader);
		readers.put(ReaderType.KEYBOARD_READER.toString(), keyboardReader);

		robotChallenge = new RobotChallenge(readers, mockScanner);
	}
}
