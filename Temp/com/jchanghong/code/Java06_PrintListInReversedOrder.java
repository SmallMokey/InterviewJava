/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题6：从尾到头打印链表
 * // 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 */
package com.jchanghong.code;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Java06_PrintListInReversedOrder {
    private String s = "";
    public String print2String(Node head) {
        //栈的实现
//        Stack<Integer> stack = new Stack<>();
//        while (head !=null){
//            stack.push(head.values);
//            head=head.next;
//        }
//        String result= "";
//        while (!stack.empty()){
//            result +=stack.pop().toString();
//        }
        //递归实现
        Recursive(head);
        return s;
    }

    public void Recursive(Node head){
        if (head != null) {
            if (head.next != null) {
                print2String(head.next);
            }
            s += head.values;
        }
    }

    @Test
    public void test() throws Exception {
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        StringBuilder builder = new StringBuilder();
        builder.append(2 + "");
        builder.append(1);
        Assert.assertEquals(builder.toString(), print2String(head));
    }

    static class Node {
        public Integer values;
        public Node next;

        public Node(Integer values, Node next) {
            this.values = values;
            this.next = next;
        }
    }
}
