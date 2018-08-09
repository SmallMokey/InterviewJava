/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题24：反转链表
 * // 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 * // 头结点。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.LinkListUtil;
import com.jchanghong.code.util.LinkNode;
import org.junit.Assert;
import org.junit.Test;

public class Java24_ReverseList {
    public LinkNode reverseList(LinkNode head) {
        //递归法
//        LinkNode pHead = head;
//        return In_reverseList(pHead);

        //非递归
        LinkNode pNode = head;
        LinkNode pPreNode = null;
        LinkNode pNext = null;
        while (pNode != null) {
            pNext = pNode.next;
            if (pNext == null)
                 head = pNode;

            pNode.next = pPreNode; // 连接反转
            pPreNode = pNode;
            pNode = pNext;
        }
        return head;
    }

    private LinkNode In_reverseList(LinkNode H) {
        if (H == null || H.next == null) { //H.next == null 递归终止条件
            return H;
        }
        LinkNode newHead = In_reverseList(H.next); //循环到链表最后
        H.next.next = H;  // 反转链表
        H.next = null; // 置空，反转指针混乱
        return newHead;
    }

    @Test
    public void test() throws Exception {
        LinkNode head = LinkListUtil.construct(1, 2, 3, 4, 5, 6);
        LinkNode h2 = LinkListUtil.construct(6, 5, 4, 3, 2, 1);
        Assert.assertTrue(LinkListUtil.equels(reverseList(head), h2));
    }
}
