/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题56（二）：数组中唯一只出现一次的数字
 * // 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
 * // 找出那个只出现一次的数字。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java56_02_NumberAppearingOnce extends UtilAssert {

    public int once(int[] ints) {
        if (ints == null || ints.length <= 0) {
            return -1;
        }
        //将数组中每个元素的二进制位相加
        int bitSum[] = new int[32];
        for (int i = 0; i < ints.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j--) {
                int bit = ints[i] & bitMask;
                if (bit != 0)
                    bitSum[j] += 1;
                //bitMask 左移一位，比较下一个二进制位
                bitMask = bitMask << 1;
            }
        }

        //算出result
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        int[] ints = {1, 2, 2, 2};
        eq(once(ints), 1);
    }
}
