package easy;

import com.czen.leetcode.easy.LongestCommonPrefix;
import org.junit.Test;

public class LongestCommonPrefixTest {
    private String[] test_arr = {"flower", "flow", "flight"};
    private String[] test_nonCommon = {"dog", "race", "car"};
    private String[] test_error1 = {"a", "ab"};
    private String[] test_error2 = {"ab", "a"};
    private String[] test_error3 = {"a"};

    private String[] test_error4 = {"aaa", "aa", "aaa"};

    @Test
    public void test_func01() {
        /*
        String sub = "Hello".substring(0, 0);
        System.out.println("sub is " + sub);
        System.out.println("sub len is " + sub.length());
         */
        // System.out.println("the longest common prefix is:" + LongestCommonPrefix.longestCommonPrefix(test_arr));
        // System.out.println("the longest common prefix is:" + LongestCommonPrefix.longestCommonPrefix(test_nonCommon));
        System.out.println("the longest common prefix is:" + LongestCommonPrefix.longestCommonPrefix(test_error4));
    }
}
