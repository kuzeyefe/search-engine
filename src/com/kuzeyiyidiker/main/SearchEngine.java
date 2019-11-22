package com.kuzeyiyidiker.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.kuzeyiyidiker.base.CollisionMethod;
import com.kuzeyiyidiker.base.CollisionMethodFactory;
import com.kuzeyiyidiker.base.HashEntry;
import com.kuzeyiyidiker.base.HashTable;
import com.kuzeyiyidiker.helpers.DelimiterHelper;
import com.kuzeyiyidiker.helpers.StopWordHelper;
import com.kuzeyiyidiker.helpers.StringConverter;
import com.kuzeyiyidiker.helpers.StringConverterFactory;

public class SearchEngine {

	public int loadFactor;
	public int capacity;
	public CollisionMethod collisionMethod;
	public StringConverter stringConverter;
	public HashTable ht;
	public long[] searchTimeList = new long[1000];
	
	public SearchEngine() {
		capacity = 11;
		loadFactor = 80;
		collisionMethod = CollisionMethodFactory.getColisionMethod("DH");
		stringConverter = StringConverterFactory.createStringConverter("PAF", capacity);
		initializeEnvironment();
	}
	
	public SearchEngine(int _capacity, int _loadFactor, String collisionMethodCode, String stringConvertMethodCode) {
		capacity = _capacity;
		loadFactor = _loadFactor;
		collisionMethod = CollisionMethodFactory.getColisionMethod(collisionMethodCode);
		stringConverter = StringConverterFactory.createStringConverter(stringConvertMethodCode, capacity);
		initializeEnvironment();
	}
	public void initializeEnvironment() {
		ht = new HashTable(capacity);
		ht.setLoadFactor(loadFactor);
		ht.setCollisionMethod(collisionMethod);
		ht.setStringConverter(stringConverter);
		long start = System.currentTimeMillis();
		loadFiles();
		long end = System.currentTimeMillis();
		long indexingTime = end-start;
		System.out.println("Indexing time :"+ indexingTime);
		System.out.println("Collision count :" + ht.getCollisionMethod().getCollisionCount());
	}
	
	public void loadFiles() {
		BufferedReader reader = null;
		StopWordHelper stopWordHelper = new StopWordHelper("C://Users//Efe//Desktop//stop_words_en.txt");
		File[] folders = new File("C://Users//Efe//Desktop//bbc//").listFiles();

		for (int k = 0; k < folders.length; k++) {
			File[] listOfFiles = folders[k].listFiles();
			for (File file : listOfFiles) {
				try {
					reader = new BufferedReader(new FileReader(file));
					String line = reader.readLine();
					while (line != null) {
						String[] words = line.split(DelimiterHelper.DELIMITERS);
						for (int i = 0; i < words.length; i++) {
							if (!words[i].isEmpty() && !stopWordHelper.isStopWord(words[i].toLowerCase())) {
								int hashCode = ht.put(words[i].toLowerCase(), file.getName());
								System.out.println("Word: " + words[i] + " HashIndex: "+hashCode);
							}
						}
						line = reader.readLine();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
	}
	
	public float search(String key) {
		long start = System.currentTimeMillis();
		HashEntry entry = ht.get(key);
		long end = System.currentTimeMillis();
		float sec = (end - start) / 1000F;
		if(entry != null) {
			System.out.println("Word " +entry);
			entry.printDocuments();
			System.out.println(key + " found in "+sec + " seconds ");
		}
		return sec;
	}
	
	public void showSearchTimeReport() {
		int counter = 0;
		BufferedReader reader = null;
		File keyFile = new File("C://Users//Efe//Desktop//1000.txt");
		try {
			reader = new BufferedReader(new FileReader(keyFile));
			String line = reader.readLine();
			long total = 0;
			while(line != null) {
				long start = System.currentTimeMillis();
				ht.get(line);
				long end = System.currentTimeMillis();
				total += (end-start);
				searchTimeList[counter] = end-start;
				counter++;
				line = reader.readLine();
			}
			findAvgSearchTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void findMinSearchTime() {
		
	}
	
	public void findMaxSearchTime() {
		
	}
	
	public void findAvgSearchTime() {
		long total = 0;
		long min = searchTimeList[0];
		long max = searchTimeList[0];
		for(int i = 0; i < searchTimeList.length; i++) {
			total += searchTimeList[i];
			if(searchTimeList[i] < min) {
				min = searchTimeList[i];
			}
			if(searchTimeList[i] > max) {
				max = searchTimeList[i];
			}
		}
		System.out.println("Min search time : "+ (min/1000F));
		System.out.println("Max search time : "+ (max/1000F));
		System.out.println("Average time : " + ((total/searchTimeList.length)/1000F));
	}
}
