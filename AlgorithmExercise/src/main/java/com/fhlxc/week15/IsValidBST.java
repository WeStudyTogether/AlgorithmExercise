package com.fhlxc.week15;

import java.util.Stack;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月16日 上午9:55:26
* @classname IsValidBST
* @description 
* 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
* 假设一个二叉搜索树具有如下特征：
*     节点的左子树只包含小于当前节点的数。
*     节点的右子树只包含大于当前节点的数。
*     所有左子树和右子树自身必须也是二叉搜索树。
* 示例 1:
* 输入:
*     2
*    / \
*   1   3
* 输出: true
* 示例 2:
* 输入:
*     5
*    / \
*   1   4
*      / \
*     3   6
* 输出: false
* 解释: 输入为: [5,1,4,null,null,3,6]。
*      根节点的值为 5 ，但是其右子节点值为 4 。
*/

public class IsValidBST {
    
    private long findMax(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        long max = Long.MIN_VALUE;
        
        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (max < curr.val) {
                    max = curr.val;
                }
                curr = curr.right;
            }
        }
        
        return max;
    }
    
    private long findMin(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        long min = Long.MAX_VALUE;
        
        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (min > curr.val) {
                    min = curr.val;
                }
                curr = curr.right;
            }
        }
        
        return min;
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.empty()) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (findMax(curr.left) >= curr.val || findMin(curr.right) <= curr.val) {
                    return false;
                }
                curr = curr.right;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode tmp = root.left = null;
        tmp = root.right = new TreeNode(2);
        tmp.right = new TreeNode(3);
        tmp.left = new TreeNode(4);
        System.out.println(new IsValidBST().isValidBST(root));
    }

}
