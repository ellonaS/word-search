package com.ellonaS.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List <char[]> generateRandomLetterGrid(int gridSize) {
		
		List <char[]> grid = new ArrayList <char[]>();
		
		for(int i = 0; i < gridSize; i++) {
			char[] letters = generateRandomLetterArray(gridSize);
			grid.add(letters);
		}
		
		return grid;
	}
	
	private char[] generateRandomLetterArray(int arrayLength) {
		//create an array of all alphabet letters
		char[] alphabet = new char[26];
		for (char c = 'A'; c <= 'Z'; c++) {
			for (int i = 0; i < alphabet.length; i++) {
				alphabet[i] = c;
			}
		}
		//create a new char array, loop through and assign each char to random letter 
		//from alphabet array
		char []randomLetters = new char [arrayLength];
		Random random = new Random();
		for (int i = 0; i < randomLetters.length; i++ ) {
			randomLetters[i] = alphabet [random.nextInt(alphabet.length)];
		}
		return randomLetters;
	}

}
