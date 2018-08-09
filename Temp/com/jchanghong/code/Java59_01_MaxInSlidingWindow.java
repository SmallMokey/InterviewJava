/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题59（一）：滑动窗口的最大值
 * // 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
 * // 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
 * // 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Java59_01_MaxInSlidingWindow {
    public int[] maxs(int[] number, int size) {
        int[] result = new int[number.length - size + 1];
        if (number == null || number.length < size || size < 0) {
            return result;
        }
        //滑动窗口大小为1
        if (size == 1) {
            for (int i = 0; i < number.length; i++) {
                result[i] = number[i];
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        //队列中存放的下标
        queue.add(0);
        for (int i = 1; i < number.length; i++) {
            int value = number[i];
            //新添加的元素比队列中的元素大，则将队列中元素出队
            if (value > number[queue.peekLast()]) {
                while (!queue.isEmpty() && value > number[queue.peekLast()]) {
                    queue.pollLast();
                }
            }
            queue.add(i);
            //当前处理元素的下标和队列中第一个元素的下标差大于size,则出队
            if (i - queue.peek() >= size) {
                queue.poll();
            }
            //取出滑动窗口中最大的数
            if (i + 1 >= size) {
                result[i-size+1] = number[queue.peek()];
            }
        }

        return result;
    }

    @Test
    public void test() throws Exception {
        int[] ints = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        Assert.assertTrue(Arrays.equals(maxs(ints, size), new int[]{4, 4, 6, 6, 6, 5}));
    }
}
