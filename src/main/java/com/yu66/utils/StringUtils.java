package com.yu66.utils;

import java.util.Random;

/**
 * @description: 工具类
 * @author: 俞先浩
 * @create: 2021-02-25 17:03
 **/
public class StringUtils {
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}