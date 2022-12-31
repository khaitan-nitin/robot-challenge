package com.peoplebank.robotchallenge.robot.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peoplebank.robotchallenge.robot.bean.Challenge;
import com.peoplebank.robotchallenge.robot.bean.ChallengeBuilder;
import com.peoplebank.robotchallenge.robot.bean.ChallengeBuilder.ChallengeBuilderBuilder;
import com.peoplebank.robotchallenge.robot.bean.Position;
import com.peoplebank.robotchallenge.robot.constant.Direction;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

@Component
public class CommandInvoker {
	@Autowired
	private PlaceCommand placeCommand;

	@Autowired
	private MoveCommand moveCommand;

	@Autowired
	private LeftCommand leftCommand;

	@Autowired
	private RightCommand rightCommand;

	@Autowired
	private RobotCommand robotCommand;

	@Autowired
	private ReportCommand reportCommand;

	public void invoke(List<String> commands, Challenge challenge) {
		commands.stream().forEach(command -> invoke(command, challenge));
	}

	public void invoke(String command, Challenge challenge) {
		ChallengeBuilderBuilder challengeBuilder = ChallengeBuilder.builder().challenge(challenge);

		String cleanCommand = command.toUpperCase().trim().replaceAll("\\s+", " ");
		switch (cleanCommand) {
		case "LEFT":
			leftCommand.execute(challengeBuilder.build());
			break;
		case "RIGHT":
			rightCommand.execute(challengeBuilder.build());
			break;
		case "MOVE":
			moveCommand.execute(challengeBuilder.build());
			break;
		case "REPORT":
			reportCommand.execute(challengeBuilder.build());
			break;
		default:
			if (cleanCommand.matches("PLACE\\s+\\d+\\s*,\\s*\\d+\\s*,\\s*(NORTH|SOUTH|EAST|WEST)$")) {
				preparePlaceCommand(cleanCommand, challengeBuilder);
			} else if (cleanCommand.matches("ROBOT\\s+\\d+\\s*$")) {
				prepareRobotCommand(cleanCommand, challengeBuilder);
			} else {
				System.out.println(String.format(MessageConstant.KEYBOARD_INVALID_COMMAND, command));
			}
		}
	}

	private void prepareRobotCommand(String command, ChallengeBuilderBuilder challengeBuilder) {
		try {
			String[] subCommands = command.split("[\\s,]+");

			int robotNumber = Integer.parseInt(subCommands[1]);

			challengeBuilder.robotInstance(robotNumber);
			robotCommand.execute(challengeBuilder.build());
		} catch (Exception ex) {
			System.out.println(String.format(MessageConstant.INVALID_ROBOT_COMMAND, command));
		}
	}

	private void preparePlaceCommand(String command, ChallengeBuilderBuilder challengeBuilder) {
		try {
			String[] subCommands = command.split("[\\s,]+");

			int xCoordinate = Integer.parseInt(subCommands[1]);
			int yCoordinate = Integer.parseInt(subCommands[2]);
			Direction direction = Direction.valueOf(subCommands[3]);

			Position position = new Position(xCoordinate, yCoordinate, direction);

			challengeBuilder.position(position);
			placeCommand.execute(challengeBuilder.build());
		} catch (Exception ex) {
			System.out.println(String.format(MessageConstant.INVALID_PLACE_COMMAND, command));
		}
	}
}
