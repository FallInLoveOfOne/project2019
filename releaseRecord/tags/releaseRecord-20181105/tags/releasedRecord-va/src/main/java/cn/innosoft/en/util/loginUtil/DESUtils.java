package cn.innosoft.en.util.loginUtil;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;

public class DESUtils {

	public DESUtils() {
	}

	public static void main(String args[]) throws NoSuchAlgorithmException,
			InvalidKeyException, NoSuchPaddingException,
			InvalidKeySpecException, IllegalBlockSizeException,
			BadPaddingException, UnsupportedEncodingException {
		String pwd = DESUtils.encrypt("123456zms");
		System.out.println(pwd);
	}

	/**
	 * 加密
	 * @param str
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeySpecException
	 */
	public static String encrypt(String str) throws InvalidKeyException,
			NoSuchAlgorithmException, IllegalBlockSizeException,
			BadPaddingException, NoSuchPaddingException,
			InvalidKeySpecException {
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
	 * 解密
	 * @param str
	 * @return
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeySpecException
	 */
	public static String decrypt(String str) throws IllegalBlockSizeException,
			BadPaddingException, InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeySpecException {
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
				hs = (new StringBuilder(String.valueOf(hs))).append("0")
						.append(stmp).toString();
			else
				hs = (new StringBuilder(String.valueOf(hs))).append(stmp)
						.toString();
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

	private static byte rawKeyData[] = "42811111asdada12".getBytes(Charset
			.forName("utf-8"));

}
