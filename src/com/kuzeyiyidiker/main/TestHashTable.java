package com.kuzeyiyidiker.main;

import com.kuzeyiyidiker.base.HashTable;
import com.kuzeyiyidiker.helpers.StopWordHelper;

public class TestHashTable {

	public static void main(String[] args) {
		StopWordHelper stopWordHelper = new StopWordHelper("C://Users//Efe//Desktop//stop_words_en.txt");
		HashTable ht = new HashTable(11);
		String sentence1 = "I am buying a new green car. My car sheila color is green(Yes it is). Because the green color is my favorite color.";
		String[] wordsOfSt1 = sentence1.split("[\\p{Punct}\\p{Blank}]+");
		for (int i = 0; i < wordsOfSt1.length; i++) {
			if(!stopWordHelper.isStopWord(wordsOfSt1[i]))
			ht.put(wordsOfSt1[i].toLowerCase(), "1.txt");
		}
		String sentence2 = "Ozan buying a new blue car. 123 sheila eyes are so cool. His car is awesome and its name Sheila.Ozan's wife will love this surprise. Border color of this decoration is blue.";
		String[] wordsOfSt2 = sentence2.split("[\\p{Punct}\\p{Blank}\\p{Digit}]+");
		for (int i = 0; i < wordsOfSt2.length; i++) {
			if(!stopWordHelper.isStopWord(wordsOfSt2[i]))
			ht.put(wordsOfSt2[i].toLowerCase(), "2.txt");
		}
		ht.printTable();
	}
}
