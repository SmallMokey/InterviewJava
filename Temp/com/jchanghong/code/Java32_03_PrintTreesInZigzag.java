/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题32（三）：之字形打印二叉树
 * // 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺
 * // 序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
 * // 其他行以此类推。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import com.jchanghong.code.util.TreeUtil;
import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Java32_03_PrintTreesInZigzag extends UtilAssert {
    //一个元素代表一行，元素之间不加任何符号。
    List<String> print(TreeNode head) {
        List<String> list = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        if (head == null)
            return null;
        stack1.push(head);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) { //stack1保存奇数层节点，先保存左孩子再保存右孩子
                while (!stack1.isEmpty()) {
                    head = stack1.pop();
                    stringBuffer.append(head.values);
                    if (head.left!=null)
                        stack2.push(head.left);
                    if (head.right!=null)
                        stack2.push(head.right);
                }
                list.add(stringBuffer.toString());
                stringBuffer.setLength(0);
            } else { //stack2保存偶数层节点，下层元素，先保存右孩子再保存左孩子
                while (!stack2.isEmpty()){
                    head = stack2.pop();
                    stringBuffer.append(head.values);
                    if (head.right!=null)
                        stack1.push(head.right);
                    if (head.left!=null)
                        stack1.push(head.left);
                }
                list.add(stringBuffer.toString());
                stringBuffer.setLength(0);
            }
        }
        return list;
    }

    @Test
    public void test() throws Exception {
        TreeNode head = TreeUtil.construct2(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        List<String> list = print(head);
        eq(list.size(), 4);
        eq(list.get(0), "1");
        eq(list.get(1), "32");
        eq(list.get(2), "4567");
        eq(list.get(3), "15141312111098");
    }
}
