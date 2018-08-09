/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题49：丑数
 * // 题目：我们把只包含因子2、3和5的数称作丑数（Ugly Number）。求按从小到
 * // 大的顺序的第1500个丑数。例如6、8都是丑数，但14不是，因为它包含因子7。
 * // 习惯上我们把1当做第一个丑数。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java49_UglyNumber extends UtilAssert {
    int uglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] pUglyNumbers = new int[index];
        pUglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        //设置*2，*3，*5的三个指针
        int pMultiply2 = 0;
        int pMultiply3 = 0;
        int pMultiply5 = 0;
        while (nextUglyIndex < index) {
            int min = Min(pUglyNumbers[pMultiply2] * 2, pUglyNumbers[pMultiply3] * 3, pUglyNumbers[pMultiply5] * 5);
            pUglyNumbers[nextUglyIndex] = min;
            while (pUglyNumbers[pMultiply2] * 2 <= pUglyNumbers[nextUglyIndex])
                pMultiply2++;
            while (pUglyNumbers[pMultiply3] * 3 <= pUglyNumbers[nextUglyIndex])
                pMultiply3++;
            while (pUglyNumbers[pMultiply5] * 5 <= pUglyNumbers[nextUglyIndex])
                pMultiply5++;
            nextUglyIndex++;
        }
        int ugly = pUglyNumbers[index-1];
        return ugly;
    }

    private int Min(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        min = (min < number3) ? min : number3;
        return min;
    }

    @Test
    public void test() throws Exception {
        eq(uglyNumber(1), 1);
        eq(uglyNumber(2), 2);
        eq(uglyNumber(3), 3);
        eq(uglyNumber(4), 4);
        eq(uglyNumber(5), 5);
        eq(uglyNumber(6), 6);
        eq(uglyNumber(7), 8);
        eq(uglyNumber(8), 9);
    }
}
