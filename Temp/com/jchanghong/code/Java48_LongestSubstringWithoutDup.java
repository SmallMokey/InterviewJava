/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题48：最长不含重复字符的子字符串
 * // 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子
 * // 字符串的长度。假设字符串中只包含从'a'到'z'的字符。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java48_LongestSubstringWithoutDup extends UtilAssert {
    String sub(String text) {
        int curLength = 0;
        int maxLength = 0;
        StringBuffer maxstringBuffer = new StringBuffer();
        StringBuffer stringBuffer = new StringBuffer();
        //标记字符是否读到及上一次读到该字符的位置
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }
        for (int i = 0; i < text.length(); i++) {
            //最近一次读到该字符的位置
            int prevIndex = position[text.charAt(i) - 'a'];
            //没有被读到或两次读到相同字符的距离 d>f(i-1)=curlength,则curlength++
            if (prevIndex < 0 || i - prevIndex > curLength) {
                stringBuffer.append(text.charAt(i));
                curLength++;
            } else {
                //以i字符结尾的最长字符串为preview和i字符之间的字符串
                curLength = i - prevIndex;
                stringBuffer.setLength(0);
                stringBuffer.append(text.substring(prevIndex + 1, i + 1));
            }
            position[text.charAt(i) - 'a'] = i;
            if (curLength > maxLength) {
                maxLength = curLength;
            }
            if (stringBuffer.length()>maxstringBuffer.length()){
                maxstringBuffer = new StringBuffer(stringBuffer);
            }
        }
        return maxstringBuffer.toString();
    }

    @Test
    public void test() throws Exception {
        eq(sub("abc"), "abc");
        eq(sub("arabcacfr"), "rabc");
        eq(sub("abcbc"), "abc");
        eq(sub("aabcdff"), "abcdf");
    }
}
