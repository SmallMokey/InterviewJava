/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题19：正则表达式匹配
 * // 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'
 * // 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题
 * // 中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"
 * // 和"ab*ac*a"匹配，但与"aa.a"及"ab*a"均不匹配。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

public class Java19_RegularExpressionsMatching {
    public boolean match(String reg, String text) {
        if (reg == null || text == null)
            return false;
        int regIndex = 0;
        int textIndex = 0;
        return matchCore(reg, regIndex, text, textIndex);
    }

    private boolean matchCore(String str, int strIndex, String pattern, int patternIndex) {
        //判断递归终止条件
        //1.字符和模式都到达末尾
        if (strIndex == str.length() || patternIndex == pattern.length()) {
            return true;
        }
        //1.模式先到达末尾 false
        if (strIndex != str.length() && patternIndex == pattern.length()) {
            return false;
        }

        //模式第字符为"*",且第一个字符匹配，为三种匹配模式；如不匹配，后移两位
        if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
            //第一个字符匹配
            if ((strIndex != str.length() && str.charAt(strIndex) == pattern.charAt(patternIndex)) || (pattern.charAt(patternIndex) == '.' && strIndex != str.length())) {
                return matchCore(str, strIndex + 1, pattern, patternIndex + 2) || matchCore(str, strIndex + 1, pattern, patternIndex) || matchCore(str, strIndex, pattern, patternIndex + 2);
            }else{
                return matchCore(str,strIndex,pattern,patternIndex+2);
            }
        }
        if ((strIndex != str.length() && str.charAt(strIndex) == pattern.charAt(patternIndex)) || (pattern.charAt(patternIndex) == '.' && strIndex != str.length())){
            return matchCore(str,strIndex+1,pattern,patternIndex+1);
        }
        return false;
    }

    @Test
    public void test() throws Exception {
        Assert.assertTrue(match("aaa", "a.a"));
        Assert.assertTrue(match("aaa", "ab*ac*a"));
        Assert.assertFalse(match("aaa", "aa.a"));
        Assert.assertFalse(match("aaa", "ab*a"));
    }
}
