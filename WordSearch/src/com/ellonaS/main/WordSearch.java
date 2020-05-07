package com.ellonaS.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordSearch {

	
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
		grid = reverseStrings(grid);
		int wordCount = searchTheGridForward(grid, word);
		return wordCount;
	}

	private List<char[]> reverseStrings(List<char[]> grid) {
		for (char[] letters : grid) {
			for (int i = 0; i < letters.length / 2; i++) {
				char swapChar = letters[i];
				letters[i] = letters[letters.length - 1 - i];
				letters[letters.length - 1 - i] = swapChar;
			}
		}
		return grid;
	}

	public int searchTheGridDiagonally(List<char[]> grid, String word) {
		List<char[]> diagonalLeftToRight = loopThroughDiagonals(grid);
		List<char[]> diagonalRightToLeft = loopThroughDiagonals(reverseStrings(grid));
		//
		List <char[]> diagonalStrings = new ArrayList <char[]>();
		diagonalStrings.addAll(diagonalRightToLeft);
		diagonalStrings.addAll(diagonalLeftToRight);
		
		return searchTheGridForward(diagonalStrings, word);
	}

	private List<char[]> loopThroughDiagonals(List<char[]> grid) {
		
		// list of arrays to array of arrays
		char[][] matrix = grid.toArray(new char[0][]);
		int length = matrix.length;
		int diagonalLines = (length + length) - 1;
		int itemsInDiagonal = 0;
		int midPoint = (diagonalLines / 2) + 1;
		List<char[]> letters = new ArrayList<char[]>();

		for (int i = 1; i <= diagonalLines; i++) {

			StringBuilder items = new StringBuilder();
			int rowIndex;
			int columnIndex;

			if (i <= midPoint) {
				itemsInDiagonal++;
				for (int j = 0; j < itemsInDiagonal; j++) {
					rowIndex = (i - j) - 1;
					columnIndex = j;
					items.append(matrix[rowIndex][columnIndex]);
				}
			} else {
				itemsInDiagonal--;
				for (int j = 0; j < itemsInDiagonal; j++) {
					rowIndex = (length - 1) - j;
					columnIndex = (i - length) + j;
					items.append(matrix[rowIndex][columnIndex]);
				}
			}

			letters.add(items.toString().toCharArray());
		}
		return letters;
	}

}
