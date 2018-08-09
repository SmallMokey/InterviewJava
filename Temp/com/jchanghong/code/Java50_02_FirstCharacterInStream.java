/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * <p>
 * // 面试题50（二）：字符流中第一个只出现一次的字符
 * // 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从
 * // 字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字
 * // 符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
 */
package com.jchanghong.code;

import com.jchanghong.code.util.UtilAssert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Java50_02_FirstCharacterInStream extends UtilAssert {

    char first(Reader reader, int readNumber) {
        //使用hash表实现
        LinkedHashMap<Character, Integer> set = new LinkedHashMap<>();
        //遍历字节流中的字符，放入set中。key:字符 value:出现的次数
        for (int i = 0; i < readNumber; i++) {
            try {
                char c = (char) reader.read();
                if (set.containsKey(c)) {
                    int value = set.get(c);
                    set.put(c, value + 1);
                }else {
                    set.put(c,1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //遍历set,取出只出现一次的第一个字符
        for (Map.Entry<Character,Integer> node:set.entrySet()) {
            if (node.getValue() == 1){
                return node.getKey();
            }
        }
        return 0;
    }

    @Test
    public void test() throws Exception {
        Reader reader = new StringReader("google");
        eq(first(reader, 2), 'g');
        reader = new StringReader("google");
        eq(first(reader, 6), 'l');
    }
}
