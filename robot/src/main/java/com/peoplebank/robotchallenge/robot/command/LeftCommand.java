package com.peoplebank.robotchallenge.robot.command;

import org.springframework.stereotype.Component;

import com.peoplebank.robotchallenge.robot.bean.Challenge;
import com.peoplebank.robotchallenge.robot.bean.ChallengeBuilder;
import com.peoplebank.robotchallenge.robot.bean.Position;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

@Component
public class LeftCommand extends BaseCommand {

	@Override
	public void execute(ChallengeBuilder challengeBuilder) {
		Challenge challenge = challengeBuilder.getChallenge();

		if (isRobotActive(challenge)) {
			Position newPosition = challenge.getActiveRobot().getCurrentPosition();
			newPosition.setDirection(newPosition.getDirection().left());

			challenge.getActiveRobot().setCurrentPosition(newPosition);

			System.out.println(MessageConstant.LEFT_COMMAND_SUCCESSFUL);
		}
	}
}
