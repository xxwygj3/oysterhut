package com.memuli.oysterhutadmin.util;

import java.security.MessageDigest;

public class MyMD5 {
    /**
     * MD5算法名
     */
    private static final String MD5_ALGORITHM = "MD5";
    /**
     * 编码方式
     */
    private static final String CHARSET_NAME = "UTF-8";

    /**
     * Md5签名
     *
     * @param input 签名明文
     * @return 签名结果
     */
    public static String md5Sign(String input) {
        return md5Sign(input, CHARSET_NAME);
    }

    /**
     * Md5签名
     *
     * @param input   签名明文
     * @param charset 编码名称
     * @return 签名结果
     */
    public static String md5Sign(String input, String charset) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(MD5_ALGORITHM);
            messageDigest.reset();
            messageDigest.update(input.getBytes(charset));

            byte[] byteArray = messageDigest.digest();
            StringBuffer md5StrBuff = new StringBuffer();
            for (int i = 0; i < byteArray.length; i++) {
                if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                    md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
                } else {
                    md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
                }
            }
            return md5StrBuff.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
