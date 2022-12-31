package com.peoplebank.robotchallenge.robot.command;

import org.springframework.stereotype.Component;

import com.peoplebank.robotchallenge.robot.bean.Challenge;
import com.peoplebank.robotchallenge.robot.bean.ChallengeBuilder;
import com.peoplebank.robotchallenge.robot.bean.Position;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

@Component
public class MoveCommand extends BaseCommand {

	@Override
	public void execute(ChallengeBuilder challengeBuilder) {
		Challenge challenge = challengeBuilder.getChallenge();

		if (isRobotActive(challenge)) {
			moveInDirection(challenge);
		}
	}

	private void moveInDirection(Challenge challenge) {
		Position position = challenge.getActiveRobot().getCurrentPosition();

		switch (position.getDirection()) {
		case EAST:
			moveOneStep(position.getXCoordinate() + 1, position.getYCoordinate(), challenge);
			break;
		case NORTH:
			moveOneStep(position.getXCoordinate(), position.getYCoordinate() + 1, challenge);
			break;
		case SOUTH:
			moveOneStep(position.getXCoordinate(), position.getYCoordinate() - 1, challenge);
			break;
		case WEST:
			moveOneStep(position.getXCoordinate() - 1, position.getYCoordinate(), challenge);
			break;
		default:
			break;
		}
	}

	private void moveOneStep(int xCoordinate, int yCoordinate, Challenge challenge) {
		if (challenge.getTable().isValidPosition(xCoordinate, yCoordinate)) {
			challenge.getActiveRobot().getCurrentPosition().setXCoordinate(xCoordinate);
			challenge.getActiveRobot().getCurrentPosition().setYCoordinate(yCoordinate);

			System.out.println(String.format(MessageConstant.MOVE_COMMAND_SUCCESSFUL, xCoordinate, yCoordinate));
		} else {
			System.out.println(MessageConstant.MOVE_COMMAND_UNSUCCESSFUL);
		}
	}
}
