package utils;

import java.util.Random;
import java.util.Date;

public class ActivationCodeGenerator{
	public static String getActivationCode(){
		Random random = new Random();
		
		long activationCode = random.nextLong();
		
		if(activationCode<0){
			activationCode *= -3;	
		}
		return activationCode+"_"+new Date().getTime();
	}
}