/**
 * package com.jchanghong.code;
 * // 面试题3（一）：找出数组中重复的数字
 * // 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * // 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * // 那么对应的输出是重复的数字2或者3。
 */
package com.jchanghong.code;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Java03_01_DuplicationInArray {

    //计算在区间中元素的个数
    private int countRange(int[] ints, int length, int start, int end) {
        if (ints == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (ints[i] >= start && ints[i] <= end) {
                count++;
            }
        }
        return count;
    }

    private int findDuplication(int[] ints) {
        /*
         * 使用二分法查找数组中是否有重复的元素
         * N长度的数组，数组中元素的取值范围为0到n-1
         * */
        int length = ints.length;
        if (ints == null || length <= 0) {
            return -1;
        }
        //使用二分法
        int start = 1;
        int end = length - 1;
        while (start <= end) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(ints, length, start, middle);
            if (end == start) {
                if(count>1)
                    return start;
                else
                    break;
            }
            if (count > (middle - start + 1))
                end = middle;
            else
                start = middle + 1;
        }

//        if (ints == null || ints.length <= 0) {
//            return -1;
//        }
//        for (int i = 0; i < ints.length; i++) {
//            if (ints[i] < 0 || ints[i] > ints.length - 1) {
//                return -1;
//            }
//        }
//        StringBuffer stringBuffer=new StringBuffer();
//        for (int i = 0; i < ints.length; i++) {
//            stringBuffer.append(ints[i]+"");
//        }
//        for (int i = 0; i <ints.length ; i++) {
//            if(stringBuffer.indexOf(ints[i]+"") != stringBuffer.lastIndexOf(ints[i]+"")){
//                return ints[i];
//            }
//        }
//        for (int i = 0; i < ints.length; i++) {
//            while (ints[i] != i) {
//                if (ints[i] == ints[ints[i]]) {
//                    return ints[i];
//                }
//                int tmp = ints[i];
//                ints[i] = ints[tmp];
//                ints[tmp] = tmp;
//            }
//        }
        return -1;
    }


    @Test
    public void findDuplication() throws Exception {
        Java03_01_DuplicationInArray java03_01_duplicationInArray=new Java03_01_DuplicationInArray();
        int[] ints1 = new int[]{1, 2, 3, 4, 5, 2};
        assertEquals(2, java03_01_duplicationInArray.findDuplication(ints1));
        ints1 = new int[]{2, 3, 4, 5, 1, 1, 2, 1};
        List<Integer> list = Arrays.asList(2, 1);
        assertEquals(list.contains(java03_01_duplicationInArray.findDuplication(ints1)), true);
    }
}
