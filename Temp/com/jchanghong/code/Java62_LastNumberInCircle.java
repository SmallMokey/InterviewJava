/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题62：圆圈中最后剩下的数字
 * // 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
 * // 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Java62_LastNumberInCircle {
    public int lastNumber(int[] ints, int m) {
        if (ints == null || ints.length <= 0 || m < 1)
            return -1;

        int last = 0;
        for (int i = 2; i <= ints.length; i++) {
            last = (last + m) % i;
        }

        return last;
    }

    @Test
    public void test() throws Exception {
        int[] ints = {0, 1, 2, 3, 4};
        Assert.assertEquals(lastNumber(ints, 3), 3);
    }
}

class Node {
    Node next = null;
    int data;

    public Node(int data) {
        this.data = data;
    }
}
