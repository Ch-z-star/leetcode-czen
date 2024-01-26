package com.czen.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 13、罗马数字转为整数
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 六种特殊情况
 * IV            4
 * IX            9
 * XL            40
 * XC            90
 * CD            400
 * CM            900
 */
public class RomanToInt {
    private RomanToInt() {
    }

    /**
     * 采用 p、q 分别记录字符串第一位和下一位的字符，判断 p + q 是否存在于 map 中 21ms 5%
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<String, Integer> map = Stream.of(new Object[][]{
                {"IV", 4}, {"IX", 9}, {"XL", 40}, {"XC", 90}, {"CD", 400}, {"CM", 900},
                {"I", 1}, {"V", 5}, {"X", 10}, {"L", 50}, {"C", 100}, {"D", 500}, {"M", 1000}
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

        int addNum = 0;
        int index = 0;
        if (s.length() == 1) {
            return map.get(s);
        }
        while (index < s.length()) {
            char prev = s.charAt(index);
            char next;
            if (index + 1 == s.length()) {
                next = prev;
            } else {
                next = s.charAt(index + 1);
            }
            String specialNum = String.valueOf(prev) + next;
            if (map.containsKey(specialNum)) {
                addNum += map.get(specialNum);
                index += 2;
            } else {
                addNum += map.get(prev + "");
                index += 1;
            }
        }
        return addNum;
    }

    /**
     * 解法二：罗马数字的取数规则：若一个数字比它右边的数字小，则将其取反 2ms 100%
     */
    public static int romanToInt2(String s) {
        int sum = 0;
        int index = s.length() - 1;
        char current, prev;
        prev = s.charAt(index);
        /**
         * 从左往右取值，要求当前值比其右边值小时，当前值取反，
         * 等价于：从右往左取，当前值比其左边值（上一个值）小时，当前值取反
         * 如果从左往右取，需要注意 prev 数列开始时重复两次，最后结尾时，需要加上最后一个值
         */
        while (index >= 0) {
            current = s.charAt(index);
            if (convertToInt(current) < convertToInt(prev)) {
                sum -= convertToInt(current);
            } else {
                sum += convertToInt(current);
            }
            prev = current;
            index--;
        }
        return sum;
    }

    public static int convertToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            // special condition
            case 'a':
                return 4;
            case 'b':
                return 9;
            case 'c':
                return 40;
            case 'd':
                return 90;
            case 'e':
                return 400;
            case 'f':
                return 900;
        }
        return 0;
    }


    /**
     * 解法三：字符串中的特殊情况全部替换 14ms 5% | 4ms %8
     */
    public static int romanToInt3(String s) {
        s = replaceAllSpecialCharacter(s);
        int sum = 0;
        for (char c:s.toCharArray()) {
            sum += convertToInt(c);
        }
        return sum;
    }

    private static String replaceAllSpecialCharacter(String s) {
        // 链式写法耗时多 10ms
        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");
        return s;
    }
}
