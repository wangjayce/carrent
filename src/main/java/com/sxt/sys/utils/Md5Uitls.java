package com.sxt.sys.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
	
/**
 * 加密工具
 * @author LJH
 *
 */
public class Md5Uitls {

	/**
	 * 加密密码
	 * @param pwd 明文密码
	 * @param salt 盐
	 * @param hashIterations 散列次数
	 */
	public static String encodePwdUseMd5(String pwd,String salt,int hashIterations) {
		return new Md5Hash(pwd, salt, hashIterations).toString();
	}
	
	
	public static void main(String[] args) {
		String md5 = encodePwdUseMd5("123456","05e3995c77daac778159aa46376985f1",2);
		System.out.println(md5);
		
	}
}
