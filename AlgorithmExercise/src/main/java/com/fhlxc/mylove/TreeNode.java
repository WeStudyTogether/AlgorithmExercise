package com.fhlxc.mylove;

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
        System.out.print(root.val + " ");
        inorderTra(root.left);
        inorderTra(root.right);
    }
    
}
