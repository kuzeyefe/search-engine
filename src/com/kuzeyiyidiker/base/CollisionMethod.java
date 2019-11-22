package com.kuzeyiyidiker.base;

public abstract class CollisionMethod {

	private long collisionCount;
	
	public abstract int createNewHashCode(int firstHashCode, String key, HashEntry[] table, boolean increaseCollisionCount);
	
	public long getCollisionCount() {
		return collisionCount;
	}
	
	public void setCollisionCount(long collisionCount) {
		this.collisionCount = collisionCount;
	}
	public void increaseCollisionCount() {
		collisionCount++;
	}
}
