package com.lz.offer;

import org.junit.Test;

/**
 * Created by Administrator on 2018/2/15.
 * <p>
 * <p>
 * 题目：
 * 给出一个二叉树，输出该树的镜像
 * <p>
 * 分析：
 * 通过我们画图分析，其实该题考察的就是左右子树的互换操作
 * <p>
 * 1                     1
 * 2    3             3     2
 * 4   5  6   7      7   6   5  4
 * <p>
 * 我们把除了头结点和叶子节点的其他节点都进行左右子树互换，就可以得出镜像
 * <p>
 * 所以我们可以使用前序遍历，遇到含有子树的结点，就把他的子树结点进行对换操作
 */
public class Code21 {

    static class Node {
        Node right;
        Node left;
        int val;


        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.right = n3;
        n1.left = n2;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        Node node = prinRes(n1);
        qianxubianlio(node);
    }

    private static void qianxubianlio(Node node) {
        if (node != null) {
            System.out.print(node.val);
            qianxubianlio(node.left);
            qianxubianlio(node.right);
        }

    }


    public static Node prinRes(Node root) {
        if (root.right != null || root.right != null) {
            //对换儿子结点
            Node temp = root.right;
            root.right = root.left;
            root.left = temp;
            prinRes(root.left);
            prinRes(root.right);
        }
        return root;
    }

}

