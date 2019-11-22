package com.kuzeyiyidiker.base;

import com.kuzeyiyidiker.helpers.PrimeNumberHelper;
import com.kuzeyiyidiker.helpers.StringConverter;

public class HashTable {

	private HashEntry[] table;
	private int loadFactor = 80;
	private int keyCounter = 1;
	private CollisionMethod collisionMethod;
	private StringConverter stringConverter;

	public HashTable(int _capacity) {
		table = new HashEntry[_capacity];
	}

	public int put(String key, String fileName) {
		if ((table.length * loadFactor / 100) > keyCounter) {
			int hashCode = getHashCode(key, table.length);
			HashEntry entry = new HashEntry(key);
			// If there is no collision with this key then create a document node and add
			// this entry
			if (table[hashCode] == null) {
				DocumentNode linkedListNode = new DocumentNode(fileName, 1);
				entry.collisionDocuments.add(linkedListNode);
				table[hashCode] = entry;
				keyCounter++;
				return hashCode;
			} else {
				// Check the collision word in this index. If they are same then increase the
				// count of related document.
				if (table[hashCode].collisionWord.equals(key)) {
					table[hashCode].collisionDocuments.updateWordCount(fileName);
					return hashCode;
				} else {
					// Find new hashcode for this key
					int newHashCode = collisionMethod.createNewHashCode(hashCode, key, table, true);
					if (table[newHashCode] != null && table[newHashCode].collisionWord.equals(key)) {
						table[newHashCode].collisionDocuments.updateWordCount(fileName);
						return newHashCode;
					} else {
						DocumentNode linkedListNode = new DocumentNode(fileName, 1);
						entry.collisionDocuments.add(linkedListNode);
						table[newHashCode] = entry;
						keyCounter++;
						return newHashCode;
					}

				}
			}
		} else {
			resize();
			return put(key, fileName);
		}
	}

	public int getHashCode(String key, int tableSize) {
//		System.out.println("Key: " +key +" || KeyNumb : "+ stringParser.convertToNumber(key, table.length) + " || Table : "+tableSize);
		return stringConverter.convertToNumber(key, table.length);
	}

	public void resize() {

		int newTableSize = PrimeNumberHelper.getClosestBiggerNumber(table.length * 2);
		HashEntry[] tempTable = table;
		// System.out.println("TABLE IS SHOULD BE RESIZED FROM ! :" + table.length + "
		// TO " + newTableSize
		// + " ITEM Count :" + keyCounter);
		table = new HashEntry[newTableSize];

		for (int i = 0; i < tempTable.length; i++) {
			if (tempTable[i] != null) {
				int hashCode = getHashCode(tempTable[i].collisionWord, newTableSize);
				if (table[hashCode] == null) {
					table[hashCode] = tempTable[i];
				} else {
					int newHashCode = collisionMethod.createNewHashCode(hashCode, tempTable[i].collisionWord, table,
							true);
					table[newHashCode] = tempTable[i];
				}
			}
		}
	}

	public HashEntry get(String key) {
		int keyIndex =findIndex(key);
		return keyIndex > -1 ? table[keyIndex] : null;

	}

	public int findIndex(String key) {
		int hashCode = getHashCode(key, table.length);
		if (table[hashCode] != null) {

			if (table[hashCode].collisionWord.equals(key)) {
				return hashCode;
			} else {
				return collisionMethod.createNewHashCode(hashCode, key, table, false);
			}
		} else {
			System.out.println(key + " not found in directory.");
			return -1;
		}
	}

	public boolean remove(String key) {
		int keyIndex = findIndex(key);
		if(keyIndex > -1) {
			boolean result = table[keyIndex] != null ? true : false;
			table[keyIndex] = null;
			return result;
		} else {
			return false;
		}
	}

	public void printTable() {
		for (int i = 0; i < table.length; i++) {
			HashEntry tableItem = table[i];
			if (tableItem != null) {
				System.out.println("WORD : " + tableItem.collisionWord + " Index : " + i + " File List:");
				if (tableItem.collisionDocuments.head != null) {
					DocumentNode nextNode = tableItem.collisionDocuments.head;
					while (nextNode != null) {
						System.out.println("File Name :" + nextNode.fileName + " Count: " + nextNode.count);
						nextNode = nextNode.next;
					}
				}
			}

		}
	}

	public HashEntry[] getTable() {
		return table;
	}

	public void setTable(HashEntry[] table) {
		this.table = table;
	}

	public int getLoadFactor() {
		return loadFactor;
	}

	public void setLoadFactor(int loadFactor) {
		this.loadFactor = loadFactor;
	}

	public int getKeyCounter() {
		return keyCounter;
	}

	public void setKeyCounter(int keyCounter) {
		this.keyCounter = keyCounter;
	}

	public CollisionMethod getCollisionMethod() {
		return collisionMethod;
	}

	public void setCollisionMethod(CollisionMethod collisionMethod) {
		this.collisionMethod = collisionMethod;
	}

	public StringConverter getStringConverter() {
		return stringConverter;
	}

	public void setStringConverter(StringConverter stringConverter) {
		this.stringConverter = stringConverter;
	}

}
