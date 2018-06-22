package com.vanggame.admin.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesUtil {

	private final static String algorithm = "AES/CFB/NoPadding";

	private final static String key_algorithm = "AES";
	
	public static byte[] decrypt(byte[] data, byte[] key, byte[] iv)
			throws Exception {
		return decrypt(data, new SecretKeySpec(key, key_algorithm),
				new IvParameterSpec(iv));
	}
	
	public static byte[] decrypt(byte[] data, SecretKeySpec key,
			IvParameterSpec iv) throws Exception {
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		return cipher.doFinal(data);
	}
}
