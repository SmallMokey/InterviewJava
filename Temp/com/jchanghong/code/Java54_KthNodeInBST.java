/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题54：二叉搜索树的第k个结点
 * // 题目：给定一棵二叉搜索树，请找出其中的第k大的结点。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import com.jchanghong.code.util.TreeUtil;
import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.Arrays;

public class Java54_KthNodeInBST extends UtilAssert {
    private int k = 0;
    TreeNode kth(TreeNode head, int k) {
        if (head == null||k==0 )
            return null;
        int[] count = new int[1];
        count[0] = k;
        return kthNode(head,count);
    }

    private TreeNode kthNode(TreeNode head, int[] k) {
        TreeNode targrt = null;
        if (head.left!=null){
            targrt = kthNode(head.left,k);
        }

        if (targrt == null){
            if (k[0] == 1)
                targrt = head;
            k[0]--;
        }
        if (targrt ==null&&head.right !=null){
            targrt= kthNode(head.right,k);
        }
        return targrt;
    }

    @Test
    public void test() throws Exception {
        TreeNode head = TreeUtil.construct(Arrays.asList(2, 1, 3));
        isTrue(kth(head, 1) == head.left);
        isTrue(kth(head, 2) == head);
        isTrue(kth(head, 3) == head.right);
    }
}
