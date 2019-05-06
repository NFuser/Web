package com.twly.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 
* @ClassName: MD5Utils  
* @Description: MD5���ܸ�����
* @date 2017��12��12�� ����4:18:28    
* Company www.twlyhome.com
*
 */
public class MD5Utils {
	/**
	 * 
	* @Title: md5  
	* @Description: ʵ��md5����  
	* @param plainText
	* @return
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(
					plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("û��md5����㷨��");
		}
		String md5code = new BigInteger(1, secretBytes).toString(16);// 16��������
		// �����������δ��32λ����Ҫǰ�油0
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}

	public static void main(String[] args) {
		System.out.println(md5("123"));
	}

}
