package com.czen.leetcode.easy;

import java.util.Hashtable;

/**
 * 1、两数之和
 */
public class TwoSum {
    private TwoSum() {
    }

    /**
     * @param nums   给定整数数组
     * @param target 整数目标值
     * @return 返回和为目标值的数组下标
     */
    public static int[] twoSum(int[] nums, int target) { // 解法一：暴力枚举
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == target - nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 解法二：采用 hashtable 构建一个索引表加快查找效率
    public static int[] twoSum02(int[] nums, int target) {
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                // 如果包含匹配的值，连同当前值一起返回
                return new int[]{i, hashtable.get(target - nums[i])};
            }
            // 向 hashtable 中放入值，形式为 key:nums[i], value:i
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
