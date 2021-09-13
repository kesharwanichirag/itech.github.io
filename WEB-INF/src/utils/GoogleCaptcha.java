package utils;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.DataOutputStream;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonObject;

public class GoogleCaptcha{
	public static boolean verifyCaptcha(String captchaResponse)throws IOException{
		String captcha = "https://www.google.com/recaptcha/api/siteverify";
		String parameter = "secret=6LdxBaMaAAAAACc14hz_AnfBC5FdX3_pZn_3jJZo"+"&response="+captchaResponse;

		URL url = new URL(captcha+"?"+parameter);

		HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setDoOutput(true);

		DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
		dataOutputStream.flush();
		dataOutputStream.close();

		InputStream inputStream;

		int statusCode = httpURLConnection.getResponseCode();
		
		if(statusCode!=HttpURLConnection.HTTP_OK){
			inputStream = httpURLConnection.getErrorStream();
		}else{
			inputStream = httpURLConnection.getInputStream();
		}
		
		JsonReader jsonReader = Json.createReader(inputStream);
		JsonObject jsonObject = jsonReader.readObject();

		boolean flag = jsonObject.getBoolean("success");

		return flag;
	}
}