package com.lz.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目五
 *  给定前序和中序遍历的顺序，请构建出完整的二叉树
 *
 *  思路：
 *      根据前序就可以确定下根节点
 *      根据中序就可以确定下左子数和右子树
 *      然后我们使用递归左子树 右子树来组建二叉树
 *          具体：
 *             根据前序和中序确定下 左子树的前序和中序，右子树的前序和中序，然后递归左右子树。
 *             这里需要明白一个点，就是不管你这个子树是整个还是局部，其实他的左右子树是确定的，不会变动的。
 *
 *
 */
public class Code5 {
    static class Node<T>{

        T val;
        Node<T> left;
        Node<T> right;

        public Node(T val, Node<T> left, Node<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public  static  void main(String []arg){
        Node n=new Node(1,null,null);
        Node n1=new Node(2,null,null);
        Node n2=new Node(3,null,null);
        List list=new ArrayList();
        list.add(n);
        list.add(n1);
        list.add(n2);
        List list1=new ArrayList();
        list1.add(n1);
        list1.add(n);
        list1.add(n2);
        getRoot(list,list1);
    }

    public static Node getRoot(List<Node> qian, List<Node> zh)
    {
        if(qian==null||zh==null) return null;
        //创建 root节点
        Node root=qian.get(0);
        root.left=root.right=null;
        int i=0;
        //获取到中序遍历中root到偏移量
        while(root!=zh.get(i))
            i++;
        //此时zh 0-i++就是左子树到中序遍历  i++--end 右子树到中序
       List stat= zh.subList(0,i);
       List end= zh.subList(i+1,zh.size());


       //截取左右到前序
        List start1=qian.subList(1,stat.size()+1);
        List end1=qian.subList(stat.size()+1,qian.size());

        //递归遍历
        if(stat.size()>0)
        root.right=getRoot(start1,stat);
        if(stat.size()<qian.size())
        root.right=getRoot(end1,end);
        return root;
    }

}
