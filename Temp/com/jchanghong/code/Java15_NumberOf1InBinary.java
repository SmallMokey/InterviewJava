/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题15：二进制中1的个数
 * // 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。例如
 * // 把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

public class Java15_NumberOf1InBinary {
    public int number(int n) {
        int count = 0;
        //第一种 可能死循环
//        while (n!=0){
//            if ((n & 1)!=0)
//                count++;
//            n = n >>1;
//        }

        //第二种
//        int flag = 1;
//        while (flag!=0){
//            if((n&flag)!=0)
//                count++;
//            flag = flag <<1;
//        }
        //第三种
        while (n!=0){
            count++;
            n = n & (n-1);
        }
        return count;
    }

    @Test
    public void test() throws Exception {
        //9-1001
        //8-1000
        //7-111
        Assert.assertEquals(number(9), 2);
        Assert.assertEquals(number(8), 1);
        Assert.assertEquals(number(-7), 30);
    }
}
