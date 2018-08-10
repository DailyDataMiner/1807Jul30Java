package utils;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class Password {
	
	public static void main (String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String pass = "dumbo";
		String hash = getHash(pass);
		System.out.println(hash);
		
		System.out.println(validatePassword("dumbo", hash));
	}
	
	public static final int SALT_SIZE = 16;
	public static final int ITERATION_COUNT = 65536;
	public static final int KEY_LENGTH = 128;
	public static final String HASH_ALGORITHM = "PBKDF2WithHmacSHA1";
	public static final String SALT_ALGORITHM = "SHA1PRNG";

	private static final SecureRandom r = new SecureRandom();
	
	public static String getHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		char[] chars = password.toCharArray();
		byte[] salt = getSalt();
		PBEKeySpec spec = new PBEKeySpec(chars, salt, ITERATION_COUNT, KEY_LENGTH);
		SecretKeyFactory skf = SecretKeyFactory.getInstance(HASH_ALGORITHM);
		byte[] hash = skf.generateSecret(spec).getEncoded();
		return ITERATION_COUNT + ":" + toHex(salt) + ":" + toHex(hash);
	}
	 
	private static byte[] getSalt() throws NoSuchAlgorithmException {
	    SecureRandom sr = SecureRandom.getInstance(SALT_ALGORITHM);
	    byte[] salt = new byte[SALT_SIZE];
	    sr.nextBytes(salt);
	    return salt;
	}
	 
	private static String toHex(byte[] array) throws NoSuchAlgorithmException
	{
	    BigInteger bi = new BigInteger(1, array);
	    String hex = bi.toString(16);
	    int paddingLength = (array.length * 2) - hex.length();
	    if(paddingLength > 0)
	    {
	        return String.format("%0"  +paddingLength + "d", 0) + hex;
	    }else{
	        return hex;
	    }
	}
	
	public static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String[] parts = storedPassword.split(":");
		int iterations = Integer.parseInt(parts[0]);
		byte[] salt = fromHex(parts[1]);
		byte[] hash = fromHex(parts[2]);
		 
		PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] testHash = skf.generateSecret(spec).getEncoded();
		 
		int diff = hash.length ^ testHash.length;
		for(int i = 0; i < hash.length && i < testHash.length; i++) {
			diff |= hash[i] ^ testHash[i];
		}
		return diff == 0;
	}
	
	private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
	    byte[] bytes = new byte[hex.length() / 2];
	    for(int i = 0; i<bytes.length ;i++)
	    {
	        bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	    }
	    return bytes;
	}
	
	
	
}
