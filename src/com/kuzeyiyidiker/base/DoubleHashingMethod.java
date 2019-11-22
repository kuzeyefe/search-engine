package com.kuzeyiyidiker.base;

import com.kuzeyiyidiker.helpers.PrimeNumberHelper;
import com.kuzeyiyidiker.helpers.StringConverterFactory;

public class DoubleHashingMethod extends CollisionMethod {

	@Override
	public int createNewHashCode(int firstHashCode, String key, HashEntry[] table, boolean increaseCollisionCount) {
		int q = PrimeNumberHelper.getClosestSmallPrimeNumber(table.length);
		int secondHashCode = q - (StringConverterFactory.getStringConverter().convertToNumber(key,table.length) % q);
		int newHashCode = secondHashCode;
		int j = 1;
		while(table[newHashCode] != null && !table[newHashCode].collisionWord.equals(key)) {
			newHashCode = (firstHashCode + (j * secondHashCode)) % table.length;
			j++;
			if(j > 10) {
				newHashCode = (newHashCode+1)%table.length ;
			}
			if(increaseCollisionCount)
				increaseCollisionCount();
		}
		return newHashCode;
	}

}
