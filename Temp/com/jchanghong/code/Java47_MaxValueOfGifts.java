/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题47：礼物的最大价值
 * // 题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值
 * // （价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或
 * // 者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计
 * // 算你最多能拿到多少价值的礼物？
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java47_MaxValueOfGifts extends UtilAssert {
    int max(int[][] gift) {
        if (gift == null || gift.length<=0)
            return 0;
        int rows = gift.length;
        int cols = gift[0].length;
        int[] maxValues = new int[cols];
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                //初始化left,up
                int left = 0;
                int up = 0;
                if (i>0){
                    up = maxValues[j];
                }
                if (j >0){
                    left = maxValues[j-1];
                }
                //更新maxValues[j]
                maxValues[j]=Math.max(up,left)+gift[i][j];
            }
        }
        return maxValues[cols-1];
    }

    @Test
    public void test() throws Exception {
        int[][] ints = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        eq(max(ints), 53);
    }
}
