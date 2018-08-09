/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题64：求1+2+…+n
 * // 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
 * // 等关键字及条件判断语句（A?B:C）。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.Const;
import org.junit.Assert;
import org.junit.Test;

public class Java64_Accumulate {
    public int sum(int n) {
        int temp = n;
        boolean flag = (n > 0) && ((temp += sum(n-1))>0);
        return temp;
    }

    @Test
    public void test() throws Exception {
        System.out.println(sumtest(10));
        System.out.println(sumtest(100));
        Const.integerList.forEach(a -> Assert.assertEquals(sumtest(a), sum(a)));
    }

    public int sumtest(int n) {
        return (1 + n) * n / 2;
    }
}
