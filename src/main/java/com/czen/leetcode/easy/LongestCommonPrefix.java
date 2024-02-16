package com.czen.leetcode.easy;

import javax.script.AbstractScriptEngine;

/**
 * 14、最长公共前缀
 * 需要改进的点，传入参数为 null
 */
public class LongestCommonPrefix {


    /**
     * 查找字符串中的最长公共前缀 1ms 70%
     *
     * @param strs 仅由小写英文字母组成
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        // 若存在两个字符串没有公共前缀，表示该数组没有公共前缀，即后续数组均不需要再进行比较
        String prefix = strs[0];
        int shorterStrLen, index = 0;
        for (int i = 1; (i < strs.length) && !prefix.isEmpty(); i++) {
            index = 0;
            shorterStrLen = prefix.length() < strs[i].length() ? prefix.length() - 1 : strs[i].length() - 1;
            // shorterStrLen = Math.min(len1, len2)
            // prefix.length() > 0
            while (index <= shorterStrLen) {
                if (strs[i].charAt(index) == prefix.charAt(index)) {
                    index++;
                } else {
                    prefix = prefix.substring(0, index);
                    break;
                }
            }
            prefix = prefix.substring(0, index);
        }
        return prefix;
    }

    // 解法二：对字符串数组，纵向扫描 1ms 70%
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        int index = 0, shortestLen = strs[0].length();
        String prefix = strs[0];
        outCycle:
        while (index < shortestLen) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < shortestLen) {
                    shortestLen = strs[i].length();
                }
                if (shortestLen == 0 || strs[i].charAt(index) != prefix.charAt(index)) {
                    break outCycle;
                }
            }
            index++;
        }
        return prefix.substring(0, index);
    }

    /**
     * 解法三：对数组采用分治思想，两两划分比较，取公共前缀
     * LCP 的计算满足结合律 LCP(LCP(S1,S2...),LCP(S1,S2...))
     * longestCommonPrefix(String[] arr,int begin,int end)
     * 递归：求最小子串，若当前数组长度为 1 返回，使用最小子串进行比较
     * 将所求公共前缀作为递归条件，再参与递归运算
     */
    public static String longestCommonPrefix3(String[] strs) {
        // 采用分治思想，对数组进行拆分比较，将数组拆为最小元素：只包含一个或两个字符串
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix3(strs, 0, strs.length - 1);
        }
    }

    public static String longestCommonPrefix3(String[] strs, int begin, int end) {
        if (begin == end) { // 将字符串数组拆解为最小子串
            return strs[begin];
        } else {
            int mid = (end - begin)/2 + begin;
            String lcpLeft = longestCommonPrefix3(strs, begin, mid);
            String lcpRight = longestCommonPrefix3(strs, mid + 1, end);
            return commonPrefix(lcpRight, lcpLeft);
        }
    }

    // 计算两个字符串最长公共前缀
    private static String commonPrefix(String lcpRight, String lcpLeft) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        // 若在此处返回，表示最小串即为其公共前缀
        return lcpLeft.substring(0, minLength);
    }

    /* 分治解法草稿
    public static String recordLongestCommonPrefix3(String[] strs, int begin, int end) {
        int middle = (begin + end) / 2;
        if (end - begin >= 2) {
            recordLongestCommonPrefix3(strs, begin, middle);
            recordLongestCommonPrefix3(strs, middle + 1, end);
        }
        if (end - begin < 2) {
            recordPrintSmallestStr(strs, begin, end);
            //recordCountSmallestStr(strs, begin, end);
        }
        return null;
    }

    private static String recordCountSmallestStr(String[] strs, int begin, int end) {
        if (begin == end) {
            return strs[begin];
        } else {
            for (int i = 0; i < strs[begin].length(); i++) {
                if (strs[begin].charAt(i) != strs[end].charAt(i)) {
                    return strs[begin].substring(0, i - 1);
                }
            }
        }
        return null;
    }

    private static String recordPrintSmallestStr(String[] strs, int begin, int end) {
        if (begin == end) {
            System.out.println("the elements are:[ " + strs[begin] + " ]");
        } else {
            System.out.println("the elements are:[ " + strs[begin] + ", " + strs[end] + " ]");
        }
        return null;
    }
     */

    // 解法四：对第一个字符串采用二分查找思想，leetcode -> leet code ，分别比较 leet 和 code 的前缀
    public static String longestCommonPrefix4(String[] strs) {

        return null;
    }

    // 解法五：对数组进行排序，排序后取公共前缀
    private LongestCommonPrefix() {

    }

}
