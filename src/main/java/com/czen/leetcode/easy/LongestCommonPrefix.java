package com.czen.leetcode.easy;

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
     */
    //

    // 解法四：对第一个字符串采用二分查找思想，leetcode -> leet code ，分别比较 leet 和 code 的前缀

    // 解法五：对数组进行排序，排序后取公共前缀
    private LongestCommonPrefix() {
    }
}
