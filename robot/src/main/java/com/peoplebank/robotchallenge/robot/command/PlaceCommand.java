package com.peoplebank.robotchallenge.robot.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peoplebank.robotchallenge.robot.bean.Challenge;
import com.peoplebank.robotchallenge.robot.bean.ChallengeBuilder;
import com.peoplebank.robotchallenge.robot.bean.Position;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

@Component
public class PlaceCommand extends BaseCommand {
	@Autowired
	private RobotCommand robotCommand;

	@Override
	public void execute(ChallengeBuilder challengeBuilder) {
		createDefaultRobot(challengeBuilder);

		Challenge challenge = challengeBuilder.getChallenge();
		Position position = challengeBuilder.getPosition();

		if (challenge.getTable().isValidPosition(position.getXCoordinate(), position.getYCoordinate())) {
			challenge.getActiveRobot().setCurrentPosition(position);

			System.out.println(MessageConstant.PLACE_COMMAND_SUCCESSFUL);
		} else {
			System.out.println(MessageConstant.PLACE_COMMAND_UNSUCCESSFUL);
		}
	}

	@SuppressWarnings("static-access")
	private void createDefaultRobot(ChallengeBuilder challengeBuilder) {
		if (challengeBuilder.getChallenge().getRobots().size() == 0) {
			challengeBuilder = challengeBuilder.builder().challenge(challengeBuilder.getChallenge())
					.position(challengeBuilder.getPosition()).robotInstance(1).build();

			robotCommand.execute(challengeBuilder);

			System.out.println(MessageConstant.ROBOT_COMMAND_DEFAULT_SET);
		}
	}
}
