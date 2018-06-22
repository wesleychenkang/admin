package com.vanggame.admin.util;

import java.security.MessageDigest;
import java.util.zip.CRC32;

import javax.swing.plaf.synth.SynthSeparatorUI;



public class CommonMethod {

	public static boolean isBlank(String str){
		if(str==null || str.trim().equals(CommonConst.STRING_BLANK)){
			return true;
		}
		return false;
	}
	
	public static String createPassword(String passwrod){
		return stringToMd5(passwrod + CommonConst.STRING_KEY);
	}
	
	public static String stringToMd5(String srcString) {
		String dstString = null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(CommonConst.STRING_MD5);
			byte[] b = messageDigest.digest(srcString.getBytes(CommonConst.STRING_UTF8));

			StringBuffer tmpSb = new StringBuffer();
			for (byte aB : b) {
				tmpSb.append(CommonConst.HEX_CHARS.charAt((aB >> 4) & 0x0F));
				tmpSb.append(CommonConst.HEX_CHARS.charAt(aB & 0x0F));
			}
			dstString = tmpSb.toString();

		} catch (Exception e) {
			e.printStackTrace();
			dstString = null;
		}
		return dstString;
	}
	
	public static boolean isNullString(String str){
		return (str==null || str.length()==0);
	}
	
	public static int checkUser(String userId,byte[] key, byte[] iv){
//		if((System.currentTimeMillis() / 1000) - getServerTime(userId,key,iv) > CommonConst.ACESS_TIMEOUT)
//			return -1;
		return decodeUser(userId,key,iv);
		
	}
	
	private static int getServerTime(String userId,byte[] key, byte[] iv){
		byte[] b;
		byte[] a = Base64.decode(userId);
		try {
			b = AesUtil.decrypt(a, key, iv);
			return BytesUtil.getInt(b, 4);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	
	private static int decodeUser(String v,byte[] key, byte[] iv) {
		
		byte[] b;
		try {
			byte[] a = Base64.decode(v);
			b = AesUtil.decrypt(a, key, iv);
			int userid = BytesUtil.getInt(b, 0);
			long crc = BytesUtil.getLong(b, 8);

			CRC32 crc32 = new CRC32();
			crc32.reset();
			crc32.update(b,0,8);

			if( crc==crc32.getValue() ) {
				return userid;
			}
			else
				return 0;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static String mergeString(Object ...args){
		StringBuilder sb=new StringBuilder();
		for(Object arg:args){
			sb.append(arg);
		}
		return sb.toString();
	}
	
	public static String createKey(String prefix,long time){
		return prefix+CommonConst.STRING_SLANT+time+CommonConst.STRING_TYPE;
	}
}
