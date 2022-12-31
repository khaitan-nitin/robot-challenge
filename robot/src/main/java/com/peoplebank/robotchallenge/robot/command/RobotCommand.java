package com.peoplebank.robotchallenge.robot.command;

import org.springframework.stereotype.Component;

import com.peoplebank.robotchallenge.robot.bean.Challenge;
import com.peoplebank.robotchallenge.robot.bean.ChallengeBuilder;
import com.peoplebank.robotchallenge.robot.bean.Robot;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

@Component
public class RobotCommand extends BaseCommand {

	@Override
	public void execute(ChallengeBuilder challengeBuilder) {
		Challenge challenge = challengeBuilder.getChallenge();
		int robotInstance = challengeBuilder.getRobotInstance();

		if (challenge == null) {
			challenge = new Challenge();
		}

		if (challenge.getRobots().size() >= robotInstance) {
			if (robotInstance > 0) {
				activateRobot(challenge, robotInstance);
			} else {
				System.out.println(MessageConstant.ROBOT_INVALID_SEQUENCE_NUMBER);
			}
		} else if (challenge.getRobots().size() < robotInstance) {
			addNewRobot(challenge, robotInstance);
		}
	}

	private void addNewRobot(Challenge challenge, final int number) {
		if (challenge.getRobots().size() + 1 == number) {
			challenge.getRobots().put(number, new Robot(number));
			System.out.println(String.format(MessageConstant.ROBOT_ADDED_SUCCESSFULLY, number));

			activateRobot(challenge, number);
		} else {
			System.out.println(MessageConstant.ROBOT_INVALID_SEQUENCE_NUMBER);
		}
	}

	private void activateRobot(Challenge challenge, int number) {
		challenge.setActiveRobot(challenge.getRobots().get(number));
		System.out.println(String.format(MessageConstant.ROBOT_ACTIVATED_SUCCESSFULLY, number));
	}
}
