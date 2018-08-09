/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题60：n个骰子的点数
 * // 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s
 * // 的所有可能的值出现的概率。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class Java60_DicesProbability {
    // key is sum, v is pribity
    int g_maxValue = 6;

    public Map<Integer, Double> pribility(int n) {
        Map<Integer, Double> result = new LinkedHashMap<>();
        if (n < 1)
            return result;
        int[][] pProbabilities = new int[2][g_maxValue * n + 1];

        int flag = 0;
        //当n == 1时
        for (int i = 1; i <= g_maxValue; i++) {
            pProbabilities[flag][i] = 1;
        }
        //当n > 1时,每一轮增加一个骰子
        for (int k = 2; k <= n; k++) {
            //将第二个数组k之前的初始化,避免影响后面计算的值
            for (int i = 0; i < k; i++) {
                pProbabilities[1 - flag][i] = 0;
            }

            //sum取值范围：k - k*g_maxValue
            for (int s = k; s <= k * g_maxValue; s++) {
                pProbabilities[1 - flag][s] = 0;
                //和为sum，是sum-1,sum-2,...sum-g_maxValue，所有情况之和
                for (int i = 1; i < k && i <= g_maxValue; i++) {
                    pProbabilities[1 - flag][s] += pProbabilities[flag][s - i];
                }
            }
            flag = 1 - flag;
        }

        //全排列数
        double total = Math.pow(g_maxValue,n);
        for (int i = n; i <= g_maxValue*n; i++) {
            result.put(i,pProbabilities[flag][i]/total);
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        Map<Integer, Double> map = pribility(1);
        Assert.assertTrue(map.containsKey(6));
        Assert.assertTrue(map.get(6) == 1.0 / 6);
        map = pribility(2);
        Assert.assertTrue(map.containsKey(2));
        Assert.assertTrue(map.get(2) == 1.0 / 36);
    }
}
