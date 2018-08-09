/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题53（三）：数组中数值和下标相等的元素
 * // 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
 * // 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
 * // 1, 3, 5}中，数字3和它的下标相等。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Java53_03_IntegerIdenticalToIndex extends UtilAssert {
    public Set<Integer> numbers(int[] ints) {
        Set<Integer> number = new HashSet<>();
        if (ints == null || ints.length <= 0){
            return number;
        }
        int left = 0;
        int right = ints.length-1;
        while (left<=right){
            int middle = left +((right-left)>>1);
            if (ints[middle] == middle){
                number.add(middle);
                return number;
            }

            if (ints[middle] > middle){
                right = middle -1;
            }else {
                left = middle+1;
            }
        }
        return number;
    }

    @Test
    public void test() throws Exception {
        Set<Integer> integers = numbers(new int[]{-3, -1, 1, 3, 5});
        isTrue(integers.contains(3));
    }
}
