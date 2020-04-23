package com.fhlxc.week16;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月23日 上午11:23:41
* @classname MaxDepth
* @description 
* 给定一个二叉树，找出其最大深度。
* 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
* 说明: 叶子节点是指没有子节点的节点。
* 示例：
* 给定二叉树 [3,9,20,null,null,15,7]，
*     3
*    / \
*   9  20
*     /  \
*    15   7
* 返回它的最大深度 3 。
*/

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode tmp = root.left = null;
        tmp = root.right = new TreeNode(2);
        tmp.right = new TreeNode(3);
        tmp.left = new TreeNode(4);
        tmp = root.left = new TreeNode(5);
        tmp.right = new TreeNode(6);
        tmp.left = new TreeNode(7);
        System.out.println(new MaxDepth().maxDepth(root));
    }

}
