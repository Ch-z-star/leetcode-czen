package easy;

import com.czen.leetcode.easy.IsPalindrome;

public class IsPalindromeTest {
    // 测试用例
    private static int[] nums = {123321, 10, 100, 121, -121};

    private static int[] nums_correct = {12321, 1221};

    private static int[] nums_fault = {1234, 12345};

    private static int[] nums_test = {121};
    // 调用的解法
    private static String FUNC_INDEX = "5";

    public static void main(String[] args) {
        // System.out.println("is palindrome :" + IsPalindrome.isPalindrome(nums, FUNC_INDEX));

        // System.out.println("is palindrome :" + IsPalindrome.isPalindrome(nums_test, FUNC_INDEX));

        System.out.println("is palindrome :" + IsPalindrome.isPalindrome(nums_test, FUNC_INDEX));
    }
}
