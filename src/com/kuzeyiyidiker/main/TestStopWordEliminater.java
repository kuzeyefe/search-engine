package com.kuzeyiyidiker.main;

import com.kuzeyiyidiker.helpers.StopWordHelper;

public class TestStopWordEliminater {

	public static void main(String[] args) {
		StopWordHelper sh = new StopWordHelper("C://Users//Efe//Desktop//stop_words_en.txt");
		System.out.println(sh.isStopWord("are".toLowerCase()));
	}
}
