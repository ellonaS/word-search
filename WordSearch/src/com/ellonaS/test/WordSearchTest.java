package com.ellonaS.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ellonaS.main.LetterGrid;
import com.ellonaS.main.WordSearch;

import junit.framework.Assert;

public class WordSearchTest {

	private WordSearch wordSearch;
	private LetterGrid letterGrid;
	private List<char[]> grid;
	private int gridSize;

	@Before
	public void setup() {
		letterGrid = new LetterGrid();
		wordSearch = new WordSearch();
		gridSize = 15;
		grid = letterGrid.generateRandomLetterGrid(gridSize);

	}

	@Test
	public void gridSizeTest() {
		assertNotNull(grid);
		assertEquals(gridSize, grid.size());
		for (int i = 0; i < gridSize; i++) {
			assertEquals(gridSize, grid.get(i).length);
		}

	}

	@Test
	public void gridConsistsOfLettersTest() {
		for (int i = 0; i < gridSize; i++) {
			char[] letters = grid.get(i);

			for (char c : letters) {
				assertTrue(Character.isLetter(c));
			}
		}

	}

	@Test
	public void searchTheGridForwardTest() {
		List<char[]> grid = new ArrayList<char[]>();
		char[] letters1 = { 'B', 'O', 'O', 'K', 'S', 'S', 'B', 'O', 'O', 'K'};
		grid.add(letters1);
		char[] letters2 = {'S', 'B', 'O', 'O', 'K', 'S', 'B', 'O', 'O', 'K'};
		grid.add(letters2);
		char[] letters3 = {'S', 'A', 'B', 'O', 'K', 'S', 'A', 'B', 'O', 'K'};
		grid.add(letters3);
		assertEquals(4, wordSearch.searchTheGridForward(grid, "BOOK"));
	}
	
	@Test
	public void searchTheGridBackwardTest() {
		List<char[]> grid = new ArrayList<char[]>();
		char[] letters1 = { 'K', 'O', 'O', 'B', 'S', 'S', 'K', 'O', 'O', 'B'};
		grid.add(letters1);
		char[] letters2 = {'S', 'K', 'O', 'O', 'B', 'S', 'B', 'O', 'O', 'B'};
		grid.add(letters2);
		char[] letters3 = {'S', 'A', 'B', 'O', 'K', 'O', 'O', 'B', 'O', 'K'};
		grid.add(letters3);
		assertEquals(4, wordSearch.searchTheGridBackward(grid, "BOOK"));
	}
	
	@Test
	public void searchTheGridDiagonallyTest() {
		List<char[]> grid = new ArrayList<char[]>();
		char[] letters1 = { 'K', 'B', 'O', 'K'};
		grid.add(letters1);
		char[] letters2 = { 'S', 'O', 'O', 'O'};
		grid.add(letters2);
		char[] letters3 = { 'S', 'O', 'O', 'O'};
		grid.add(letters3);
		char[] letters4 = { 'B', 'A', 'B', 'B'};
		grid.add(letters4);
		assertEquals(2, wordSearch.searchTheGridDiagonally(grid, "BOOK"));
	}

}
