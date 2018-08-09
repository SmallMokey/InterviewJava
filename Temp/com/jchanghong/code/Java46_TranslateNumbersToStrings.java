/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题46：把数字翻译成字符串
 * // 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻
 * // 译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
 * // 如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和
 * // "mzi"。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java46_TranslateNumbersToStrings extends UtilAssert {
    int number(int number) {
        if (number < 0)
            return 0;
        String sNumber = String.valueOf(number);
        return GetTranslationCount(sNumber);
    }

    //从字符串的末尾统计个数
    private int GetTranslationCount(String sNumber) {
        int sLength = sNumber.length();
        int[] counts = new int[sLength];
        int count = 0;
        for (int i = sLength - 1; i >= 0; i--) {
            count = 0;
            // f(i) = f(i+1)
            if (i < sLength - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }
            // 若i,i+1合起来在10~25之间 则 count = f(i+1)+f(i+2)
            if (i < sLength - 1) {
                int digit1 = sNumber.charAt(i) - '0';
                int digit2 = sNumber.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted>=10&&converted<=25){
                    //i不是倒数第二位
                    if (i<sLength-2){
                        count = count +counts[i+2];
                    }else {
                        count +=1;
                    }
                }
            }
            counts[i] = count;
        }
        count =counts[0];
        return count;
    }

    @Test
    public void test() throws Exception {
        eq(number(12258), 5);
        eq(number(0), 1);
    }
}
