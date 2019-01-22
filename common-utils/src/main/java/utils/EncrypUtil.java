package utils;

import java.nio.charset.Charset;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import cn.hutool.core.lang.Validator;
import cn.hutool.crypto.SecureUtil;

/**
 * 加密解密工具类
 * 2018-03-06
 * @author sh
 *
 */
public class EncrypUtil {

	/**
	 * MD5加密
	 * 
	 * @param data
	 * @return
	 */
	public static String MD5(String data) {
		if (null == data || "".equals(data)) {
			return "";
		}
		return SecureUtil.md5(data);
	}

	/**
	 * SHA1加密
	 * 
	 * @param data
	 * @return
	 */
	public static String SHA1(String data) {
		if (null == data || "".equals(data)) {
			return "";
		}
		return SecureUtil.sha1(data);
	}

	/**
	 * 可逆加密
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String reverEncrypt(String str) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(rawKeyData);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		javax.crypto.SecretKey key = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(1, key, sr);
		byte data[] = str.getBytes();
		byte encryptedData[] = cipher.doFinal(data);
		return byte2hex(encryptedData);
	}

	/**
	 * 可逆解密
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String reverDecrypt(String str) throws Exception {
		SecureRandom sr = new SecureRandom();
		DESKeySpec dks = new DESKeySpec(rawKeyData);
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		javax.crypto.SecretKey key = keyFactory.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(2, key, sr);
		byte encryptedData[] = hex2byte(str.getBytes());
		byte decryptedData[] = cipher.doFinal(encryptedData);
		return new String(decryptedData);
	}

	public static String byte2hex(byte b[]) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0xff);
			if (stmp.length() == 1)
				hs = (new StringBuilder(String.valueOf(hs))).append("0").append(stmp).toString();
			else
				hs = (new StringBuilder(String.valueOf(hs))).append(stmp).toString();
		}

		return hs.toUpperCase();
	}

	public static byte[] hex2byte(byte b[]) {
		if (b.length % 2 != 0)
			throw new IllegalArgumentException("长度不是偶数");
		byte b2[] = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}

		return b2;
	}

	private static byte rawKeyData[] = "42811111asdada12".getBytes(Charset.forName("utf-8"));

	public static void main(String[] args) throws Exception {
		String md5 = EncrypUtil.MD5("123456");
		System.out.println(md5);
		String sha1 = EncrypUtil.SHA1("qwe123");
		System.out.println(sha1);
		String str = reverEncrypt("123456qwe");
		System.out.println(str);
		System.out.println(reverDecrypt(str));
		Validator.isEmail("");
	}
}
