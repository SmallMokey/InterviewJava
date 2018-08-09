/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题61：扑克牌的顺子
 * // 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * // 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Java61_ContinousCards {
    //0是王
    public boolean continous(int[] cards) {
        if (cards == null || cards.length < 1 || cards.length > 5)
            return false;

        //1 排序
        Arrays.sort(cards);

        //2 统计0的个数
        int numberOfZero = 0;
        int numberOfGap = 0;

        for (int i = 0; i < cards.length && cards[i] == 0; i++) {
            numberOfZero++;
        }

        //3.统计纸牌中空缺的个数
        int small = numberOfZero;
        int big = small + 1;
        while (big < cards.length) {
            if (cards[small] == cards[big])
                return false;

            numberOfGap += cards[big] - cards[small] - 1;
            small = big;
            big++;
        }

        return (numberOfGap > numberOfZero) ? false : true;
    }

    @Test
    public void test() throws Exception {

        int[] ints = {2, 3, 4, 5, 6};
        Assert.assertTrue(continous(ints));
        ints = new int[]{10, 11, 12, 13, 0};
        Assert.assertTrue(continous(ints));
        ints = new int[]{10, 11, 12, 0, 0};
        Assert.assertTrue(continous(ints));
        ints = new int[]{10, 11, 2, 0, 0};
        Assert.assertFalse(continous(ints));

    }
}
