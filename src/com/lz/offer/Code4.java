package com.lz.offer;

/**
 * 题目四
 * 将一个链表从尾到头打印
 * 1 可以使用栈实现倒叙打印
 * 2 递归（其实就是栈 只不过如果链表过长就会浪费资源
 *
 */
public class Code4 {
    static  class Node {
        Node next;
        int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }

    public static void main(String arg[]) {
        Node node=new Node(null,1);
        Node node1=new Node(node,2);
        Node node2=new Node(node1,3);
        Node node3=new Node(node2,4);
        Node node4=new Node(node3,4);
        Node node5=new Node(node4,5);
        printl1(node5);
    }

    public static void printl1(Node header) {
        if(header.next==null) {
            System.out.print(header.value);
            return;
        }
        printl1(header.next);
        System.out.print(header.value);
    }
}
