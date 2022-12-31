package com.peoplebank.robotchallenge.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

	public static boolean isValidFilePath(String filePath) {
		boolean isValid = false;

		File file = new File(filePath);

		if (file.isFile()) {
			isValid = true;
		}

		return isValid;
	}

	public static boolean isValidFileExtension(String filePath, String type) {
		File file = new File(filePath);

		String fileName = file.getName().toUpperCase();

		return fileName.endsWith(".TXT");
	}

	public static List<String> readFile(String filePath) {
		List<String> rows = new ArrayList<>();

		try {
			File myObj = new File(filePath);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				rows.add(myReader.nextLine());
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return rows;
	}

	public static String getResourceFilePath(Class clazz, String fileName) throws Exception {
		URL res = clazz.getClassLoader().getResource(fileName);
		File file = Paths.get(res.toURI()).toFile();

		return file.getAbsolutePath();
	}
}
