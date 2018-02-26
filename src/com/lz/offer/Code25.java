package com.lz.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 从上往下打印二叉树
 *  同层次的从左到右
 *
 *
 *  分析：
 *      其实就是二叉树到层次遍历。其实就是可以使用队列进行遍历 也叫做广度遍历
 *
 */
public class Code25 {

    static  class Node{
        Node left;
        Node right;
        int val;
        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

//        1
//    2     3
// 4    5  6   7
    public  static  void main(String args[]){


        Node n1=new Node(null,null,7);
        Node n2=new Node(null,null,6);
        Node n3=new Node(null,null,5);
        Node n4=new Node(null,null,4);
        Node n5=new Node(n2,n1,3);
        Node n6=new Node(n4,n3,2);
        Node n7=new Node(n6,n5,1);
        prinTree(n7);
    }




    public  static  void prinTree(Node node){

        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node n=queue.poll();
            System.out.println(n.val);
            if(n.left!=null){
                queue.add(n.left);
            }
            if(n.right!=null){
                queue.add(n.right);
            }

        }

    }


}
