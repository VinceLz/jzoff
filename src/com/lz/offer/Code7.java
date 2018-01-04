package src.com.lz.offer;

/**
 * desc
 *
 * @author: liangzhen
 * @version: 1.0
 * @date: 2018-01-03
 * @since 1.8
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * code 6  使用了2个栈实现了队列的功能，那么反过来，我们也可以使用2个队列模拟栈的功能
 *
 *
 * 思路： 其实一样，队列是先进先出，那么反过来，不就是先进后出，说白了就是使用2个队列来跌倒他们的顺序
 *  当我们按顺序入队列，这时候想要删除最后一个元素，我们需要 先出队，并顺序入队到第二个队列，当第一个队列剩余
 *  一个元素了，我们就把他出队并删除（其实就是出栈） 。那么此时如果又有元素入栈，那么我们就把元素入到第二个队列中，
 *  如果此时先出队，重复上述操作，先把元素出队并入另外一个队列，剩余一个，并删除。
 */
public class Code7 {

    static Queue<Object> queue1=new LinkedList<>();
    static Queue<Object> queue2=new LinkedList<>();



}
