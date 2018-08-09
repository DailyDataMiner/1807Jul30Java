package util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class Password {
	public static final int SALT_SIZE = 16;
	public static final int ITERATION_COUNT = 65536;
	public static final int KEY_LENGTH = 128;
	public static final String ALGORITHM = "PBKDF2WithHmacSHA1";
	private static final SecureRandom r = new SecureRandom();
	
	public static byte[] getSalt() {
		byte[] salt = new byte[SALT_SIZE];
		r.nextBytes(salt);
		return salt;
	}
	
	public static byte[] getHash(String password, byte[] salt) {
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATION_COUNT, KEY_LENGTH);
		try {
			SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM);
			return f.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return null;
	}
}
