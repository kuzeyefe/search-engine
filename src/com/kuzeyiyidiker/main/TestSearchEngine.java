package com.kuzeyiyidiker.main;

import java.util.Scanner;

public class TestSearchEngine {

	public static void main(String[] args) {
		System.out.println("Loading please wait...");
		SearchEngine searchEngine = new SearchEngine(128,80, "DH", "PAF");
		Scanner sc = new Scanner(System.in);
		System.out.print(">Search : ");
		String searchKey = sc.nextLine();
		//searchEngine.search(searchKey);
		searchEngine.showSearchTimeReport();
	}
}
