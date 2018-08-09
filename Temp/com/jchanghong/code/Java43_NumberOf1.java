/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题43：从1到n整数中1出现的次数
 * // 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如
 * // 输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java43_NumberOf1 extends UtilAssert {
    int numberOf1(int n) {
        if (n == 0)
            return 0;
        int count = 0;
        //以整数1，10,100等为划分的节点
        for (long i = 1; i <= n; i *= 10) {
            //分别对节点取整或者取余，如31241，i = 100 ,a = 312,b=24
            long a = n / i;
            long b = n % i;
            //n=31x41,有三种情况：
            // 31042，此时百位上1的数量为：a/10 * 100=3100 个 即x=0
            // 31242,此时百位上1的数量为：（a/10 + 1）* 100 = 3200个 即x = 2
            // 31142,此时百位上1的数量为： a/10 * 100 + (b+1) = 31042个 因为当x = 1时，百位数字为1，此时只有0-42时百位为1，其他情况0-99百位为1
            // 这里对a进行加8处理，若x >=2 则a+8 会产生进位
            if (a % 10 == 1) {
                count = count + (int)(a/10*i+b+1);
            }else {
                count = count + (int)((a+8)/10*i);
            }
        }
        return count;
    }

    @Test
    public void test() throws Exception {
        eq(numberOf1(12), 5);
        eq(numberOf1(10), 2);
    }
}
