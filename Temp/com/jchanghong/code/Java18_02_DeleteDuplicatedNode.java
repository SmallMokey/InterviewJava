/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题18（二）：删除链表中重复的结点
 * // 题目：在一个排序的链表中，如何删除重复的结点？例如，在图3.4（a）中重复
 * // 结点被删除之后，链表如图3.4（b）所示。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.LinkListUtil;
import com.jchanghong.code.util.LinkNode;
import org.junit.Assert;
import org.junit.Test;

public class Java18_02_DeleteDuplicatedNode {

    public LinkNode removeDeplicated(LinkNode head) {
        if (head==null)
            return null;
        LinkNode pPreNode = null;
        LinkNode pNode = head;
        while (pNode!=null){
            LinkNode pNext = pNode.next;
            boolean needDelete = false;
            if (pNext!=null&&(pNode.values.equals(pNext.values))){
                needDelete = true;
            }
            //不需要删除
            if (!needDelete){
                pPreNode = pNode;
                pNode = pNode.next;
            }else {
                //需要删除
                int value = pNode.values;
                //定义删除节点，遍历删除重复元素
                LinkNode toBeDeleted = pNode;
                while (toBeDeleted!=null&&(toBeDeleted.values.equals(value))){
                    toBeDeleted=toBeDeleted.next;
                }
                //头结点被删除
                if (pPreNode == null){
                    head = toBeDeleted;
                }else {
                    pPreNode.next =toBeDeleted;
                }
                pNode = toBeDeleted;
            }
        }
        return head;
    }

    @Test
    public void test() throws Exception {
        LinkNode linkNode = LinkListUtil.construct(1, 2, 3, 4);
        Assert.assertTrue(LinkListUtil.equels(linkNode, removeDeplicated(linkNode)));
        LinkNode linkNode2 = LinkListUtil.construct(1, 2, 2, 3, 4);
        LinkNode linkNode3 = LinkListUtil.construct(1, 3, 4);
        Assert.assertTrue(LinkListUtil.equels(removeDeplicated(linkNode2), linkNode3));
    }
}
