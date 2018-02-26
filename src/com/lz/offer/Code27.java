package com.lz.offer;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一颗二叉树，和一个整树，请打印出该二叉树所有的路径和为整树的组合
 *  从根节点到叶子节点到路径
 *
 *
 *  分析：
 *      我们发现每次都从根节点开始遍历，那么我们就应该想到二叉树都前序遍历方式
 *
 *
 *          1
 *        2  3
 *      4  5 6 7
 *
 *
 *     1 2 4 5  3 6 7
 *     二叉树都遍历，都会遍历到叶子节点，那么就可以使用二叉树到前序遍历，进行查找
 *
 *
 *
 */
public class Code27 {
    static  class Node{
        Node right;
        Node left;
        int val;

        public Node(Node left, Node right, int val) {
            this.right = right;
            this.left = left;
            this.val = val;
        }
    }

    public static void main(String arg[]){
        Node n1=new Node(null,null,7);
        Node n2=new Node(null,null,6);
        Node n3=new Node(null,null,5);
        Node n4=new Node(null,null,4);
        Node n5=new Node(n2,n1,3);
        Node n6=new Node(n4,n3,2);
        Node n7=new Node(n6,n5,1);
//        prinNum(n7,8);
    }



    public  static void prinNum(Node node, int sum,Stack<Integer> stack,int curr){
            if(node==null) return ;
            curr+=node.val;
            stack.push(node.val);
            if(curr==sum&&node.right==null&&node.left==null){
                //输出stack栈所有元素
            }
            //每次遍历一个节点的时候，判断节点是否是符合条件的
                //如果符合就打印出栈中的所有元素
            //不符合，那么我们判断是否存在左右子树，然后分别遍历
            if(node.left!=null){
                prinNum(node.left,sum,stack,curr);
            }
            if(node.right!=null){
                prinNum(node.right,sum,stack,curr);
            }
            //当左右子树遍历完后，回退给节点，也就是说通过该节点当所有符合结果当可能全部完成
            curr=curr-node.val;
            stack.pop();

    }
}
