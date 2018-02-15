package src.com.lz.offer;

/**
 * desc
 *
 * @author: liangzhen
 * @version: 1.0
 * @date: 2018-01-31
 * @since 1.8
 */



/**
 *给出2个有序的链表，合并链表，并保持有序性。
 *
 *  分析：
 *       首先是2个链表都是有序的，我们把他们合并，我们的步骤是：
 *          1 先比较2个链表中的最大值、最小值，然后我们就可以选择出一个结点，那么这个节点就是
 *          我们合并后的链表中第一个结点，以此类推，我们把 剩余的结点在跟下一个比较，重复这样才操作。
 *          那么我们就可以使用递归进行排序
 *
 */
public class Code19 {


    class Node {
        Node next;
        int val;
    }

    public static  void mian(String arg[]){

    }


    public static Node merge(Node n1,Node n2){

        if(n1==null)
            return n2;
        if(n2==null)
            return n1;
        Node mergNode=null;
        if(n1.val>=n2.val){
            mergNode=n1;
            mergNode.next=merge(n1.next,n2);
        }else{
            mergNode=n2;
            mergNode.next=merge(n1,n2.next);
        }
        return mergNode;
    }



}
