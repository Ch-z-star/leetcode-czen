package easy;

import com.czen.leetcode.easy.IsPalindrome;

import java.util.EnumSet;

public class IsPalindromeTest {
    private static int[] nums = {123321, 10 ,100};

    public static void main(String[] args) {
        for (int x: nums) {
            System.out.println(x + ": " + IsPalindrome.isPalindrome(x));
        }
    }
}
