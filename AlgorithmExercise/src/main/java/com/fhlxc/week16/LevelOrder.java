package com.fhlxc.week16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月21日 上午11:41:54
* @classname LevelOrder
* @description 
* 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
* 示例：
* 二叉树：[3,9,20,null,null,15,7],
*     3
*    / \
*   9  20
*     /  \
*    15   7
* 返回其层次遍历结果：
* [
*   [3],
*   [9,20],
*   [15,7]
* ]
*/

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        int n = 0;
        
        while (!queue.isEmpty()) {
            
            n = queue.size();
            
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                root = queue.remove();
                list.add(root.val);
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            result.add(list);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode tmp = root.left = null;
        tmp = root.right = new TreeNode(2);
        tmp.right = new TreeNode(3);
        tmp.left = new TreeNode(4);
        System.out.println(new LevelOrder().levelOrder(root));
    }

}
