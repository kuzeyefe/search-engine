package com.kuzeyiyidiker.base;


public class HashEntry {

	String collisionWord;
	DocumentLinkedList collisionDocuments;
	
	public HashEntry(String word) {
		collisionWord = word;
		collisionDocuments = new DocumentLinkedList();
	}
	
	public void printDocuments() {
		collisionDocuments.printDocuments();
	}
	
	@Override
	public String toString() {
		return collisionWord;
	}
}