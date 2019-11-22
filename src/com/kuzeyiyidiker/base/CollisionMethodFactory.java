package com.kuzeyiyidiker.base;

public class CollisionMethodFactory {

		public static CollisionMethod getColisionMethod(String code) {
			if(code.equalsIgnoreCase("lp")) {
				return new LinearProbingMethod();
			} else {
				return new DoubleHashingMethod();
			}
		}
}
