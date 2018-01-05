package src.com.lz.offer;

/**
 * desc
 *
 * @author: liangzhen
 * @version: 1.0
 * @date: 2018-01-03
 * @since 1.8
 */

import java.util.Stack;

/**
 * 使用2个栈实现队列，请实现2个函数appendTail 和 deleteHead 分别完成在队列尾部插入节点和队列头部删除节点的功能
 * <p>
 * 思路： 使用2个栈实现一个队列的比较容易，队列的特性时先进先出  ，栈的特性时先进后出，那么我们把栈反过来，那么不就时先进先出了
 */
public class Code6 {
    static Stack<Object> stack1 = new Stack<>();
    static Stack<Object> stack2 = new Stack<>();

    public static void appendTail(Object o) {
        stack1.push(o);
    }

    public static  void main(String arg[]){
        appendTail(1 );
        appendTail(2);


        System.out.println(deleteHead());
        appendTail(3);
        appendTail(4);
        System.out.println(deleteHead());
        System.out.println(deleteHead());
        System.out.println(deleteHead());
    }


    public static Object deleteHead() {
        if (stack2.size() == 0) {
            if(stack1.size()==0){
                return null;
            }
            //需要把stat1的所有元素出站，并顺序进入stat2的中
            while(stack1.size()>0) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else{
            //直接出站
            return stack2.pop();
        }
    }
}
