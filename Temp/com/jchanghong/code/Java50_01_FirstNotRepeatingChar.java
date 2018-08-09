/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题50（一）：字符串中第一个只出现一次的字符
 * // 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出
 * // 'b'。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java50_01_FirstNotRepeatingChar extends UtilAssert {

    char first(String text) {
        if (text == null || text.length() <= 0)
            return ' ';
        char[] chars = text.toCharArray();
        int[] position = new int[256];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            position[chars[i]]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (position[chars[i]] == 1) {
                return chars[i];
            }
            continue;
        }
        return ' ';
    }

    @Test
    public void test() throws Exception {
        eq(first("abaccdeff"), 'b');
        eq(first("aabbvf"), 'v');
    }
}
