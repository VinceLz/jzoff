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
 * 题目 输入一个数字，判断它的二进制的1有多少个
 * <p>
 * 思路:
 * 我们可以通过右移来截取最后一位，那么我们如何获取是否为1呢，其实我们只要右移后与1 进行与运算，判断是否为0来
 * 判断是否为1
 * <p>
 * 总结：对于二进制，我们可以多使用位运算来计算
 * 位运算：
 * 左移
 * 右移
 * 与
 * 或
 * 非
 * 异或
 * 在这里需要注意几个点：
 * 1 我们使用了右移1位 其实它和除以2 是等价的，但是位运算性能是最好的 所以实际编程中尽量使用位运算
 * 2 如果我们的是负数，那么重复右移，那么最终就会变成 OXFFFFFFF  继而变成死循环，所以对于负数，我们可以变个思路：
 * 我们把1 进行左移，然后继续与数字进行与运算，
 * <p>
 * <p>
 * 方法1 和方法2 都是都是同一种思路，但是对于2个算法，缺点是 如果数字二进制位数比较多的话，那么循环将很多次，效率不高
 * 方法3 的 效率很高，其实它的主要思想是： 对于一个二进制的数  -1 后，它就会把最靠右边的1变成了0，然后它后面的所有的0变成了1
 * 然后我们把-1 后的数字与之前的数字进行与运算后，就得到了是把最靠右边的1 变成0 其他位置的数字不变的结果。
 * 经过这么一次运算后我们就把最靠右的1的数字变成了0，重复上述操作，就依次可以把1 全变成0 ，那么我们统计运算的次数，就可以计算出结果
 */

public class Code10 {

    public static void main(String ar[]) {
        System.out.println(check(9));
    }

    public static int check(int num) {
        int coun = 0;
        while (num > 0) {
            if ((num & 1) > 0) {
                //是1
                coun++;
            }
            num = num >> 1;
        }
        return coun;
    }

    public static int check2(int num) {
        int coun = 0;
        int falh = 1;

        while (falh > 0) {
            if ((num & falh) > 0) {
                coun++;
            }
            falh = falh << 1;
        }
        return coun;
    }

    public static int check3(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = (num - 1) & num;
        }
        return count;
    }
}
