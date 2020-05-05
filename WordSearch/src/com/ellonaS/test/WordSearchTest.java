package com.ellonaS.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ellonaS.main.WordSearch;

import junit.framework.Assert;

public class WordSearchTest{
	
	WordSearch wordSearch;
	List <char[]> grid;
	int gridSize;
	
	@Before
	public void setup() {
		wordSearch = new WordSearch();
		gridSize = 15;
		grid = wordSearch.generateRandomLetterGrid(gridSize);
		
	}
	
	@Test
	public void gridSizeTest() {
		assertNotNull(grid);
		assertEquals (gridSize, grid.size());
		for (int i = 0; i < gridSize; i++) {
			assertEquals (gridSize, grid.get(i).length);
		}
		
	}
	@Test
	public void gridConsistsOfLettersTest() {
		for (int i = 0; i < gridSize; i++) {
			char[] letters = grid.get(i);
			
			for (char c :letters) {
				assertTrue(Character.isLetter(c));
			}
		}
		
	}




}
