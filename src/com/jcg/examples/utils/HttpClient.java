package com.jcg.examples.utils;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
	
	private final String USER_AGENT = "Mozilla/5.0";
	
	public HttpClient() {
		super();
	}

	
	// HTTP GET request
	public void sendGet(String otp, String phoneNumber) throws Exception {

		//String to connect to 12VoiP
		String url = "https://www.12voip.com/myaccount/sendsms.php?username=&password=&from=&to=";
		url+=phoneNumber;
		url+="&text=Your OTP: ";
		url+=otp;
		
		System.out.println(url);
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("HTTP response code: "+responseCode);
	}
}