/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题55（一）：二叉树的深度
 * // 题目：输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
 * // 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import com.jchanghong.code.util.TreeUtil;
import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.Arrays;

public class Java55_01_TreeDepth extends UtilAssert {
    public int treeDepth(TreeNode head) {
        //若树为空，在树的高度为1
        if (head == null){
            return 0;
        }
        //计算左子树和右子树的高度
        int nLeft = treeDepth(head.left);
        int nRight = treeDepth(head.right);
        //树的深度为，左子树和右子树中较大的一个加一
        return (nLeft>nRight)?(nLeft+1):(nRight+1);
    }

    @Test
    public void test() throws Exception {
        TreeNode node = TreeUtil.construct(Arrays.asList(1, 2, 3));
        eq(treeDepth(node), 2);
        node = TreeUtil.construct(Arrays.asList(1, 2, 3, 4));
        eq(treeDepth(node), 3);
    }
}
