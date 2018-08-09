/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题53（一）：数字在排序数组中出现的次数
 * // 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
 * // 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java53_01_NumberOfK extends UtilAssert {
    int number(int[] ints, int number) {
        //出现次数
        int count = 0;
        if (ints != null && ints.length >= 0) {
            int first = getFirst(ints, number, 0, ints.length - 1);
            int last = getLast(ints, number, 0, ints.length - 1);

            if (first > -1 && last > -1) {
                count = last - first + 1;
            }
        }
        return count;
    }

    //得到k最小位置
    private int getFirst(int[] ints, int number, int start, int end) {
        //递归终止条件.k值不存在
        if (start > end) {
            return -1;
        }
        int middleIndex = start + ((end - start) >> 1);
        if (ints[middleIndex] == number) {
            //中间值等于k值，判断前一个元素是否为k
            if ((middleIndex > 0 && ints[middleIndex - 1] != number) || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
        } else if (ints[middleIndex] > number) {
            end = middleIndex - 1;
        } else {
            start = middleIndex + 1;
        }
        return getFirst(ints, number, start, end);
    }

    //得到k最大位置
    private int getLast(int[] ints, int number, int start, int end) {
        if (start > end) {
            return -1;
        }
        int middleIndex = start + ((end - start) >> 1);
        if (ints[middleIndex] == number) {
            if ((middleIndex < ints.length - 1 && ints[middleIndex + 1] != number) || middleIndex == ints.length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
        } else if (ints[middleIndex] < number) {
            start = middleIndex + 1;
        } else {
            end = middleIndex - 1;
        }
        return getLast(ints, number, start, end);
    }


    @Test
    public void test() throws Exception {
        int[] ints = {1, 2, 3, 3, 3, 3, 4, 5};
        eq(number(ints, 3), 4);
    }
}
