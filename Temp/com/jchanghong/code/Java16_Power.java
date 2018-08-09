/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题16：数值的整数次方
 * // 题目：实现函数double Power(double base, int exponent)，求base的exponent
 * // 次方。不得使用库函数，同时不需要考虑大数问题。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

public class Java16_Power {

    boolean g_InvaildInput = false;

    public double Power(double base, int exponent) {
        g_InvaildInput = false;
        //底数为零，指数为负数
        if (base == 0.0 && exponent < 0) {
            g_InvaildInput = true;
            return 0.0;
        }
        int absExponent = exponent;
        if (exponent < 0)
            absExponent = -exponent;
        double result = PowerWithExponet(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;

    }

    private double PowerWithExponet(double base, int absExponent) {
        if (absExponent == 0)
            return 1;
        if (absExponent == 1)
            return base;
        double result = PowerWithExponet(base, absExponent >> 1);
        result *= result;
        if ((absExponent & 0x1)==1){
            result*=base;
        }
        return result;
    }

    public boolean equels(double d1, double d2) {
        return Math.abs(d1 - d2) < 0.0000000000001;
    }

    @Test
    public void test() throws Exception {
        Assert.assertTrue(equels(Power(2.3, 4), Math.pow(2.3, 4)));
    }
}
