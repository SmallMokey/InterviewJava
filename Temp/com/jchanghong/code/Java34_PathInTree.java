/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题34：二叉树中和为某一值的路径
 * // 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
 * // 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import com.jchanghong.code.util.TreeUtil;
import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Java34_PathInTree extends UtilAssert {
    /*
    如下的路径有“12”和“13”
    *       1

      2            3
    * */
    List<String> list = new LinkedList<>();
    List<String> path(TreeNode head, int target) {
        StringBuffer stringBuffer = new StringBuffer();
        if (head == null)
            return null;
        int sum = 0;
        findPath(head, target, stringBuffer, sum);
        return list;
    }

    private void findPath(TreeNode head, int target, StringBuffer stringBuffer, int sum) {
        if (head == null)
            return;
        sum += head.values;
        stringBuffer.append(head.values);
        //判断是否是叶子节点且target=sum
        if (head.left == null && head.right == null) {
            //sum == target ,保存路径，回退
            if (sum == target){
                list.add(stringBuffer.toString());
            }
            //删除当前元素
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
            return;
        }
        findPath(head.left,target,stringBuffer,sum);
        findPath(head.right,target,stringBuffer,sum);
        //都没有找到，回退，路径中删除当前元素
        stringBuffer.deleteCharAt(stringBuffer.length()-1);
    }

    @Test
    public void test() throws Exception {
        TreeNode head = TreeUtil.construct2(10, 5, 12, 4, 7);
//        TreeUtil.print2(head);
        List<String> list = path(head, 22);
        eq(list.size(), 2);
        isTrue(list.contains("1012"));
        isTrue(list.contains("1057"));

    }
}
