package com.peoplebank.robotchallenge.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.peoplebank.robotchallenge.robot.input.RobotChallenge;

@SpringBootApplication(scanBasePackages = { "com.peoplebank.robotchallenge.robot" })
public class Application {
	@Autowired
	private RobotChallenge robotChallenge;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	@Profile("!test")
	CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			robotChallenge.takeInput();
		};
	}
}
