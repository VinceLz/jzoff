package src.com.lz.offer;

/**
 * desc
 *
 * @author: liangzhen
 * @version: 1.0
 * @date: 2018-01-17
 * @since 1.8
 */

/**
 * 题目：
 * 输入一个整数数组，实现一个函数来调整该数组中的数组中的数字顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的   后半部分
 * <p>
 * <p>
 * 方法1：
 * 遍历扫描整个数组，如果遇到偶数，就把这个偶数的后面的所有数字向前移动一位，然后把这个偶数补到数组尾巴 O(N2)
 * <p>
 * 方法2
 * 我们可以使用类似快排的2个指针，左边的第一个指针向右移动，右边的向左移动， 当第一个正在遇到偶数，第二个指针遇到奇数
 * 那么就交换他们
 *
 *
 * 大的框架就是左移动，有移动，判断符合条件进行交换，那么我们就可以扩展下，我们把比较是否符合的抽象成一个函数，然后
 * 又用户传入这个函数，这样，就可以实现更多的用户，不仅仅奇偶问题了
 *  这就是问题的抽象
 */
public class Code15 {

    public static void main(String args[]) {
        int arr[] = {2, 3, 5, 4, 8, 7, 9, 10, 3, 5,2,5};
        prinOrder(arr);
    }

    public static void prinOrder(int[] arr) {

        if (arr.length == 0) {
            return;
        }
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }

        int left = 0;
        int right = arr.length - 1;
        int temp = 0;
        while (right - left > 1) {
            if ((arr[left] & 0X1) == 0) { //偶数
                //如果左边是偶数了，那么移动右边的指针
                while ((arr[right] & 0X1) != 1) {
                    right--;
                }
                //交换他们
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
            }
            left++;
        }

        for (int i : arr) {
            System.out.print(i + "---");
        }

    }
}
