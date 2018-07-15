package org.tq.util;

import java.util.Random;

public class AppLibrary {
	
	public static String randomString()
	{ 
		Random r1 = new Random();
		int result =  10000 + r1.nextInt(99);  
		char u  = (char) (65+r1.nextInt(26));
		char l = (char)(97 + r1.nextInt(26));
		String randomValue=u+""+l+""+result;
		return randomValue;
	}

}
