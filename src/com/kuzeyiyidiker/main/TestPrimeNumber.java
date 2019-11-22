package com.kuzeyiyidiker.main;

import com.kuzeyiyidiker.helpers.PrimeNumberHelper;

public class TestPrimeNumber {

	public static void main(String[] args) {
		System.out.println(PrimeNumberHelper.getClosestSmallPrimeNumber(5114));
		System.out.println(PrimeNumberHelper.getClosestBiggerNumber(33));
		System.out.println((127 + (3*64)) % 128);
//		newHashCode = (firstHashCode + (j * secondHashCode)) % (int)table.length;
	}
}
