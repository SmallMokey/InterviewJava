/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题39：数组中出现次数超过一半的数字
 * // 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * // 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * // 出现了5次，超过数组长度的一半，因此输出2。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java39_MoreThanHalfNumber extends UtilAssert {
    //-1表示错误
    boolean g_bInputInvlid = false;

    int half(int[] ints) {
        //输入错误处理
        if (ints == null || ints.length<=0){
            return -1;
        }
        int result = ints[0];
        int times = 1;
        for (int i = 1; i < ints.length ; i++) {
            if (times == 0){
                result = ints[i];
                times = 1;
            }else if(result == ints[i]){
                times++;
            }else {
                times--;
            }
        }
        if(!checkMoreThanHalf(ints,result)){
            return -1;
        }
        return result;
    }

    private boolean checkMoreThanHalf(int[] ints,int result){
        int times = 0;
        for (int i = 0; i < ints.length ; i++) {
            if (result == ints[i])
                times++;
        }
        boolean isMoreThanHalf = true;
        if (times*2 <= ints.length){
            g_bInputInvlid = true;
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }

    @Test
    public void test() throws Exception {
        eq(half(new int[]{1, 2, 3, 4}), -1);
        int[] ints = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        eq(half(ints), 2);
    }
}
