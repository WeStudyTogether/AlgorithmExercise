package com.fhlxc.week15;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月13日 上午10:03:29
* @classname InorderTraversal
* @description 
* 给定一个二叉树，返回它的中序 遍历。
* 示例:
* 输入: [1,null,2,3]
*    1
*     \
*      2
*     /
*    3
*/

public class InorderTraversal {

    private List<Integer> result = new ArrayList<>();
    
    private void recursive(TreeNode node) {
        if (node == null) {
            return;
        }
        recursive(node.left);
        result.add(node.val);
        recursive(node.right);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        recursive(root);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode tmp = root.left = null;
        tmp = root.right = new TreeNode(2);
        tmp.right = new TreeNode(3);
        tmp.left = new TreeNode(4);
        System.out.println(new InorderTraversal().inorderTraversal(root));
        TreeNode.preorderIte(root);
        TreeNode.preorderTra(root);
        System.out.println();
        TreeNode.postorderIte(root);
        TreeNode.postorderTra(root);
        System.out.println();
        TreeNode.inorderIte(root);
        TreeNode.inorderTra(root);
    }

}
