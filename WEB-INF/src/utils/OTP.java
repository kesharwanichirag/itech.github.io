package utils;

import java.util.Random;

public class OTP{
	public static String createOTP(){
		StringBuffer sbw = new StringBuffer();

		Random random = new Random();
		
		for(int i=1; i<=5 ; i++){
			sbw.append(random.nextInt(10));	
		}

		return sbw.toString();		
	}
}