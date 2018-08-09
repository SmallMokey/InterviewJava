/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题53（二）：0到n-1中缺失的数字
 * // 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
 * // 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
 * // 中，请找出这个数字。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java53_02_MissingNumber extends UtilAssert {
    int missing(int[] ints, int n) {
        if (ints == null || ints.length <= 0)
            return -1;
        int left = 0;
        int right = n-2;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (ints[middle] != middle) {
                if (middle == 0 || ints[middle - 1] == middle - 1){
                    return middle;
                }
                right = middle -1;
            } else {
                //中间值和下标相等
                left = middle + 1;
            }
        }
        //最后一个元素缺少
        if (left == n-1)
            return n-1;
        return -1;
    }

    @Test
    public void test() throws Exception {
        int[] ints = {0, 1, 2, 3};
        eq(missing(ints, 5), 4);
    }
}
