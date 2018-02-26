package com.lz.offer;

import java.util.Stack;

/**
 * 输入一个数组。。判断该数组是否可能是某个二叉树都后序输出序列  二叉树有性质的
 * <p>
 * <p>
 * 分析：
 * 首先我们要明白，后续是如何遍历到。
 * 左 右  根
 * 其实就是我们考到如何对二叉树进行后序遍历
 * 对于二叉树有三种遍历方式
 * 前序
 * 后序
 * 中序
 * 这3种方式都有递归和非递归都方式
 * 我们就来复习下非递归方式的遍历
 * <p>
 *      1
 *   2     3
 * 4  5  6   7
 *
 * 回到改题目上，我们要判断是否是二叉树的后序遍历，那么
 *  我们可以得知该数组的最后一个元素是根节点
 *  然后左边小于该节点的都是左子树
 *  大于该节点都是右子树
 *
 *  如
 *       5 7 6  9 11 10 8
 *     8是根节点，那么很明显 576是左子树 9 11 10是右子树
 *     那么接下来，我们就使用递归，5 7 6 其实又是以6为根节点的二叉树
 *     所以该题使用递归很简单实现
 *
 */

public class Code26 {


    static class Node {
        Node left;
        Node right;
        int val;

        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

        public static void printFore(Node node) {
            /**
             * 前序遍历，使用栈来实现
             */
            Stack<Node> stack = new Stack<>();
            while (node != null || !stack.isEmpty()) {
                if (node != null) {
                    //打印该node节点
                    stack.push(node);
                    node = node.left;
                } else {
                    node=stack.pop();
                    node=node.right;
                }
            }
        }
    }

    public static void prinOrder(Node node){
        /**
         * 中序遍历
         *  也可以使用栈来实现模拟
         */
        Stack<Node> stack=new Stack();
        while(node!=null||!stack.isEmpty()){
            if(node!=null){
               stack.push(node);
               node=node.left;
            }else{
                node=stack.pop();
                //打印node
                node=node.right;
            }
        }
    }
    public static void postOrder_Stack(Node root){//后续遍历
        /**
         * 其实这里，我们使用来栈实现来前序遍历，
         *  前序遍历  根 左右
         *  后序遍历  左右根
         *  发现规律没，其实就是 把前序遍历改成 根 右 左 然后放在栈里，跌倒后，就成来 左右根
         */
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> output = new Stack<Node>();//构造一个中间栈来存储逆后续遍历的结果
        Node node = root;
        while(node != null || stack.size()>0){
            if(node != null){
                output.push(node);
                stack.push(node);
                node = node.right;
            }else{
                node = stack.pop();
                node = node.left;
            }
        }

        while(output.size()>0){
            //printNode(output.pop());
        }

    }

    public static  boolean isRight(int [] arr,int lenght){
        if(arr==null||arr.length==0) return false;
        int root=arr[lenght-1];//根节点
        //搜索左子树的区间下标
        int x=0;
        for(int i=0;i<lenght-1;i++){
            if(root>arr[i])
              x=i;
        }
        int y=0;
        for(int k=x;k<lenght-1;k++){
            if(root>arr[k])
                return false;
        }

        //已经得到左右子树的区间 0-x   x+1 -y

        boolean left=true;
        if(x>0){
            left=isRight(arr,x);
        }

        boolean right=true;
        if(x<lenght-1){
            right=isRight(arr,lenght-x-1);
        }
        return right&left;
    }
}
