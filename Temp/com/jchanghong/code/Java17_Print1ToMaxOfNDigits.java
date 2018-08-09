/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题17：打印1到最大的n位数
 * // 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则
 * // 打印出1、2、3一直到最大的3位数即999。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Java17_Print1ToMaxOfNDigits {
    public List<String> from1ToN(int n) {
        if (n <= 0)
            return null;
        List<String> list = new ArrayList<>();
        char[] number = new char[n];
//        for (int i = 0; i <n ; i++) {
//            number[i] ='0';
//        }
//        while (!Increment(number)) {
//            list.add(PrintNumber(number));
//        }
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            PrintToMaxOfNDigitsRecursively(list, number, n, 0);
        }
        return list;
    }

    private void PrintToMaxOfNDigitsRecursively(List<String> list, char[] number, int length, int index) {
        if (index == length - 1) {
            if (!String.valueOf(PrintNumber(number)).equals(""))
                list.add(String.valueOf(PrintNumber(number)));
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            PrintToMaxOfNDigitsRecursively(list, number, length, index + 1);
        }
    }

    private String PrintNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        String numbers = "";
        for (int i = 0; i < nLength; i++) {
            if (isBeginning0 && number[i] != '0')
                isBeginning0 = false;
            if (!isBeginning0) {
                numbers += String.valueOf(number[i]);
            }
        }
        return numbers;
    }

    private boolean Increment(char[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1)
                nSum++;
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    @Test
    public void test() throws Exception {
        List<String> list = from1ToN(3);
        Assert.assertEquals(list.get(998), "999");
        list = from1ToN(6);
        Assert.assertEquals(list.get(999998), "999999");
        Assert.assertEquals(list.get(0), "1");
    }
}
