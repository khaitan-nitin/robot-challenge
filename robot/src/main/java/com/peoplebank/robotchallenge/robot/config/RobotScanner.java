package com.peoplebank.robotchallenge.robot.config;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class RobotScanner {
	private final Scanner scanner;

	public RobotScanner() {
		scanner = new Scanner(System.in);
	}

	public String nextLine() {
		return scanner.nextLine();
	}
}
