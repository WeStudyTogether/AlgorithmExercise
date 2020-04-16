package com.fhlxc.mylove;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* @author Xingchao Long
* @date 2020年4月13日 上午10:11:57
* @classname TreeNode
* @description 
*/

public class TreeNode {
    
    public int val;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int x) { 
        val = x; 
    }
    
    public static void inorderTra(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTra(root.left);
        System.out.print(root.val + " ");
        inorderTra(root.right);
    }
    
    public static void preorderTra(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTra(root.left);
        preorderTra(root.right);
    }
    
    public static void postorderTra(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTra(root.left);
        postorderTra(root.right);
        System.out.print(root.val + " ");
    }
    
    public static void inorderIte(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }
    
    public static void preorderIte(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.print(curr.val + " ");
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                curr = curr.right;
            }
        }
    }
    
    public static void postorderIte(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode curr = root;
        int i = 0;
        list.add(curr);
        int n = list.size();
        while (i < n) {
            curr = list.get(i);
            if (curr.right != null) {
                list.add(curr.right);
                n++;
            }
            if (curr.left != null) {
                list.add(curr.left);
                n++;
            }
            i++;
        }
        for (i = n - 1; i >= 0; i--) {
            System.out.print(list.get(i).val + " ");
        }
    }
    
}
