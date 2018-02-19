package com.lz.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2018/2/15.
 * <p>
 * 题目：
 * 给出2个序列，判断第一个序列通过出入栈，是否满足第二个序列
 * <p>
 * 分析思路：
 * 每次我们压入栈中，然后判断栈顶元素和我们的弹出序列第一个对比，如果相同，则直接弹出，
 * 如果不相同，那么我们就从没有压入栈的中元素中继续压入，直到找到需要弹出的元素，如果
 * 全部元素都压入中都没有找到，那么就表示该序列不是该栈的弹出序列。
 */
public class Code24 {

    public static void main(String args[]) {
        List list1 = Arrays.asList(1, 2, 3, 4, 5);
        List list2 = Arrays.asList(5, 4, 3, 2, 1);
        System.out.println(isStackSerial(list1, list2));
    }

    public static boolean isStackSerial(List<Integer> ser1, List<Integer> ser2) {
        Stack<Integer> stack = new Stack<Integer>();

        if (ser1 != null && ser2 != null && ser1.size() == ser2.size()) {
            int x = ser1.size();
            int y = ser2.size();
            while (x - y < ser1.size()) {
                   while(stack.isEmpty()||stack.peek()!=ser1.get())
            }

        } else {

            return false;
        }
    }


}
