/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题56（一）：数组中只出现一次的两个数字
 * // 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
 * // 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Java56_01_NumbersAppearOnce extends UtilAssert {
    List<Integer> two(int[] ints) {
        List<Integer> list = new LinkedList<>();
        if (ints == null || ints.length < 2)
            return list;

        //数组中元素依次与
        int resultExclusiveOR = 0;
        for (int i = 0; i < ints.length; i++) {
            resultExclusiveOR ^= ints[i];
        }
        //从右开始找到一个为1的位置
        int indexOf1 = findFirstBitIs1(resultExclusiveOR);
        //将原数组分成两部分，每部分包含一个只出现一次的数
        int num1 = 0, num2 = 0;
        for (int i = 0; i < ints.length; i++) {
            if (isBit1(ints[i], indexOf1)) {
                num1 ^= ints[i];
            } else {
                num2 ^= ints[i];
            }
        }
        list.add(num1);
        list.add(num2);
        return list;
    }

    private boolean isBit1(int number, int indexOf1) {
        boolean flag = false;
        number = number >> indexOf1;
        if ((number & 1) == 1)
            flag = true;
        return flag;
    }

    private int findFirstBitIs1(int number) {
        int indexBit = 0;
        while (((number & 1) == 0) && indexBit < 8) {
            number = number >> 1;
            indexBit++;
        }
        return indexBit;
    }

    @Test
    public void test() throws Exception {
        int[] ints = {1, 2, 3, 4, 2, 3};
        List<Integer> list = two(ints);
        eq(list.size(), 2);
        isTrue(list.contains(1));
        isTrue(list.contains(4));

    }
}
