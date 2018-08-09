/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题68：树中两个结点的最低公共祖先
 * // 题目：输入两个树结点，求它们的最低公共祖先。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class Java68_CommonParentInTree {

    public TreeNode parent(TreeNode head, TreeNode node1, TreeNode node2) {
        if (head == null || node1 == null || node2 == null)
            return null;
        //获得根节点到目标节点的路径
        LinkedList<TreeNode> path1 = new LinkedList<>();
        LinkedList<TreeNode> path2 = new LinkedList<>();
        getNodePath(head, node1, path1);
        getNodePath(head, node2, path2);
        //处理转换的链表
        return getLastCommontNode(path1, path2);
    }

    private TreeNode getLastCommontNode(LinkedList<TreeNode> path1, LinkedList<TreeNode> path2) {
        TreeNode pLast = null;
        while (!path1.isEmpty() && !path2.isEmpty()) {
            if (path1.peekLast() == path2.peekLast()){
                pLast = path2.pollLast();
            }
            path1.pollLast();
            path2.pollLast();
        }
        return pLast;
    }

    private boolean getNodePath(TreeNode head, TreeNode node, LinkedList<TreeNode> path) {
        if (head == null)
            return false;
        if (head == node)
            return true;

        path.add(head);
        //在左子树寻找
        boolean right = false;
        boolean left = false;
        left = getNodePath(head.left, node, path);
        if (!left) {
            right = getNodePath(head.right, node, path);
        }
        if (!left && !right) {
            path.pollLast();
            return false;
        }
        return true;
    }

    @Test
    public void test() throws Exception {
        TreeNode head = new TreeNode(1, null, null);
        head.left = new TreeNode(2, null, null);
        TreeNode left = new TreeNode(3, null, null);
        head.left.left = left;
        TreeNode right = new TreeNode(4, null, null);
        head.left.right = right;
//        TreeUtil.print(head);
        Assert.assertTrue(parent(head, right, left) == head.left);

    }
}
