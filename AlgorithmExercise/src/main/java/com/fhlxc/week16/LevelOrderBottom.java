package com.fhlxc.week16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月26日 下午5:08:15
* @classname LevelOrderBottom
* @description 
* 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
* 例如：
* 给定二叉树 [3,9,20,null,null,15,7],
*     3
*    / \
*   9  20
*     /  \
*    15   7
* 返回其自底向上的层次遍历为：
* [
*   [15,7],
*   [9,20],
*   [3]
* ]
*/

public class LevelOrderBottom {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                list.add(tmp.val);
            }
            stack.add(list);
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode tmp = root.left = null;
        tmp = root.right = new TreeNode(2);
        tmp.right = new TreeNode(3);
        tmp.left = new TreeNode(4);
        System.out.println(new LevelOrderBottom().levelOrderBottom(root));
    }

}
