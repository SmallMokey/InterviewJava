/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题14：剪绳子
 * // 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * // 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * // 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * // 时得到最大的乘积18。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

public class Java14_CuttingRope {
    //-1表示参数错误
    //动态规划
    public int max(int n) {
//        if (n < 2)
//            return -1;
//        if (n == 2)
//            return 1;
//        if (n == 3)
//            return 2;
//
//        int[] products = new int[n + 1];
//        products[0] = 0;
//        products[1] = 1;
//        products[2] = 2;
//        products[3] = 3;
//
//        int max = 0;
//
//        for (int i = 4;i<=n;++i){
//            max = 0;
//            for (int j =1;j<=n/2;j++){
//                int product = products[j]*products[n-j];
//                if (max < product)
//                    max = product;
//            }
//            products[i] = max;
//        }
//        return products[n];

        // 贪心算法
        if(n<2)
            return -1;
        if(n ==2)
            return 1;
        if (n == 3)
            return 2;

        int timesOf3 = n /3;
        if (n - timesOf3*3 ==1)
            timesOf3-=1;

        int timesOf2 = (n - timesOf3*3)/2;
        int max = (int) (Math.pow(3,timesOf3)*Math.pow(2,timesOf2));
        return max;
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(max(0), -1);
        Assert.assertEquals(max(-1), -1);
        Assert.assertEquals(max(4), 4);

    }
}
