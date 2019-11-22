package com.kuzeyiyidiker.helpers;

public class PAFConverter implements StringConverter {

	@Override
	public int convertToNumber(String key, int moduleVal) {

		int[] polynomCoefficients = new int[key.length()];
		int primeNumber = 33;
		for (int i = 0; i < key.length(); i++) {
			int asciValue = (int) key.charAt(i);
			// ASCII value of lower case letters starts from 97
			int alphabetIndex = asciValue - 96;
			polynomCoefficients[i] = alphabetIndex;
		}
		return horner(polynomCoefficients, key.length(), primeNumber, moduleVal);
	}

	public int horner(int poly[], int n, int x, int tableSize) {
		int result = poly[0];
		for (int i = 1; i < n; i++)
			result = (result * x + poly[i]) % tableSize;

		return result;
	}

}
