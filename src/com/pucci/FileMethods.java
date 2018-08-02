package com.pucci;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMethods {

	/**
	 * This is a void method to read from a file
	 */
	public static String[] readFromFile(String fileName) {

		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();

			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Something went wrong");
		}
		return null;
	}

	public static void writeToFile(String fileName, Clothes product) {

		Path writeFile = Paths.get(fileName);

		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));

			outW.println(product);
			outW.close();
			System.out.println("Yessir");
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		}

	}

	public static void overWriteFile(String fileName, String[] array) {

		Path writeFile = Paths.get(fileName);

		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file));

			outW.println(array);
			outW.close();
			System.out.println("Yessir");
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found");
		}

	}

	public static void createFile(String fileName) {

		Path filePath = Paths.get(fileName);

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("File was created successfully!");
			} catch (IOException e) {
				System.out.println("Something went wrong with the file creation");

			}
		}

		System.out.println("File name: " + filePath.getFileName());
		System.out.println("Absolute at: " + filePath.toAbsolutePath());

	}

}
