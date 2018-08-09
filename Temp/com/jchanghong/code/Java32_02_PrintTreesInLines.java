/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题32（二）：分行从上到下打印二叉树
 * // 题目：从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层
 * // 打印到一行。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import com.jchanghong.code.util.TreeUtil;
import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Java32_02_PrintTreesInLines extends UtilAssert {
    //一个元素代表一行，元素之间不加任何符号。
    List<String> print(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<String> list = new LinkedList<>();
        StringBuffer stringBuffer = new StringBuffer();

        if (head == null)
            return null;
        queue.offer(head);
        int nextLevel = 0;
        int toBePrint = 1;
        while (!queue.isEmpty()){
            head = queue.poll();
            toBePrint--;
            stringBuffer.append(head.values);
            if (head.left != null){
                queue.offer(head.left);
                nextLevel++;
            }
            if (head.right!=null){
                queue.offer(head.right);
                nextLevel++;
            }
            if (toBePrint == 0){
                list.add(stringBuffer.toString());
                stringBuffer.setLength(0);
                toBePrint = nextLevel;
                nextLevel = 0;
            }

        }
        return list;
    }

    @Test
    public void test() throws Exception {
        TreeNode head = TreeUtil.construct2(1, 2, 3);
        List<String> list = print(head);
        eq(list.size(), 2);
        eq(list.get(0), "1");
        eq(list.get(1), "23");
    }
}
