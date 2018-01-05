package src.com.lz.offer;

/**
 * desc
 *
 * @author: liangzhen
 * @version: 1.0
 * @date: 2018-01-04
 * @since 1.8
 */

/**
 * 旋转数字的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转，输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素   如 1 2  3 4 5  旋转为  3 4 5  1 2  需要我们查找最小的元素
 * <p>
 * <p>
 * 分析：
 * 本题的前提已经排序了，那么我们最笨的办法应该就是顺序遍历了，这样的复杂度为O(N)
 * 但是我们忽略了一个特性，他的前提是已经排序了，即使旋转后，那么也会有局部行有序，那么我们
 * 需要充分使用它的这个特性，对于有序查找一个元素，我们可以想到的第一个方法就是二分法。没错
 * 这道题我们也可以使用二分法来解答
 * 思路：
 * 我们使用二分法的思想，先使用2个临时变量保存数组第一个数字和最后一个数字，然后我们寻找他们的中间元素，
 * 然后比较中间元素和第一个。最后一个元素的大小
 * if 中间>第一个元素  那么说明中间元素依旧位于第一个递增序列，那么将第一个指针移动到这个中间元素
 * if 中间<第二个元素  那么说明中间元素依旧位于第二个递增序列，那么将第二个指针移动到这个中间元素
 * <p>
 * 重复以上，直到他们2个指针相邻距离为1
 * <p>
 * 其实这个二分法的主要使用了 最小的元素和最大的元素相邻为1的距离 这个特性
 */
public class Code8 {

    public static void main(String arg[]) {
        int[] arrs = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println("ssss" + prinMinArray(arrs));
    }


    public static int prinMinArray(int[] arr) {
        //打印出这个数组的最小的元素
        int start = 0;
        int end = arr.length - 1;

        int mid;
        int mud = 0;
        while (arr[start] >= arr[end]) {
            if (end - start == 1) {
                //相邻了，那么end对应的元素就是我们想要
                mud = end;
                break;
            }
            mid = (start + end) / 2;
            if (arr[start] == arr[end] && arr[mid] == arr[start]) {
                //如果3个数字一样，那么我们就无法使用折半查找法了，只能顺序查找
                //因为3个数字一样，那么我们就没办法判断是移动第一个指针还是第二个指针
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] > mud) {
                        mud = arr[i];
                    }
                    return mud;
                }
            }
            if (arr[mid] >= arr[start]) {
                //那么mid 依旧属于第一个递增数组
                start = mid;
            } else if (arr[mid] <= arr[end]) {
                //那么mid 属于第二个递增数组
                end = mid;
            }
        }
        if (arr[start] < arr[end]) {
            return arr[start];
        } else {
            return arr[mud];
        }
    }
}
