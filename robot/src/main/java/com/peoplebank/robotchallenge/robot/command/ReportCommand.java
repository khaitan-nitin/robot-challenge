package com.peoplebank.robotchallenge.robot.command;

import org.springframework.stereotype.Component;

import com.peoplebank.robotchallenge.robot.bean.Challenge;
import com.peoplebank.robotchallenge.robot.bean.ChallengeBuilder;
import com.peoplebank.robotchallenge.robot.constant.MessageConstant;

@Component
public class ReportCommand extends BaseCommand {

	@Override
	public void execute(ChallengeBuilder challengeBuilder) {
		Challenge challenge = challengeBuilder.getChallenge();

		if (challenge != null && challenge.getRobots().size() > 0) {
			for (int index : challenge.getRobots().keySet()) {
				String report = challenge.getRobots().get(index).toString();

				if (challenge.getRobots().get(index).getNumber() == challenge.getActiveRobot().getNumber()) {
					report = report + " (ACTIVE)";
				}
				System.out.println(report);
			}
		} else {
			System.out.println(MessageConstant.NO_ROBOT_FOUND);
		}
	}
}
