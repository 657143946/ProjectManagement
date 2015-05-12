package me.chrislee.utils.cipher;

import java.security.MessageDigest;

/**
 * Created by ChrisLee on 15-5-12.
 * 加密工具
 */
public class CipherUtils {

    /**
     * MD5单项加密一次
     */
    public static String md5Once(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update((str).getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(
                        Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }
        return md5StrBuff.toString().replace("-", "").toLowerCase();
    }

    /**
     * md5单项加密多次
     */
    public static String md5(String str, int time){
        for(int i=0; i<time; i++){
            str = md5Once(str);
        }
        return str;
    }
}
