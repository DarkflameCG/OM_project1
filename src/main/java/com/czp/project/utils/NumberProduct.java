package com.czp.project.utils;
/**
 * 编号生成代码
 * @author mastercgx
 *
 */
public class NumberProduct {
	public static String getNumber() {
		String result = "";
		String dic1 = "QWERTYUIOPLKJHGFDSAZXCVBNM";
		char[] cv1 = dic1.toCharArray();
		char[] v1 = new char[2];
		for(int i = 0;i<v1.length;i++) {
			int index = (int)(Math.random()*dic1.length());
			v1[i] = cv1[index];
		}
		result = result+new String(v1);
		String dic2 = "1234567890";
		char[] cv2 = dic2.toCharArray();
		char[] v2 = new char[3];
		for(int i = 0;i<v2.length;i++) {
			int index = (int)(Math.random()*dic2.length());
			v2[i] = cv2[index];
		}
		result = result+new String(v2);
		String dic3 = String.valueOf(System.currentTimeMillis());	
		String v3 = dic3.substring(dic3.length()-3);
		
		result = result+v3;
		return result;
	}
}
