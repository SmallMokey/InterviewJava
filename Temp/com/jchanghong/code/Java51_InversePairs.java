/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题51：数组中的逆序对
 * // 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
 * // 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java51_InversePairs extends UtilAssert {
    int number(int[] ints) {
        if (ints == null || ints.length <= 0)
            return 0;
        //复制ints数组
        int[] copy = new int[ints.length];
        for (int i = 0; i < ints.length; i++) {
            copy[i] = ints[i];
        }
        int count = inverseParisCore(ints, copy, 0, ints.length - 1);
        return count;
    }

    //递归实现
    private int inverseParisCore(int[] data, int[] copy, int start, int end) {
        //递归终止条件,start == end,拆分到最后一个元素，复制元素
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) >> 1;
        //统计左边和右边逆序对，每次传入排序好copy作为data
        int left = inverseParisCore(copy, data, start, start + length);
        int right = inverseParisCore(copy, data, start + length + 1, end);

        //处理左右两边逆序对
        //i初始化为前半段最后一个数字的下标
        int i = start + length;
        //j初始化为后半段最后一个数字的下标
        int j = end;
        int copyIndex = end;
        //计数
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            //前半段i位置元素>后半段j元素，则j之前的元素都比i小，data数组已排序
            if (data[i] > data[j]) {
                copy[copyIndex--] = data[i--];
                count += j - start - length;
            } else {
                copy[copyIndex--] = data[j--];
            }
        }

        //复制剩下的数组元素
        while (i >= start) {
            copy[copyIndex--] = data[i--];
        }
        while (j >= start + length + 1) {
            copy[copyIndex--] = data[j--];
        }
        return left + right + count;
    }

    @Test
    public void test() throws Exception {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 0};
        eq(number(ints), 7);
    }
}
