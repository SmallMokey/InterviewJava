/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题57（二）：为s的连续正数序列
 * // 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * // 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
 * // 4～6和7～8。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Java57_02_ContinuousSquenceWithSum extends UtilAssert {
        public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> list = new ArrayList<>();
            if (sum < 3)
                return result;
            int small = 1;
            int big = 2;
            list.add(small);
            list.add(big);
            int middle = (sum+1) >> 1;
            int curSum = small + big;
            while (small < middle) {
                if (curSum == sum) {
                    result.add(new ArrayList<Integer>(list));
                }
                //序列和大于sum，增加small
                while (small < middle && curSum > sum) {
                    curSum -= small;
                    small++;
                    list.remove(0);
                    if (curSum == sum) {
                        result.add(new ArrayList<Integer>(list));
                    }
                }

                //序列和小于sum,增加big
                big++;
                curSum += big;
                list.add(big);
            }
            return result;
        }

    @Test
    public void test() throws Exception {
        FindContinuousSequence(9);
    }

    static class Pair {
        public int start = 0;
        public int end = 0;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + "->" + end;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (obj instanceof Pair) {
                Pair o = (Pair) obj;
                return o.start == start && o.end == end;
            } else
                return false;
        }

        @Override
        public int hashCode() {
            return toString().hashCode();
        }
    }
}
