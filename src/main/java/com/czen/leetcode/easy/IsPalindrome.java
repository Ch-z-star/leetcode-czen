package com.czen.leetcode.easy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 9、回文数
 */
public class IsPalindrome {
    private static String METHOD_NAME = "isPalindrome";

    private IsPalindrome() {
    }

    /**
     * 反射调用特定解法函数
     *
     * @param arr       测试数组参数
     * @param funcIndex 调用的函数下标后缀
     */
    public static boolean isPalindrome(int[] arr, String funcIndex) {
        Class clazz = IsPalindrome.class;
        try {
            // 静态方法在调用时，不需要传入实例化对象
            Method targetMethod = clazz.getMethod(METHOD_NAME + funcIndex, Integer.class);
            for (int x : arr) {
                Object isSuccess = targetMethod.invoke(null, x);
                if (!(Boolean) isSuccess)
                    return false;
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * 判断一个整数是不是回文数，基础解法，存入数组遍历比较 147ms 5%
     *
     * @param x 整数
     * @return boolean
     */
    public static boolean isPalindrome1(Integer x) { // list 存储数据，遍历 list 进行比较
        if (x < 0)
            return false;
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (list.get(i) != list.get(list.size() - i - 1))
                return false;
        }
        return true;
    }

    /**
     * 解法二：反转一半数字
     * 1、所有负数都不可能是回文
     * 2、个位数为 0 的数字不可能是回文
     * 3、反转的过程中，当原始数字小于或等于反转后的数字时，意味着已经处理了一半的数字了
     * 5ms 98%
     */
    public static boolean isPalindrome2(Integer x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertNumber = 0;
        while (x > revertNumber) { // 取原数字进行反转
            revertNumber = revertNumber * 10 + x % 10;
            x /= 10;
        }
        // 由于处于中位的数字不影响回文，可以将其去除
        return x == revertNumber || x == revertNumber / 10;
    }

    /**
     * 解法三：反转整个数字进行比较，如果和其原来相等，则为回文数
     * 需要考虑整数溢出问题 8ms 18%
     */
    public static boolean isPalindrome3(Integer x) {
        if (x < 0)
            return false;
        int revertNum = 0;
        int temp = x;
        while (x != 0) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return temp == revertNum;
    }

    /**
     * 解法四：入栈，依次和原数字比较，也只需要比较一半的数字 19ms 5%
     */
    public static boolean isPalindrome4(Integer x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int temp = x;
        Stack<Integer> stack = new Stack<>();
        while (x != 0) {
            stack.add(x % 10);
            x /= 10;
        }
        while (!stack.empty()) {
            int compareNum = stack.pop();
            if (compareNum != temp % 10) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    /**
     * 解法五：转换为字符串，头尾字符进行比较 6ms 56%
     */
    public static boolean isPalindrome5(Integer x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        String str = Integer.toString(x);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        /**
         * int left = 0, right = str.length() - 1;
         * while(left < right) {
         *  if(s.charAt(left) == s.charAt(right)) {
         *          left++;
         *          right--;
         *      } else {
         *          return false;
         *      }
         * }
         * return true;
         */
        return true;
    }

    /**
     * 解法六：数学解法，每次取数字的头和尾进行比较，比较完一次后去掉头和尾 7ms 32%
     */
    public static boolean isPalindrome6(Integer x) {
        if (x < 0) {
            return false;
        }
        int maxDivisor = 1;
        // 一次遍历求该数字被 10 整除的最大除数
        while (x / maxDivisor >= 10)
            maxDivisor *= 10;
        while (x > 0) {
            int left = x / maxDivisor;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % maxDivisor) / 10;
            maxDivisor /= 100;
        }
        return true;
    }

}
