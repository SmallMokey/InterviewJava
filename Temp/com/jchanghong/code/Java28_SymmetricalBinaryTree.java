/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题28：对称的二叉树
 * // 题目：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和
 * // 它的镜像一样，那么它是对称的。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import com.jchanghong.code.util.TreeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Java28_SymmetricalBinaryTree {
    public boolean isSym(TreeNode head) {
        return isSym(head, head);

    }

    private boolean isSym(TreeNode root1, TreeNode root2) {
        //判断条件
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.values != root2.values)
            return false;
        //考虑先序遍历和对称先序遍历，两者相同则是对称的
        return isSym(root1.left, root2.right) && isSym(root1.right, root2.left);
    }

    @Test
    public void test() throws Exception {
        TreeNode head = TreeUtil.construct(Arrays.asList(1, 2, 2));
        TreeNode h1 = TreeUtil.construct(Arrays.asList(1, 3, 2));
        Assert.assertTrue(isSym(head));
        Assert.assertFalse(isSym(h1));

    }
}
