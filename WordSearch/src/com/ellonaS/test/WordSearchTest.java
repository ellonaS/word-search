package com.ellonaS.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ellonaS.main.WordSearch;

public class WordSearchTest{
	
	WordSearch wordSearch;
	
	@Before
	public void setup() {
		wordSearch = new WordSearch();
		
	}
	
	@Test
	public void generateRandomLetterGridTest() {
		int gridSize = 15;
		List <char[]> grid = wordSearch.generateRandomLetterGrid(gridSize);
		assertNotNull(grid);
		assertEquals (gridSize, grid.size());
		for (int i = 0; i < gridSize; i++) {
			assertEquals (gridSize, grid.get(i).length);
		}
		
	}




}
