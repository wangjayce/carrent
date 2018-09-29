package com.sxt.sys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class RandomString {
	
	private static SimpleDateFormat  format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
	private static SimpleDateFormat  format2 = new SimpleDateFormat("yyyyMMdd_hhmmss_SSS");
	private static SimpleDateFormat  format1 = new SimpleDateFormat("yyyy-MM-dd");
	private static Random random = new Random();
	
	public static String getNewFileNameUseTime(String oldName){
		String fileType = oldName.substring(oldName.lastIndexOf("."), oldName.length());
		String timeStr = format.format(new Date());
		Integer  randomStr = random.nextInt(9000)+1000;
		
		return timeStr+randomStr+fileType;
	}
	
	public static String getDirName(){
		String dirName = format1.format(new Date());
		return dirName;
	}
	
	
	public static String getNewFileNameUseUUID(String oldName){
		String fileType = oldName.substring(oldName.lastIndexOf("."), oldName.length());
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid+fileType;
	}
	public static String getNewFileNameUseUUID(){
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}
	
	
	
	public static String getRandomString(String prefix){
		String order = format2.format(new Date());
		String number ="_"+(random.nextInt(90000)+10000);
		return prefix+order+number;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<8;i++) {
			
			System.out.println(getNewFileNameUseUUID(".q"));
		}
	}
	
	
}
