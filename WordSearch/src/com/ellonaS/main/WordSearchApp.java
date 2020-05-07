package com.ellonaS.main;

import java.util.List;

public class WordSearchApp {

	private LetterGrid letterGrid = new LetterGrid();
	private Dictionary dictionary;
	private Trie trie;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearchApp app = new WordSearchApp();
		app.run();

	}

	public void displayGrid() {
		List<char[]> grid = letterGrid.generateRandomLetterGrid(15);
		List <String> lines = letterGrid.getAllDiagonalLines(grid);
		for (int i = 0; i < grid.size(); i++) {
			String str = new String(grid.get(i));
			System.out.println(str);
		}
		System.out.println("-----------");
		for (int i = 0; i < lines.size(); i++) {
			
			System.out.println(lines.get(i));
		}
		
	}

	private void run() {
		displayGrid();
		dictionary = new Dictionary();
		List<String> words = dictionary.loadWords("words.txt");
		System.out.println(words.size() + " words");
		trie = new Trie();
		// construct trie

		for (int i = 0; i < words.size(); i++) {
			trie.insert(words.get(i));
		}

	}

}
