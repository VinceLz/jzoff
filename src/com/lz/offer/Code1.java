package com.lz.offer;


/**
 * 面试题一
 * 二维数组中查找
 * 在一个二维数组中，每一行都按照从左到右递增顺序排序，每一行都按照从上到下递增到顺序排序，请完成一个函数
 * 输入这样一个二维数组和一个整数，判断数组中是否含有该整数
 * 1   2   8    9
 * 2   4   9   12
 * 4   7   10  13
 * 6   8   11  15
 * <p>
 * 思想：
 * 查找一个数，我们可以随机选取一个数选择，但是选择的这个位置必须是只有2条路，
 * 而且这2条路必须一个趋向大，一个趋向小，这样才能移动，所以分析后，我们只能选取左下脚
 * 和右上角这2条路才能移动。。。
 *
 * 总结：
 *  数组的特性是他有2个属性，下标和值。所以我们可以利用数组的连续性进行移动。
 */
public class Code1 {

    public static void main(String args[]) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        findNum(array,3);


    }


    public static  int findNum(int[][] arr, int target) {

        int row = arr.length-1;
        int col = arr[0].length-1;
        int col_c = 0;
        int number = arr[row][col_c];//默认是左下角

        while (number != target) {

            if (number > target) {
                if((row-1)<0) {
                    System.out.println("没有该数据");
                    return -1;
                }
                number = arr[row - 1][col_c];
                row=row-1;
            } else {
                if((col_c+1)>col){
                    System.out.println("没有该数据");
                    return -1;

                }
                number = arr[row][col_c + 1];
                col_c=col_c+1;
            }
        }
        System.out.println(number);
        return number;
    }

}
