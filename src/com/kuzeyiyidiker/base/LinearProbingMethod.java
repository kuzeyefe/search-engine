package com.kuzeyiyidiker.base;

public class LinearProbingMethod extends CollisionMethod {

	
	@Override
	public int createNewHashCode(int firstHashCode, String key, HashEntry[] table, boolean increaseCollisionCount) {
		int newHashCode = (firstHashCode + 1) % table.length;
		int counter = 2;
		while (table[newHashCode] != null && !table[newHashCode].collisionWord.equals(key)) {
			newHashCode = (firstHashCode + counter) % table.length;
			counter++;
			if(increaseCollisionCount)
				increaseCollisionCount();
		}
		return newHashCode;
	}

}
