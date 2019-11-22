package com.kuzeyiyidiker.base;


public class DocumentNode {
	String fileName;
	int count =1;
	
	DocumentNode prev;
	DocumentNode next;
	
	public DocumentNode(String _fileName, int _count) {
		fileName = _fileName;
		count = _count;
	}
	
	@Override
	public String toString() {
		return fileName;
	}
}
