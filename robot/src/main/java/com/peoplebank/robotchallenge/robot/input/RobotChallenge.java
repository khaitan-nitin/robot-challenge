package com.peoplebank.robotchallenge.robot.input;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peoplebank.robotchallenge.robot.bean.Challenge;
import com.peoplebank.robotchallenge.robot.config.RobotScanner;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;
import com.peoplebank.robotchallenge.robot.constant.ReaderType;
import com.peoplebank.robotchallenge.robot.reader.Reader;

@Component
public class RobotChallenge {
	private Map<String, Reader> readers;

	private RobotScanner scanner;

	@Autowired
	public RobotChallenge(Map<String, Reader> readers, RobotScanner scanner) {
		this.readers = readers;
		this.scanner = scanner;
	}

	public void takeInput() {
		Challenge challenge = new Challenge();

		while (true) {
			System.out.println(MessageConstant.INIT_COMMAND);
			String commandType = scanner.nextLine();

			if ("KEYBOARD".equalsIgnoreCase(commandType) || "K".equalsIgnoreCase(commandType)) {
				execute(ReaderType.KEYBOARD_READER, challenge);
			} else if ("FILE".equalsIgnoreCase(commandType) || "F".equalsIgnoreCase(commandType)) {
				execute(ReaderType.FILE_READER, challenge);
			} else if ("EXIT".equalsIgnoreCase(commandType) || "E".equalsIgnoreCase(commandType)) {
				System.out.println(MessageConstant.EXIT_COMMAND);
				break;
			} else {
				System.out.println(MessageConstant.INVALID_INPUT_RESPONSE);
			}
		}
	}

	private void execute(ReaderType readerType, Challenge challenge) {
		Reader reader = readers.get(readerType.toString());

		reader.takeInput(challenge);
	}
}
