package com.kuzeyiyidiker.helpers;

public class StringConverterFactory {

	public static StringConverter stringConverter = null;
	
	public static StringConverter createStringConverter(String code, int moduleVal) {
		if(code.equalsIgnoreCase("ssf"))
			return new SSFConverter();
		else 
			return new PAFConverter();
	}
	public static StringConverter getStringConverter() {
		if(stringConverter == null)
			return createStringConverter("ssf", 5);
		
		return stringConverter;
	}
}
