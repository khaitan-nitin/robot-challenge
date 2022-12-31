package com.peoplebank.robotchallenge.robot.bean;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ChallengeBuilder {
	private Challenge challenge;

	private Position position;

	private int robotInstance;
}
