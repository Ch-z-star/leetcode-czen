package easy;

import com.czen.leetcode.easy.RomanToInt;
import org.junit.Test;


public class RomanToIntTest {
    private static String[] ROMAN_ARR = {"III", "IV", "IX", "LVIII", "MCMXCIV"};

    private static String[] ROMAN_ERROR = {"IV", "IX", "MCMXCIV"};

    @Test
    public void test_func01() {
        for (String s : ROMAN_ARR) {
            System.out.println(RomanToInt.romanToInt(s));
        }
    }

    @Test
    public void fun_justify01() {
        for (String s : ROMAN_ERROR) {
            System.out.println(RomanToInt.romanToInt(s));
        }
    }

    @Test
    public void test_func02() {
        // test output
        String showStr = "MCMXCIV";
        System.out.println(RomanToInt.romanToInt2(showStr));
        // test error
        /*
        String error = "III";
        System.out.println(RomanToInt.convertToInt('I'));
        */
    }

    @Test
    public void test_fun03() {
        // test output
        String showStr = "MCMXCIV";
        System.out.println(RomanToInt.romanToInt3(showStr));
    }



}
