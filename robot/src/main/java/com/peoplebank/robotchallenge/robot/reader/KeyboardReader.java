package com.peoplebank.robotchallenge.robot.reader;

import org.springframework.stereotype.Component;

import com.peoplebank.robotchallenge.robot.bean.Challenge;
import com.peoplebank.robotchallenge.robot.command.CommandInvoker;
import com.peoplebank.robotchallenge.robot.config.RobotScanner;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

@Component("KEYBOARD_READER")
public class KeyboardReader implements Reader {
	private CommandInvoker commandInvoker;

	private RobotScanner scanner;

	public KeyboardReader(CommandInvoker commandInvoker, RobotScanner scanner) {
		this.commandInvoker = commandInvoker;
		this.scanner = scanner;
	}

	@Override
	public void takeInput(Challenge challenge) {
		while (true) {
			System.out.println(MessageConstant.INIT_KEYBOARD_COMMAND);
			String command = scanner.nextLine();

			if ("EXIT".equalsIgnoreCase(command) || "E".equalsIgnoreCase(command)) {
				break;
			} else {
				commandInvoker.invoke(command, challenge);
			}
		}
	}
}
