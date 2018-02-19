package com.lz.offer;

/**
 * Created by Administrator on 2018/2/15.
 * <p>
 * 题目：
 * 输入俩颗二叉树A,B。判断B是不是A的子结构
 * <p>
 * 思路：
 * 我们需要判断是否是子树，那么必须先确定头结点是否一致，如果头结点一致，那么就继续比较左右子树结构是否一致
 * 所以 总体思路就是： 1 先寻找A结点中B 的头结点一致的结点，然后如果一致，那么就比较他的子结构
 */
public class Code20 {

    class Node {
        Node left;
        Node right;
        int val;

    }

    public static boolean hasSubTree(Node root1, Node root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            //防止鲁莽操作，
            if (root1.val == root2.val) {
                result = isSubTree(root1, root2);
                if (!result)
                    result = hasSubTree(root1.right, root2);
                if (!result)
                    result = hasSubTree(root1.left, root2);

            }
        }
        return result;
    }

    private static boolean isSubTree(Node root1, Node root2) {
        if (root1 == null) return false;
        if (root2 == null) return true;
        if (root1.val != root2.val)
            return false;
        return isSubTree(root1.right, root2.right) && isSubTree(root1.left, root2.left);

    }

}
