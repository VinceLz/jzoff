package src.com.lz.offer;

/**
 * desc
 *
 * @author: liangzhen
 * @version: 1.0
 * @date: 2018-01-05
 * @since 1.8
 */

/**
 * 输入数字m,按顺序打印出从1到最大的N位十进制数，比如输入3，则打印1 2 3 .。。。999.
 * <p>
 * 思路：
 * 本题如果不考虑数字的溢出的话，就很简单了，但是题目没有不考虑，所以我们必须考虑
 * 溢出的情况，这样我们就不能使用基本类型来保存数字了，一般处理大数字的可以使用【】数组
 * 或者字符串
 * <p>
 * 我们使用字符串
 * 有N位，那么有N个字符，每个字符显示0-9的字符串，我们每次对第一位字符串+1，然后满10进一，依次类推，直到最后一位
 * 满10，我们只要判断最后一位是否进值，如果进值那么就达到了最大值，即可停止
 * <p>
 * 如果我们使用字符串来模拟的话，那么我们分析后，明白其实N位字符串，每个字符串都显示的是0-9这10个数字，我们用外层循环来控制
 * 字符串的位置，
 * <p>
 * ps  我们如何不使用语言的强制转换功能把字符数字转换位数字呢？
 * int x=y-'0'+number;
 * 将字符数字与'0'字符做差，然后+对应的数字即可转换
 */
public class Code13 {

    public  static void main(String args[]){
        Code13 code=new Code13();
        code.prin1_N(3);
    }

    public void prin1_N(int n) {

        if (n <= 0) {
            return;
        }

        char[] arr = new char[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = '0';
        }
        while (isNext(arr)) {
            printlnNext(arr);
        }


    }

    /**
     * 打印下一个值
     *
     * @param arr
     */
    private void printlnNext(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    /**
     * 判断是否已经到了边界并且计算+1
     *
     * @param arrs
     * @return 2    99    1-99 00  01  02 03 04
     */

    public boolean isNext(char[] arrs) {

            int jinwei=0;
        for (int i = arrs.length - 1; i >= 0; i--) {
            int num = Integer.valueOf(arrs[i]+"").intValue()+jinwei;
            if (i == arrs.length - 1) {
                //其实我们每次都是对个位进行++操作，执行完后，我们在遍历每个位置的数字，判断是否有满10的，如果有就进位
                num++;
            }
            if (num >= 10) {
                //进位 并判断是否是最后一位
                if (i == 0) {
                    //最后一位了，并且=10了那么到了边界了，不能进行+1
                    return false;
                } else {
                    //进位
                   jinwei=1;
                    arrs[i] = '0';
                }
            } else {
                //+1 操作
                jinwei=0;
                arrs[i] = (char) ('0' + num);
            }
        }
        return true;
    }


}
