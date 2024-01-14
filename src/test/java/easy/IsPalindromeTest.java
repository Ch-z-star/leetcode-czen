package easy;

import com.czen.leetcode.easy.IsPalindrome;

public class IsPalindromeTest {
    // 测试用例
    private static int[] nums = {123321, 10, 100};
    // 调用的解法
    private static String FUNC_INDEX = "2";

    public static void main(String[] args) {
        System.out.println("is palindrome :" + IsPalindrome.isPalindrome(nums, FUNC_INDEX));
    }
}
