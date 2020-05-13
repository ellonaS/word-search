package com.ellonaS.main;

import java.util.List;

public class WordSearchApp {

	private LetterGrid letterGrid = new LetterGrid();
	private Dictionary dictionary;
	private Trie trie = new Trie();
	private List<char[]> grid;
	
	public static void main(String[] args) {
		WordSearchApp app = new WordSearchApp();
		app.run();

	}

	public void displayGrid() {
		grid = letterGrid.generateRandomLetterGrid(1000);
	
		for (int i = 0; i < grid.size(); i++) {
			String str = new String(grid.get(i));
			System.out.println(str);
		}
		
	}

	private void run() {
		//generate grid
		displayGrid();
		dictionary = new Dictionary();
		List<String> words = dictionary.loadWords("words.txt");
		
		// construct trie
		for (int i = 0; i < words.size(); i++) {
			trie.insert(words.get(i));
		}
		
		//generate all possible lines from the grid
		List <String> lines = letterGrid.getAllLinesOfGrid(grid);
		System.out.println("-----------");
		for (int i = 0; i < lines.size(); i++) {
			System.out.println(lines.get(i));
		}
		searchWords(lines);
		

	}
	public void searchWords(List <String> lines) {
		
		System.out.println("------------------------");
		System.out.print("WE FOUND: ");
		for (String line : lines) {
			for(int i = 0; i < line.length(); i++) {
				if(trie.search(line.substring(i)) == true) {
					System.out.print(line.substring(i) + ", ");
				}
			}
		}
		
	}

}
