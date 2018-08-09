/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题58（一）：翻转单词顺序
 * // 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * // 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
 * // 则输出"student. a am I"。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java58_01_ReverseWordsInSentence extends UtilAssert {
    String reverseWord(String text) {
        if (text == null || text.length() <= 0) {
            return "";
        }
        char[] chars = text.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        //第一步，反转整个句子
        reverse(chars, start, end);

        //第二步，翻转每个单词
        start = end = 0;
        while (start < chars.length) {
            if (chars[start] == ' ') {
                start++;
                end++;
            } else if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end;
            } else {
                end++;
            }
        }

        return new String(chars);
    }

    public void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    @Test
    public void test() throws Exception {
        eq(reverseWord("I am a student. "), "   student. a am I");
        eq(reverseWord("am"), "am");
    }
}
