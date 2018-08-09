/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题26：树的子结构
 * // 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

public class Java26_SubstructureInTree {
    public boolean issubTree(TreeNode head1, TreeNode head2) {
        boolean result = false;
        if (head1 != null && head2 != null) {
            if (head1.values == head2.values) {
                //子树比较
                result = DoesTree1HavaTree2(head1, head2);
            }
            if (!result) {
                result = issubTree(head1.left, head2);
            }
            if (!result) {
                result = issubTree(head1.right, head2);
            }
        }
        return result;
    }

    private boolean DoesTree1HavaTree2(TreeNode pRoot1, TreeNode pRoot2) {
        //子树判断结束
        if (pRoot2 == null)
            return true;
        //A树达到叶子节点
        if (pRoot1 == null)
            return false;

        if (pRoot1.values != pRoot2.values)
            return false;

        return DoesTree1HavaTree2(pRoot1.left, pRoot2.left) && DoesTree1HavaTree2(pRoot1.right, pRoot2.right);
    }

    @Test
    public void test() throws Exception {
        TreeNode head = new TreeNode(2, null, null);
        head.left = new TreeNode(1, null, null);
        head.right = new TreeNode(3, null, null);
        Assert.assertTrue(issubTree(head, head.left));
        Assert.assertTrue(issubTree(head, head.right));
    }
}
