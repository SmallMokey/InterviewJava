/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题52：两个链表的第一个公共结点
 * // 题目：输入两个链表，找出它们的第一个公共结点。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.LinkNode;
import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

public class Java52_FirstCommonNodesInLists extends UtilAssert {
    LinkNode parent(LinkNode f1, LinkNode f2) {
        //计算两个链表的长度
        int nLengthF1 = getLinkLength(f1);
        int nLengthF2 = getLinkLength(f2);

        int nLengthDif = nLengthF1 - nLengthF2;
        LinkNode pListHeadLong = f1;
        LinkNode pListHeadShort = f2;
        if (nLengthF2 - nLengthF1 > 0) {
            pListHeadLong = f2;
            pListHeadShort = f1;
            nLengthDif = nLengthF2 - nLengthF1;
        }

        //先从长链表移动指针
        for (int i = 0; i < nLengthDif; i++) {
            pListHeadLong = pListHeadLong.next;
        }

        while (pListHeadLong != null && pListHeadShort != null && pListHeadLong != pListHeadShort) {
            pListHeadLong = pListHeadLong.next;
            pListHeadShort = pListHeadShort.next;
        }

        //获得第一个公共点
        LinkNode pFirstCommonNode = pListHeadLong;

        return pFirstCommonNode;
    }

    private int getLinkLength(LinkNode head) {
        int nLength = 0;
        LinkNode pNode = head;
        while (pNode != null) {
            nLength++;
            pNode = pNode.next;
        }
        return nLength;
    }

    @Test
    public void test() throws Exception {
        LinkNode l1 = new LinkNode(1, null);
        l1.next = new LinkNode(2, null);
        l1.next.next = new LinkNode(3, null);
        LinkNode l2 = new LinkNode(4, l1.next);
        isTrue(parent(l1, l2) == l1.next);
    }
}
