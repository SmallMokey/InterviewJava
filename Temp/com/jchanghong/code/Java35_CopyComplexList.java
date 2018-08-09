/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题35：复杂链表的复制
 * // 题目：请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复
 * // 制一个复杂链表。在复杂链表中，每个结点除了有一个m_pNext指针指向下一个
 * // 结点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import javax.print.attribute.standard.NumberUp;

public class Java35_CopyComplexList extends UtilAssert {
    Node copy(Node head) {
        cloneNodes(head);
        connectSiblingNodes(head);
        return reconnectNodes(head);
    }

    //1、复制原始链表的每个节点，用pNext连接起来
    private void cloneNodes(Node head) {
        Node pNode = head;
        while (pNode != null) {
            Node pCloneNode = new Node(0,null,null);
            pCloneNode.v = pNode.v;
            pCloneNode.left = pNode.left;
            pCloneNode.other = null;

            pNode.left = pCloneNode;
            pNode = pCloneNode.left;
        }
    }

    //2.设置复制后新节点的other指向
    private void connectSiblingNodes(Node head){
        Node pNode = head;
        while (pNode != null){
            Node pCloneNode = pNode.left;
            if (pNode.other!=null){
                pCloneNode.other = pNode.other.left;
            }

            pNode = pCloneNode.left;
        }
    }

    //3.分离两个链表
    private Node reconnectNodes(Node head){
        Node pNode = head;
        Node pCloneHead = null;
        Node pCloneNode = null;

        if (pNode != null){
            pCloneHead = pCloneNode = pNode.left;
            //拆分
            pNode.left = pCloneNode.left;
            pNode = pCloneNode.left;
        }

        while (pNode!= null){
            pCloneNode.left = pNode.left;
            pCloneNode = pNode.left;
            pNode.left = pCloneNode.left;
            pNode = pCloneNode.left;
        }
        return pCloneHead;
    }

    @Test
    public void test() throws Exception {
        Node hed = new Node(1, null, null);
        hed.left = new Node(2, null, null);
        hed.left.left = new Node(3, null, null);
        hed.other = hed.left.left;
        Node copy = copy(hed);
        eq(copy.v, hed.v);
        eq(copy.other.v, hed.other.v);
    }

    static class Node {
        public int v;
        public Node left;
        public Node other;

        public Node(int v, Node left, Node other) {
            this.v = v;
            this.left = left;
            this.other = other;
        }
    }
}
