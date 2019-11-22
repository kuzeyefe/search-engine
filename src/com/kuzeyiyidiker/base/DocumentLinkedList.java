package com.kuzeyiyidiker.base;


public class DocumentLinkedList {
	DocumentNode head;
	private int count = 0;
	
	public DocumentNode updateWordCount(String fileName) {
		if(head != null) {
			DocumentNode node = head;
			while(node.next != null && !node.fileName.equals(fileName)) {
				node = node.next;
			}
			//Check if this node variable our last node then check file name
			if(node.fileName.equals(fileName)) {
				node.count++;
			} else {
				//If last node does not match then add this file as a new node
				DocumentNode newNode = new DocumentNode(fileName, 1);
				node.next = newNode;
				newNode.prev = node;
				count++;
			}
			return node;
		} 
		return null;
	}
	
	public void add(DocumentNode newNode) {
		if(head != null) {
			/*Find the last node */
			DocumentNode nextNode = head;
			while(nextNode.next != null) {
				nextNode = nextNode.next;
			}
			nextNode.next = newNode;
			newNode.prev = nextNode;
			
		} else {
			head = newNode;
		}
		count++;
	}
	
	public int size() {
		return count;
	}
	public void printDocuments() {
		if (head != null) {
			DocumentNode nextNode = head;
			System.out.println(size() + " documents found");
			while (nextNode != null) {
				System.out.println(nextNode.count + "-"+ nextNode.fileName);
				nextNode = nextNode.next;
			}
		}
	}
}
