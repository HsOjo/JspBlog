package utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {
    public static String md5(byte[] bytes) {
        byte[] md5_bytes = null;
        try {
            md5_bytes = MessageDigest.getInstance("md5").digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        StringBuilder md5_str = new StringBuilder(new BigInteger(1, md5_bytes).toString(16));
        for (int i = 0; i < 32 - md5_str.length(); i++) {
            md5_str.insert(0, "0");
        }
        return md5_str.toString();
    }

    public static String md5(String str) {
        return HashUtils.md5(str.getBytes());
    }
}