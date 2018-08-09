/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题36：二叉搜索树与双向链表
 * // 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求
 * // 不能创建任何新的结点，只能调整树中结点指针的指向。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import com.jchanghong.code.util.TreeUtil;
import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.Arrays;

public class Java36_ConvertBinarySearchTree extends UtilAssert {

    TreeNode convert(TreeNode head) {
        TreeNode pLastNodeList = null;
        convertNode(head,pLastNodeList);

        //返回头结点
        TreeNode pHeadOfList = pLastNodeList;
        while (pHeadOfList!= null && pHeadOfList.left!=null){
            pHeadOfList = pHeadOfList.left;
        }
        return pHeadOfList;
    }

    private void convertNode(TreeNode head, TreeNode pLastNodeList) {
        if (head == null)
            return;

        TreeNode pNode = head;
        if (pNode.left != null)
            convertNode(pNode.left,pLastNodeList);

        pNode.left = pLastNodeList;
        if (pLastNodeList!=null){
            pLastNodeList.right = pNode;
        }
        pLastNodeList = pNode;
        if (pNode.right!=null)
            convertNode(pNode.right,pLastNodeList);
    }

    @Test
    public void test() throws Exception {
        TreeNode node = TreeUtil.construct(Arrays.asList(2, 1, 3));
        isTrue(convert(node) == node.left);
    }
}
