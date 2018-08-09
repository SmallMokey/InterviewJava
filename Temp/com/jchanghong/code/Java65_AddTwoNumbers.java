/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题65：不用加减乘除做加法
 * // 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
 * // 四则运算符号。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

public class Java65_AddTwoNumbers {
    public int sum(int int1, int int2) {
        //异或运算，（0,0）（1,1）异或得0 （1,0）（0,1）异或得1，相当于二进制不考虑进位的加法
        //与运算然后左移 来处理进位 （0,0）（0,1）（1,0）结果都为0 （1,1）的结果为1
        //循环终止条件，与运算为0
        int sum, carry;
        do {
            sum = int1 ^ int2;
            carry = (int1 & int2)<<1;
            int1 = sum;
            int2 = carry;
        } while (int2 != 0);
        return sum;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(sum(1, 2), 3);
        Assert.assertEquals(sum(1, 222), 223);
    }
}
