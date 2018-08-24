package utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class Password {

	public static final int SALT_SIZE = 16;
	public static final int ITERATIONS = 65536;
	public static final int KEY_LENGTH = 128;
	public static final String HASH_ALGORITHM = "PBKDF2WithHmacSHA1";
	public static final String SALT_ALGORITHM = "SHA1PRNG";

	public static byte[] getHash(String password, byte[] salt) {
		byte[] hashedPassword = null;
		char[] chars = password.toCharArray();
		try {
			PBEKeySpec spec = new PBEKeySpec(chars, salt, ITERATIONS, KEY_LENGTH);
			SecretKeyFactory skf = SecretKeyFactory.getInstance(HASH_ALGORITHM);
			hashedPassword = skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return hashedPassword;
	}

	public static byte[] getSalt() {
		SecureRandom sr = null;
		try {
			sr = SecureRandom.getInstance(SALT_ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] salt = new byte[SALT_SIZE];
		sr.nextBytes(salt);	
		return salt;
	}

	public static boolean validatePassword(String originalPassword, byte[] pwdHash, byte[] pwdSalt) {		
		boolean valid = false;
		try {
			PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), pwdSalt, ITERATIONS, pwdHash.length * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] testHash = skf.generateSecret(spec).getEncoded();

			int diff = pwdHash.length ^ testHash.length;
			for (int i = 0; i < pwdHash.length && i < testHash.length; i++) {
				diff |= pwdHash[i] ^ testHash[i];
			}
			valid = (diff == 0);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return valid;
	}

}
