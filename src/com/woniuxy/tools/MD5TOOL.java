package com.woniuxy.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;

public class MD5TOOL {

	public static String getMD5String(String str) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		byte bs[] = md.digest(str.getBytes());
		Formatter formate = new Formatter();
		
		for (byte b : bs) {
			formate.format("%02x", b);
			
		}
		
		return formate.toString();
		
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		String str = MD5TOOL.getMD5String("123");
		
		System.out.println(str);
		
	}
	
	
}
