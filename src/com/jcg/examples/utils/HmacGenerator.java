package com.jcg.examples.utils;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

public class HmacGenerator {

	private String data;
	
	private String key;
	
	public HmacGenerator(String data, String key) {
		super();
		this.data = data;
		this.key = key;
	}
	
	public static String generateHmacSHA256Signature(String data, String key)   throws GeneralSecurityException {
	    byte[] hmacData = null;

	    try {
	        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
	        Mac mac = Mac.getInstance("HmacSHA256");
	        mac.init(secretKey);
	        hmacData = mac.doFinal(data.getBytes("UTF-8"));
	        return new BASE64Encoder().encode(hmacData);
	    } catch (UnsupportedEncodingException e) {
	        // TODO: handle exception
	        throw new GeneralSecurityException(e);
	    }
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
