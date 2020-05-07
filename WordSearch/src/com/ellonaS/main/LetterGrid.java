package com.ellonaS.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LetterGrid {

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

	public List<String> getAllHorizontalLines(List<char[]> grid) {

		List<String> horizontalLines = new ArrayList<>();

		for (char[] array : grid) {
			horizontalLines.add(new String(array));
		}

		return horizontalLines;
	}

	public List<String> getAllVerticalLines(List<char[]> grid) {
		List<String> verticalLines = new ArrayList<>();

		for (int i = 0; i < grid.size(); i++) {
			String verticalLine = "";
			for (int j = 0; j < grid.size(); j++) {
				verticalLine += grid.get(j)[i];
			}
			verticalLines.add(verticalLine);

		}
		return verticalLines;
	}
	
	public List<String> getAllDiagonalLines(List<char[]> grid) {
		List<String> diagonalLeftToRight = loopThroughDiagonals(grid);
		List<String> diagonalRightToLeft = loopThroughDiagonals(reverseCharArrays(grid));
		
		List <String> diagonalStrings = new ArrayList <>();
		diagonalStrings.addAll(diagonalRightToLeft);
		diagonalStrings.addAll(diagonalLeftToRight);
		
		return diagonalStrings;
	}
	private List<char[]> reverseCharArrays(List<char[]> grid) {
		for (char[] letters : grid) {
			for (int i = 0; i < letters.length / 2; i++) {
				char swapChar = letters[i];
				letters[i] = letters[letters.length - 1 - i];
				letters[letters.length - 1 - i] = swapChar;
			}
		}
		return grid;
	}
	
private List<String> loopThroughDiagonals(List<char[]> grid) {
		
		// list of arrays to array of arrays
		char[][] matrix = grid.toArray(new char[0][]);
		int length = matrix.length;
		int diagonalLines = (length + length) - 1;
		int itemsInDiagonal = 0;
		int midPoint = (diagonalLines / 2) + 1;
		List<String> letters = new ArrayList<>();

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

			letters.add(items.toString());
		}
		return letters;
	}

}
