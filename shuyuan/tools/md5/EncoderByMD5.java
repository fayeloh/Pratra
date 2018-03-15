package com.fayeloh.tools.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class EncoderByMD5 {    
	/**
	 * ���������������Կɶ���ʮ�����Ʒ���
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String encoderBy(String password) throws NoSuchAlgorithmException{
		MessageDigest md5 = MessageDigest.getInstance("md5");
		byte[] results = md5.digest(password.getBytes());
		return byteArrayToString(results);
	}
	/**
	 * ��byte����ת��String
	 * @param results
	 * @return
	 */
	private static String byteArrayToString(byte[] results) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<results.length;i++){
			//��ÿһλbyteת����String
			sb.append(byteToString(results[i]));
		}
		return sb.toString();
	}
	/**
	 * ��byteת���String
	 * ��ʮ�����Ƶķ���
	 * @param 
	 * @return
	 */
	private static String[] hex = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	private static String byteToString(byte b) {
		int n = b;
		if(n<0){
			n=n+256;
		}
		int b1 = n/16;
		int b2 = n%16;
		return hex[b1]+hex[b2];
	}
}
