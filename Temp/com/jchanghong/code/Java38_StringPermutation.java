/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题38：字符串的排列
 * // 题目：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，
 * // 则打印出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.util.HashSet;
import java.util.*;

public class Java38_StringPermutation extends UtilAssert {
    Set<String> allString(String text) {
        Set<String> strings = new HashSet<>();
        if(text == null || text.length() == 0){
            return strings;
        }
        char[] chars = text.toCharArray();
        //TreeSet保证元素不重复
        TreeSet<String> temp = new TreeSet<>();
        Permutation(chars,0,temp);
        strings.addAll(temp);
        return strings;
    }

    private void Permutation(char[] chars, int begin, TreeSet<String> result) {
        if(chars == null || chars.length == 0 || begin < 0 || begin>chars.length -1)
            return;
        //到达字符末尾，输出
        if(begin == chars.length - 1){
            result.add(String.valueOf(chars));
        }else{
            //从begin位置开始交换每个元素
            for(int i = begin;i<=chars.length-1;i++){
                //交换元素
                swap(chars,begin,i);
                Permutation(chars,begin+1,result);
                //还原
                swap(chars,begin,i);
            }
        }
    }
    private void swap(char[] x,int a,int b){
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }


    @Test
    public void test() throws Exception {
        Set<String> strings = allString("abc");
        eq(strings.size(), 6);
        isTrue(strings.contains("acb"));

    }
}
