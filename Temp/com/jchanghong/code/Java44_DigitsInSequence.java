/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题44：数字序列中某一位的数字
 * // 题目：数字以0123456789101112131415…的格式序列化到一个字符序列中。在这
 * // 个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。请写一
 * // 个函数求任意位对应的数字。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java44_DigitsInSequence extends UtilAssert {

    int digit(int k) {
        if (k < 0)
            return -1;

        int digit = 1;
        while (true) {
            //计算m位数字共有的个数
            int number = CountOfIntegers(digit);
            if (k < number * digit) {
                return digitAtIndex(k, digit);
            }
            k -= number * digit;
            digit++;
        }
    }

    //返回第K位的数字
    private int digitAtIndex(int k, int digit) {
        //881,number = 100 + 270 = 370
        int number = beginNumber(digit) + k / digit;
        //indexFromRight = 3 - 1 =2
        int indexFromRight = digit - k % digit;
        //number = 37
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    private int beginNumber(int digit) {
        if (digit == 1)
            return 0;
        return (int) Math.pow(10, digit - 1);
    }

    //统计m位数字共有多少位
    private int CountOfIntegers(int digit) {
        if (digit == 1)
            return 10;
        int count = (int) Math.pow(10, digit - 1);
        return 9 * count;
    }

    @Test
    public void test() throws Exception {
        //数字以0123456789101112131415
        eq(digit(5), 5);
        eq(digit(13), 1);
        eq(digit(19), 4);
        eq(digit(10), 1);

    }
}
