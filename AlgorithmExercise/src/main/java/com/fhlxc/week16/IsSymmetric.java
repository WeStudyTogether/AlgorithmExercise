package com.fhlxc.week16;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月20日 下午2:36:21
* @classname IsSymmetric
* @description 
* 给定一个二叉树，检查它是否是镜像对称的。
* 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
*     1
*    / \
*   2   2
*  / \ / \
* 3  4 4  3
* 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
*     1
*    / \
*   2   2
*    \   \
*    3    3
*/

public class IsSymmetric {

    private boolean same(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        return (left.val == right.val) && same(left.left, right.right) && same(left.right, right.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        return same(root.left, root.right);
    }
    
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(1);
    }

}
