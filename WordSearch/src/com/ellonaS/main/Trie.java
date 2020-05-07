package com.ellonaS.main;

public class Trie {
	//This code is from
	//https://www.geeksforgeeks.org/trie-insert-and-search/
	//partially changed by me

	// Alphabet size (# of symbols)
	static final int ALPHABET_SIZE = 26;

	// trie node
	private class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];

		// isEndOfWord is true if the node represents
		// end of a word
		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				children[i] = null;
		}
	};

	// create a TrieNode that points to the root of a search tree
	TrieNode root = new TrieNode();

	// If not present, inserts key into trie
	// If the key is prefix of trie node,
	// just marks "leaf node" - end of word
	public void insert(String word) {
		int level;
		int length = word.length();
		int index;
		
		//
		TrieNode currentLevel = root;

		for (level = 0; level < length; level++)

		{
			//find the current letter and find its index in alphabet
			//
			char currentChar = word.charAt(level);
			index = 0;
			for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
				index++;
				if (currentChar == alphabet) {
					//subtract 1 to get the right index
					index = index - 1;
					break;
				}
			}
			if (currentLevel.children[index] == null)
				currentLevel.children[index] = new TrieNode();

			currentLevel = currentLevel.children[index];
		}

		// mark last node as leaf
		currentLevel.isEndOfWord = true;
	}

	// Returns true if key presents in trie, else false
	public boolean search(String word) {
		int level;
		int length = word.length();
		int index;
		TrieNode currentLevel = root;

		for (level = 0; level < length; level++) {
			
			
			char currentChar = word.charAt(level);
			index = 0;
			for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
				index++;
				if (currentChar == alphabet) {
					//subtract 1 to get to the right index
					index = index - 1;
					break;
				}
			}

			if (currentLevel.children[index] == null)
				return false;

			currentLevel = currentLevel.children[index];
		}

		return (currentLevel != null && currentLevel.isEndOfWord);
	}

	// Driver
	public void main(String args[]) {
		// Input keys (use only 'a' through 'z' and lower case)
		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		String output[] = { "Not present in trie", "Present in trie" };

		root = new TrieNode();

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++)
			insert(keys[i]);

		// Search for different keys
		if (search("the") == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

		if (search("these") == true)
			System.out.println("these --- " + output[1]);
		else
			System.out.println("these --- " + output[0]);

		if (search("their") == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

		if (search("thaw") == true)
			System.out.println("thaw --- " + output[1]);
		else
			System.out.println("thaw --- " + output[0]);

	}
}