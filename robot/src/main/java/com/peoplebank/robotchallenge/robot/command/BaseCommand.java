package com.peoplebank.robotchallenge.robot.command;

import com.peoplebank.robotchallenge.robot.bean.Challenge;
import com.peoplebank.robotchallenge.robot.bean.ChallengeBuilder;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

public abstract class BaseCommand {
	abstract void execute(final ChallengeBuilder challengeBuilder);

	public boolean isRobotActive(final Challenge challenge) {
		boolean isValid = false;

		if (challenge != null && challenge.getActiveRobot() != null
				&& challenge.getActiveRobot().getCurrentPosition() != null) {
			isValid = true;
		} else if (challenge == null) {
			System.out.println(MessageConstant.CHALLENGE_NOT_INITIALIZED);
		} else if (challenge.getActiveRobot() == null) {
			System.out.println(MessageConstant.NO_ACTIVE_ROBOT);
		} else if (challenge.getActiveRobot().getCurrentPosition() == null) {
			System.out.println(MessageConstant.CURRENT_POSITION_NOT_SET);
		}

		return isValid;
	}
}
