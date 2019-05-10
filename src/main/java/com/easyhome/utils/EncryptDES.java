package com.easyhome.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * DES 方法进行对称加密解密
 * 
 * @date 2016年6月7日 上午10:45:20
 */
public class EncryptDES {
	

	// KeyGenerator 提供对称密钥生成器的功能，支持各种算法
	private KeyGenerator keygen;
	// SecreKey 负责保存对称密钥
	private SecretKey deskey;
	// Cipher 负责完成加密或者解密工作
	private Cipher c;
	// 该字节数组负责保存加密的结果
	private byte[] cipherByte;

	public EncryptDES() throws NoSuchAlgorithmException, NoSuchPaddingException {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		// 实例化支持DES算法的密钥生成器（算法名称命名需按照规定，否则抛出异常）
		keygen = KeyGenerator.getInstance("DES");
		// 生成密钥
		deskey = keygen.generateKey();
		System.out.println("the secret key is:" + deskey);
		// 生成Cipher对象，指定其支持的DES算法
		c = Cipher.getInstance("DES");
	}

	/**
	 * 对字符串加密
	 * 
	 * @param str
	 * @return byte[]
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] Encrytor(String str) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
		c.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] src = str.getBytes();
		// 加密，结果存进cipherByte
		cipherByte = c.doFinal(src);
		return cipherByte;
	}

	/**
	 * 对字符串解密
	 * 
	 * @param buff
	 * @return byte[]
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public byte[] Decryptor(byte[] buff) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// 根据密钥，对Cipher对象进行初始化，ENCRYPT_MODE表示加密模式
		c.init(Cipher.DECRYPT_MODE, deskey);
		cipherByte = c.doFinal(buff);
		return cipherByte;
	}

	public static void main(String[] args) {

		String msg = "123.45";

		try {
			EncryptDES des1 = new EncryptDES();
			EncryptDES des2 = new EncryptDES();
			byte[] encontent = des1.Encrytor(msg);
			byte[] decontent = des1.Decryptor(encontent);

			System.out.println("明文是：" + msg);
			System.out.println("加密后：" + new String(encontent));
			System.out.println("解密后：" + new String(decontent));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
	}

}
