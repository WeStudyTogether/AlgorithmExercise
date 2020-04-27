package com.fhlxc.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月27日 下午2:22:05
* @classname SortedArrayToBST
* @description 
* 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
* 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
* 示例:
* 给定有序数组: [-10,-3,0,5,9],
* 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
*       0
*      / \
*    -3   9
*    /   /
*  -10  5
*/

public class SortedArrayToBST {

    private void help(TreeNode root, int i, int j, int[] nums, boolean direction) {
        if (i > j) {
            return;
        }
        TreeNode r;
        int x = (i + j) / 2;
        if (direction) {
            r = root.left = new TreeNode(nums[x]);
        } else {
            r = root.right = new TreeNode(nums[x]);
        }
        help(r, i, x - 1, nums, true);
        help(r, x + 1, j, nums, false);
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int x = (0 + nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[x]);
        help(root, 0, x - 1, nums, true);
        help(root, x + 1, nums.length - 1, nums, false);
        return root;
    }
    
    public static void main(String[] args) throws IOException {
        String[] ns = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        TreeNode.inorderIte(new SortedArrayToBST().sortedArrayToBST(nums));
    }

}
