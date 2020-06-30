package com.zsy.util.httputil;

import java.util.Random;

/**
 * @author AAA
 */
public class RandomMacUtil {


    /**
     * 生成随机Mac地址
     *
     * @return String
     */
    public static String createRandomMacAddress() {
        return getRandChars(6);
    }

    /**
     * 生成 2个随机的小写字母或者数字组成的串
     *
     * @return String
     */
    private static String getRandChars(int len) {
        String multiChars = "";
        for (int i = 0; i < len; i++) {
            multiChars = multiChars.concat(":");
            String chars = getRandTwoChars();
            multiChars = multiChars.concat(chars);
        }
        if (len > 0) {
            multiChars = multiChars.substring(1);
        }
        return multiChars;
    }


    /**
     * 生成2个随机的小写字母或者数字
     *
     * @return String
     */
    private static String getRandTwoChars() {
        String chars = createRandomChar();
        return chars.concat(createRandomChar());
    }

    /**
     * 生成随机的小写字母或者数字
     *
     * @return 随机的小写字母或者数字
     */
    private static String createRandomChar() {
        String[] chars = new String[]{
                "a", "b", "c", "d", "e", "f", "0",
                "1", "2", "3", "4", "5", "6", "7", "8", "9",
        };
        Random rand = new Random();
        int rInt = rand.nextInt(chars.length);
        return chars[rInt];
    }


}
