/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题37：序列化二叉树
 * // 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.TreeNode;
import com.jchanghong.code.util.TreeUtil;
import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.Arrays;

public class Java37_SerializeBinaryTrees extends UtilAssert {

    int index = -1;
    String serialize(TreeNode head) {
        if(head == null)
            return "";
        StringBuffer stringBuffer = new StringBuffer();
        serialize2(head,stringBuffer);
        return stringBuffer.toString();
    }

    private void serialize2(TreeNode head, StringBuffer stringBuffer) {
        if (head == null){
            stringBuffer.append("#,");
            return;
        }

        stringBuffer.append(head.values);
        stringBuffer.append(',');
        serialize2(head.left,stringBuffer);
        serialize2(head.right,stringBuffer);
    }

    TreeNode deSerize(String string) {
        if (string.length() == 0){
            return null;
        }
        String str[] = string.split(",");
        return deSerize2(str);
    }

    private TreeNode deSerize2(String[] str) {
        index++;
        if (!str[index].equals("#")){
            TreeNode pRoot = new TreeNode(0,null,null);
            pRoot.values = Integer.parseInt(str[index]);
            pRoot.left = deSerize2(str);
            pRoot.right = deSerize2(str);
            return pRoot;
        }
        return null;
    }

    @Test
    public void test() throws Exception {
        TreeNode head = TreeUtil.construct(Arrays.asList(1, 2, 3, 4, 5, 6));
        String s = serialize(head);
        TreeNode h2 = deSerize(s);
        isTrue(TreeUtil.valuesEqual(head, h2));
    }
}
