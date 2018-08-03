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
import java.util.ArrayList;

public class FileMethods {

	/**
	 * This is a void method to read from a file
	 */
	public static ArrayList<Clothes> readFromFile(String fileName) {
		
		ArrayList<Clothes> productList = new ArrayList<>(); 
		
		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			String[] products = new String[5]; // created to store the parsed data from the file
			//String[] products2 = new String[4];
			while (line != null) {
				products = line.split(","); // parsing the data from the file
				//if (products.length()

				Clothes product = new Clothes(products[0],products[1],products[2],products[3],products[4]); // adding the parsed elements to the object
				
				productList.add(product); // adding the employee object to the list
				
				line = reader.readLine();
			}
			reader.close(); // this flushes the buffer and closes it
		} catch (IOException e) {
			System.out.println("Something went wrong");
		}
		
		for (Clothes c : productList) {

			System.out.println(c);
			
		}
		return productList;
	}
	
	public static ArrayList<Clothes> readFromFileTops(String fileName) {
		
		ArrayList<Clothes> productList = new ArrayList<>(); 
		
		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			String[] products = new String[5]; // created to store the parsed data from the file
			//String[] products2 = new String[4];
			while (line != null) {
				products = line.split(","); // parsing the data from the file
				//if (products.length()

				Clothes product = new Tops(products[0],products[1],products[2],products[3],products[4]); // adding the parsed elements to the object
				
				productList.add(product); // adding the employee object to the list
				
				line = reader.readLine();
			}
			reader.close(); // this flushes the buffer and closes it
		} catch (IOException e) {
			System.out.println("Something went wrong");
		}
		
		return productList;
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
