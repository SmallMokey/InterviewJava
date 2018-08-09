/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题32（一）：不分行从上往下打印二叉树
 * // 题目：从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import com.jchanghong.code.util.TreeUtil;
import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Java32_01_PrintTreeFromTopToBottom extends UtilAssert {
    //元素之间没有任何其他符号。比如1,2 打印就是“12”
    String print(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer();
        if(node == null)
            return "";
        queue.offer(node);
        while (!queue.isEmpty()){
            TreeNode root = queue.poll();
            stringBuffer.append(root.values);
            if (root.left!=null){
                queue.offer(root.left);
            }
            if (root.right!=null){
                queue.offer(root.right);
            }
        }
        return stringBuffer.toString();
    }

    @Test
    public void test() throws Exception {
        TreeNode node = TreeUtil.construct2(1, 2, 3, 4, 5, 6, 7, 8);
        eq(print(node), "12345678");

    }
}
