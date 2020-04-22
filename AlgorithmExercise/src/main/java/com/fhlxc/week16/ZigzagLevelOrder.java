package com.fhlxc.week16;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月22日 下午3:18:45
* @classname ZigzagLevelOrder
* @description 
* 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
* 例如：
* 给定二叉树 [3,9,20,null,null,15,7],
*     3
*    / \
*   9  20
*     /  \
*    15   7
* 返回锯齿形层次遍历如下：
* [
*   [3],
*   [20,9],
*   [15,7]
* ]
*/

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        stack.add(root);
        int n = 0;
        boolean direction = true;
        
        while (!stack.isEmpty() || !stack2.isEmpty()) {
            
            if (direction) {
                n = stack.size();
            } else {
                n = stack2.size();
            }
            
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                if (direction) {
                    TreeNode tmp = stack.pop();
                    list.add(tmp.val);
                    if (tmp.left != null) {
                        stack2.add(tmp.left);
                    }
                    if (tmp.right != null) {
                        stack2.add(tmp.right);
                    }
                } else {
                    TreeNode tmp = stack2.pop();
                    list.add(tmp.val);
                    if (tmp.right != null) {
                        stack.add(tmp.right);
                    }
                    if (tmp.left != null) {
                        stack.add(tmp.left);
                    }
                }
            }
            result.add(list);
            direction = !direction;
        }
        
        return result;
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
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));
    }

}
