package com.lz.offer;

/**
 * 题目三
 * 有2个数组，已经是排好序的，要求合并他们并依旧是排序的
 * <p>
 * 思路：
 * 从尾巴或者头部开始比较2个数组，然后分别复制到第三个数组
 */
public class Code3 {

    public static void main(String arg[]) {
        int[] a1={1,2,3,4,5,6,7,8,9};
        int[] b1={7,8,9,10};

        int[] c=two2one(a1,b1);
        for(int i:c)
            System.out.print(i+" ");
    }

    public static int[] two2one(int[] a, int[] b) {
        int[] arr = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                arr[k++] = b[j++];
            } else if (a[i] < b[j]) {
                arr[k++] = a[i++];
            } else {
                arr[k++] = a[i++];
                arr[k++] = b[j++];
            }
        }
        if (i >= a.length) {
            while (j < b.length) {
                arr[k++] = b[j++];

            }
        } else {
            while (i < a.length) {
                arr[k++] = a[i++];
            }
        }


        return arr;
    }

}
