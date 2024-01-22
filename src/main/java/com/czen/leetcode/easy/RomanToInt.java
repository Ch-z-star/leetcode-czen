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
     * 解法二：罗马数字的取数规则：若一个数字比它右边的数字小，则将其取反
     */

    /**
     * 解法三：字符串中的特殊情况全部替换
     */




}
