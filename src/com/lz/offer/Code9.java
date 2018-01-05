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
 * 题目：
 *      跳台阶，一次可以跳1个 或者 2个，那么如果要跳N个抬价，有多少种跳法
 *
 * 分析：
 *      其实这道题，就是斐波那契数列， 假如我们第一次跳1个抬价，那么我们后面就有f(n-1)种跳法
 *      如果第一次跳2个，那么后面就有f(n-2)种
 *      那么f(n)=f(n-1)+f(n-2)
 *      其实一看这个表达式，它就是斐波那契数列
 *
 * 思路：
 *      解决斐波那契数列  可以使用 递归    也可以使用循环迭代
 *
 */
public class Code9 {
}
