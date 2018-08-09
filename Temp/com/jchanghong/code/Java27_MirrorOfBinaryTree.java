/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题27：二叉树的镜像
 * // 题目：请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.LinkNode;
import com.jchanghong.code.util.TreeNode;
import com.jchanghong.code.util.TreeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Java27_MirrorOfBinaryTree {
    public TreeNode mirror(TreeNode head) {
        MirrorTree(head);
        return head;
    }

    private void MirrorTree(TreeNode head){
        //递归方式
//        if (head == null)
//            return;
//        if (head.left == null && head.right == null)
//            return;
//
//        TreeNode pTemp = head.left;
//        head.left = head.right;
//        head.right = pTemp;
//
//        if (head.left != null)
//            MirrorTree(head.left);
//        if (head.right != null)
//            MirrorTree(head.right);

        //非递归方式
        if (head == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        if (!queue.isEmpty()){
            TreeNode root = queue.poll();
            if (root.left != null && root.right!=null){
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
            if (root.left != null)
                queue.offer(root.left);
            if (root.right != null)
                queue.offer(root.right);
        }
    }
    @Test
    public void test() throws Exception {
        TreeNode head = TreeUtil.construct(Arrays.asList(1, 2, 3));
        TreeNode h1 = TreeUtil.construct(Arrays.asList(1, 3, 2));
        Assert.assertTrue(TreeUtil.valuesEqual(head, mirror(h1)));

    }
}
