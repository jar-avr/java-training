package ru.javavision.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class Crypt {
    private static final Random random = new SecureRandom();
    private static final String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int iterations = 10000;
    private static final int keylength = 256;
    private static final int length = 15;
    private static final String saltValue;

    static {
        StringBuilder finalval = new StringBuilder(length);

        for (int i = 0; i < length; i++)
        {
            finalval.append(characters.charAt(random.nextInt(characters.length())));
        }

        saltValue = new String(finalval);
    }

    public static byte[] hash(char[] password, byte[] salt)
    {
        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keylength);
        Arrays.fill(password, Character.MIN_VALUE);
        try
        {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        }
        catch (NoSuchAlgorithmException | InvalidKeySpecException e)
        {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        }
        finally
        {
            spec.clearPassword();
        }
    }

    public static String generateSecurePassword(String password)
    {
        String finalval = null;

        byte[] securePassword = hash(password.toCharArray(), saltValue.getBytes());

        finalval = Base64.getEncoder().encodeToString(securePassword);

        return finalval;
    }

    public static boolean verifyUserPassword(String providedPassword,
                                             String securedPassword)
    {
        boolean finalval = false;

        String newSecurePassword = generateSecurePassword(providedPassword);

        finalval = newSecurePassword.equalsIgnoreCase(securedPassword);

        return finalval;
    }
}
