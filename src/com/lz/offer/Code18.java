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
 * 反转一个链表，给出一个链表的头结点，反转整个链表
 *
 * 分析：  1 2  3
 *  1 先获取第一个结点的下一个结点，保存起来pnext
 *
 *      Node node
 *      Node pnext=node.next;
 *
 *      if(pnext==null) //到了尾巴
 *      phead=pnext;
 *
 *      node.next=plast;  plast是我们定义好的，null,第一次进行plast就是null 正好就是把头变成尾巴
 *      plast=node;     //核心的是这2句， 当前node结点保存下来，变成人家的next,然后把node.next 赋值给node 也就是向前移动
 *      node=pnext;
 *
 *
 *      node
 *
 *      Node pnext=node.next;
 *      if(pnext==null)
 *      phead=pnext;
 *
 *      p.next=plast;
 *
 *      plast=node;
 *      node=pnext;
 *
 *
 */
public class Code18 {

}
