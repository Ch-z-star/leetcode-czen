package easy;

import com.czen.leetcode.easy.TwoSum;
import org.junit.Test;

import java.util.Arrays;

public class TwoSumTest {
    private int[] nums = {2, 7, 11, 15};
    private int target = 9;
    private int[] result;

    @Test
    public void test01() {
        result = TwoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    @Test
    public void test02() {
        result = TwoSum.twoSum02(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
