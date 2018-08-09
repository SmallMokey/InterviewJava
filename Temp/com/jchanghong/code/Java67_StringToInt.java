/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题67：把字符串转换成整数
 * // 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
 * // 能使用atoi或者其他类似的库函数。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

public class Java67_StringToInt {
    public int str2Int(String string) {
        if (string == null || string.length() <= 0)
            return -1;
        char[] chars = string.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        boolean flag = false;

        if (chars[0]=='+'){
            flag = false;
        }else if (chars[0] == '_'){
            flag = true;
        }else {
            stringBuffer.append(chars[0]);
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9')
                return -1;
            stringBuffer.append(chars[i]);
        }
        int i = Integer.parseInt(stringBuffer.toString());
        if (flag)
            i = 0 - i;
        return i;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(str2Int("2"), 2);
        Assert.assertEquals(str2Int(""), -1);
        Assert.assertEquals(str2Int("ASD"), -1);
        Assert.assertEquals(str2Int("-2147483648"), -2147483648);
        Assert.assertEquals(str2Int("22"), 22);
        Assert.assertEquals(str2Int("-22"), -22);
        Assert.assertEquals(str2Int("44422"), 44422);
    }
}
