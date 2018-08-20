package com.iantimothyjohnson.assignments.project1.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A collection of static methods for working with passwords. The implementation
 * of this class was copied from my Project 0.
 * 
 * @author Ian Johnson
 */
public final class Passwords {
    private static final Logger logger = LogManager.getLogger();

    /**
     * The usual java.util.Random class (which is used by Math.random) is fast,
     * but not good for security purposes since it's predictable (the Java API
     * documentation for java.util.Random mentions this).
     */
    private static final SecureRandom random = new SecureRandom();

    private Passwords() {
    }

    public static byte[] generateSalt() {
        // The length of a salt, in bytes.
        final int SALT_LENGTH = 16;
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);

        return salt;
    }

    /**
     * Hashes the given password with the given salt.
     * 
     * Thanks to <a href="https://stackoverflow.com/a/2861125">this
     * StackOverflow answer</a> for pointing me in the right direction with
     * respect to how password hashing can be done in Java.
     * 
     * @param password The password to hash.
     * @param salt     The salt to use in hashing.
     * @return The hashed password.
     */
    public static byte[] hashPassword(char[] password, byte[] salt) {
        final int N_ITERATIONS = 65536;
        final int KEY_LENGTH = 128;

        KeySpec spec = new PBEKeySpec(password, salt, N_ITERATIONS, KEY_LENGTH);
        SecretKeyFactory keyFactory;
        try {
            keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return keyFactory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException e) {
            logger.fatal(
                "Password hashing algorithm is not supported; aborting.", e);
            System.exit(1);
        } catch (InvalidKeySpecException e) {
            logger.fatal(
                "KeySpec was invalid, so hash could not be generated; aborting.",
                e);
            System.exit(1);
        }
        // This section should be unreachable, unless there is an error in the
        // implementation of the methods used above (highly unlikely).
        assert false;
        return null;
    }
}
