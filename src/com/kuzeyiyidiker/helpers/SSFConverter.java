package com.kuzeyiyidiker.helpers;

public class SSFConverter implements StringConverter {

	@Override
	public int convertToNumber(String key, int moduleVal) {
		int total = 0;
		for (int i = 0; i < key.length(); i++) {
			int asciValue = (int) key.charAt(i);
			// ASCII value of lower case letters starts from 97
			int alphabetIndex = asciValue - 96;
			total += alphabetIndex;
		}
		return total % moduleVal;
	}

}
