/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题23：链表中环的入口结点
 * // 题目：一个链表中包含环，如何找出环的入口结点？例如，在图3.8的链表中，
 * // 环的入口结点是结点3。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.LinkListUtil;
import com.jchanghong.code.util.LinkNode;
import org.junit.Assert;
import org.junit.Test;

public class Java23_EntryNodeInListLoop {
    public LinkNode entrynode(LinkNode head) {
        //判断链表是否有环
        LinkNode meetingNode = MeetingNode(head);
        if (meetingNode == null)
            return null;

        //环中节点的数量
        int nodesInLoop = 1;
        LinkNode pNode1 = meetingNode;
        while (pNode1.next != meetingNode){
            pNode1 = pNode1.next;
            nodesInLoop++;
        }

        //环的入口节点,设置两个指针，一个向前走nodesInLoop步，第二个个指针开始移动，相遇时即为入口
        pNode1 = head;
        for (int i = 0; i < nodesInLoop ; i++) {
            pNode1 = pNode1.next;
        }
        LinkNode pNode2 = head;
        while (pNode1!=pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }

    //先判断链表中是否有环
    private LinkNode MeetingNode(LinkNode head) {
        if (head == null)
            return null;

        LinkNode pSlow = head.next;
        if (pSlow == null)
            return null;
        LinkNode pFast = pSlow.next;
        while (pSlow != null && pFast != null) {
            if (pSlow == pFast)
                return pFast;
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null)
                pFast = pFast.next;
        }
        return null;
    }

    @Test
    public void test() throws Exception {
        LinkNode head = LinkListUtil.construct(1, 2, 3, 4);
        LinkNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head.next;
        Assert.assertEquals(entrynode(head), head.next);
    }
}
