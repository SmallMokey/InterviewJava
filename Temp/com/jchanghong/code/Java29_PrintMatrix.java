/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题29：顺时针打印矩阵
 * // 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.ArrayList;

public class Java29_PrintMatrix extends UtilAssert {
    //元素之间没有任何其他符号
    String print(int[][] ints) {
        if (ints == null)
            return null;
        //矩阵的行数、列数
        int rows = ints.length;
        int cols = ints[0].length;

        //保存输出字符串
        StringBuffer stringBuffer = new StringBuffer();
        int start = 0;

        while (rows > start * 2 && cols > start * 2) {
            stringBuffer.append(PrintMatrixInCricle(ints, cols, rows, start));
            start++;
        }


        return stringBuffer.toString();
    }

    private String PrintMatrixInCricle(int[][] ints, int cols, int rows, int start) {
        StringBuffer stringBuffer = new StringBuffer();

        //计算循环边界 endX,endY;
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        //从左向右扫描一行
        for (int i = start; i <= endX; i++)
            stringBuffer.append(ints[start][i]);

        //从上向下扫描一列，start < endY
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                stringBuffer.append(ints[i][endX]);
            }
        }

        //从右向左扫描一行，start < endX&&start < endY
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                stringBuffer.append(ints[endY][i]);
            }
        }

        //从下向上扫描，start < endX && start < endY -1
        if (start < endX && start < endY-1){
            for (int i = endY-1; i >= start+1 ; i--) {
                stringBuffer.append(ints[i][start]);
            }
        }
        return stringBuffer.toString();
    }

    @Test
    public void test() throws Exception {
        int[][] ints = {
                {1, 2},
                {3, 4}
        };
        eq(print(ints), "1243");
    }
}
