package com.kuzeyiyidiker.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;

public class StopWordHelper {
	
	HashSet<String> stopWords = new HashSet<String>();
	
	public StopWordHelper(String fileName) {
		loadStopWordsFromFile(fileName);
	}
	
	private void loadStopWordsFromFile(String fileName) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			while (line != null) {
				stopWords.add(line.toLowerCase());
				line = reader.readLine();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public boolean isStopWord(String word) {
		return stopWords.contains(word);
	}
}
