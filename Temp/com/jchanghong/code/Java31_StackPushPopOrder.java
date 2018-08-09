/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题31：栈的压入、弹出序列
 * // 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
 * // 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
 * // 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
 * // 4、3、5、1、2就不可能是该压栈序列的弹出序列。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.Stack;

public class Java31_StackPushPopOrder extends UtilAssert {
    boolean popOrder(int[] push, int[] pop) {
        boolean bPossible = false;

        if (push != null && pop != null && push.length == pop.length && pop.length > 0) {
            int nlength = push.length;
            //辅助栈
            Stack<Integer> stack = new Stack<>();
            int pNextPush=0, pNextPop = 0;
            //根据出栈顺序弹出元素
            while (pNextPop < nlength){
                //栈为空或栈顶元素不等于弹出元素，压栈
                while (stack.isEmpty()||stack.peek()!=pop[pNextPop]){
                    if (pNextPush == nlength)
                        break;
                    //压栈
                    stack.push(push[pNextPush]);
                    pNextPush++;
                }

                if (stack.peek()!=pop[pNextPop]){
                    break;
                }

                stack.pop();
                pNextPop++;
            }
            if (stack.isEmpty()&&pNextPop==nlength){
                bPossible = true;
            }
        }
        return bPossible;
    }

    @Test
    public void test() throws Exception {
        int[] ints1 = {1, 2, 3, 4, 5};
        int[] ints2 = {4, 5, 3, 2, 1};
        int[] ints3 = {4, 3, 5, 1, 2};
        isTrue(popOrder(ints1, ints2));
        isFalse(popOrder(ints1, ints3));
    }
}
