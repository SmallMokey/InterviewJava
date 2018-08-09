/**
 * //==================================================================
 * // ����ָOffer�����������Թپ������ͱ���⡷����
 * // ���ߣ��κ���
 * //==================================================================
 * <p>
 * // ������30������min������ջ
 * // ��Ŀ������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�min
 * // �������ڸ�ջ�У�����min��push��pop��ʱ�临�Ӷȶ���O(1)��
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.Stack;

public class Java30_MinInStack extends UtilAssert {

    @Test
    public void test() throws Exception {
        MyStack myStack = new MyStack();
        myStack.push(1);
        eq(myStack.min(), 1);
        eq(myStack.pop(), 1);
        myStack.push(2);
        myStack.push(3);
        eq(myStack.min(), 2);
        myStack.pop();
        eq(myStack.min(), 2);
    }

    //实现下面3个函数
    static class MyStack {
        Stack<Integer> m_data = new Stack<>();
        Stack<Integer> m_min = new Stack<>();

        public void push(int i) {
            m_data.push(i);
            if (m_min.isEmpty()||i<m_min.peek()){
                m_min.push(i);
            }else {
                m_min.push(m_min.peek());
            }
        }

        public int pop() {
            //从辅助栈和数据栈同时弹出一个元素
            int temp = m_data.pop();
            m_min.pop();
            return temp;
        }

        public int min() {
            int min = -1;
            //数据栈和辅助栈不为空则取出栈顶元素
            if (!m_data.isEmpty() && !m_min.isEmpty())
                min = m_min.peek();
            return min;
        }

    }
}
