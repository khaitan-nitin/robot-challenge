package com.peoplebank.robotchallenge.robot.reader;

import java.util.List;

import org.springframework.stereotype.Component;

import com.peoplebank.robotchallenge.robot.bean.Challenge;
import com.peoplebank.robotchallenge.robot.command.CommandInvoker;
import com.peoplebank.robotchallenge.robot.config.RobotScanner;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;
import com.peoplebank.robotchallenge.utility.FileUtils;

@Component("FILE_READER")
public class FileReader implements Reader {
	private CommandInvoker commandInvoker;

	private RobotScanner scanner;

	public FileReader(CommandInvoker commandInvoker, RobotScanner scanner) {
		this.commandInvoker = commandInvoker;
		this.scanner = scanner;
	}

	@Override
	public void takeInput(Challenge challenge) {
		while (true) {
			System.out.println(MessageConstant.INIT_FILE_COMMAND);
			String filePath = scanner.nextLine();

			if (FileUtils.isValidFilePath(filePath) && FileUtils.isValidFileExtension(filePath, "txt")) {
				List<String> commands = FileUtils.readFile(filePath);

				commandInvoker.invoke(commands, challenge);
				break;
			} else {
				System.out.println(MessageConstant.INIT_FILE_COMMAND_INVALID);
			}
		}
	}
}
