package com.ellonaS.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

	private List<String> dictionary = new ArrayList<>();

	public List<String> loadWords(String path) {
		
		try {
			File file = new File(path);
			Scanner fileScanner = new Scanner(file);
			while (fileScanner.hasNextLine()) {

				String word = fileScanner.nextLine();
				dictionary.add(word.toUpperCase());
			}
		} catch (Exception e) {
			
			System.out.println("File not found");

		}
		return dictionary;

	}
}
