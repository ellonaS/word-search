package com.ellonaS.test;

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
		List <char[]> grid = wordSearch.generateRandomLetterGrid(15);
		assertNotNull(grid);
	}




}
