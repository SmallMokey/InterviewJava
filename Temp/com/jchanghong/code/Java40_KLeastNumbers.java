/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题40：最小的k个数
 * // 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * // 这8个数字，则最小的4个数字是1、2、3、4。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Java40_KLeastNumbers extends UtilAssert {
    int[] kth(int[] ints, int k) {
        if (ints == null || ints.length <= 0 || k > ints.length || k <= 0)
            return null;
        if (k == ints.length)
            return ints;
        int start = 0;
        int end = ints.length - 1;
        int index = partition(ints, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(ints, start, end);
            } else {
                start = index + 1;
                index = partition(ints, start, end);
            }
        }
        int[] res = new int[k];
        for (int i = 0;i<k;i++){
            res[i] = ints[i];
        }
        return res;
    }

    private int partition(int[] input, int start, int end) {
        int low = start;
        int high = end;
        int temp = input[low];
        while (low < high) {
            while (low < high && temp <= input[high])
                high--;
            input[low] = input[high];
            while (low < high && temp >= input[low])
                low++;
            input[high] = input[low];
        }
        input[low] = temp;
        return low;
    }

    @Test
    public void test() throws Exception {
        int[] ints = {4, 5, 1, 6, 2, 7, 3, 8};
        eq(kth(ints, 4).length, 4);
        int[] k = kth(ints, 4);
        Arrays.sort(k);
        isTrue(Arrays.equals(k, new int[]{1, 2, 3, 4}));
    }
}
