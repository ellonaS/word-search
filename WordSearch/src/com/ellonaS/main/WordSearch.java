package com.ellonaS.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch app = new WordSearch();
		app.displayGrid();

	}

	public List<char[]> generateRandomLetterGrid(int gridSize) {

		List<char[]> grid = new ArrayList<char[]>();

		for (int i = 0; i < gridSize; i++) {
			char[] letters = generateRandomLetterArray(gridSize);
			grid.add(letters);
		}

		return grid;
	}

	private char[] generateRandomLetterArray(int arrayLength) {
		// create a list of all alphabet letters
		List<Character> alphabet = new ArrayList<Character>();
		for (char c = 'A'; c <= 'Z'; c++) {
			alphabet.add(c);
		}
		// create a new char array, loop through and assign each char to random letter
		// from alphabet list
		char[] randomLetters = new char[arrayLength];
		Random random = new Random();
		for (int i = 0; i < randomLetters.length; i++) {
			randomLetters[i] = alphabet.get(random.nextInt(alphabet.size()));

		}
		return randomLetters;
	}

	public void displayGrid() {
		List<char[]> grid = generateRandomLetterGrid(15);
		for (int i = 0; i < grid.size(); i++) {
			String str = new String(grid.get(i));
			System.out.println(str);
		}
	}

	public int searchTheGridForward(List<char[]> grid, String word) {
		int wordCount = 0;
		// loop through list of arrays
		for (int i = 0; i < grid.size(); i++) {
			// cast array to string
			String str = new String(grid.get(i));

			for (int j = 0; j < str.length(); j++) {
				try {
					// search for the word in each string
					if (str.substring(j, j + word.length()).equals(word)) {
						wordCount++;
						j += word.length();
					}
				}
				// catch the exception if you're going out of bounds
				catch (IndexOutOfBoundsException e) {
					System.out.println("caught");
					// check if the last characters contain word
					if (j + word.length() - 1 == str.length()) {
						if (str.substring(j).equals(word)) {
							wordCount++;
						}
					}
				}
			}
		}

		return wordCount;
	}
	
	public int searchTheGridBackward(List<char[]> grid, String word) {
		//loop though the grid and reverse arrays
		for (char[] letters : grid) {
			for (int i = 0; i < letters.length/2; i++) {
				char swapChar = letters[i];
				letters[i] = letters[letters.length - 1 - i];
				letters[letters.length - 1 - i] = swapChar;
			}	
		}
		int wordCount = searchTheGridForward(grid, word);
		return wordCount;
	}
	
	public int searchTheGridForwardDiagonal (List<char[]> grid, String word) {
		return 0;
	}

}
