package com.zhaoning.myblog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhaoning
 * @date 2020/5/4 - 9:03
 */
public class MD5Utils {
    public static String code(String str){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDingest = md.digest();
            int i;
            StringBuffer buffer = new StringBuffer("");
            for (int offset = 0;offset<byteDingest.length;offset++){
                i=byteDingest[offset];
                if (i<0){
                    i +=256;
                }
                if (i<16)
                    buffer.append("0");
                buffer.append(Integer.toHexString(i));

            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(code("111"));
    }


}
