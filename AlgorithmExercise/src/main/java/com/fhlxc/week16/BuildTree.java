package com.fhlxc.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月24日 下午3:38:15
* @classname BuildTree
* @description 
* 根据一棵树的前序遍历与中序遍历构造二叉树。
* 注意:
* 你可以假设树中没有重复的元素。
* 例如，给出
* 前序遍历 preorder = [3,9,20,15,7]
* 中序遍历 inorder = [9,3,15,20,7]
* 返回如下的二叉树：
*     3
*    / \
*   9  20
*     /  \
*    15   7
*/

public class BuildTree {
    
    private int[] pre;
    private int[] in;

    private void travel(TreeNode root, int i, int j, int i1, int j1, boolean direction) {
            TreeNode r;
            if (direction) {
                root.right = new TreeNode(pre[i]);
                r = root.right;
            } else {
                root.left = new TreeNode(pre[i]);
                r = root.left;
            }
            int k = i1;
            for (; k < j1; k++) {
                if (in[k] == pre[i]) {
                    break;
                }
            }
            if (k != i1) {
                travel(r, i + 1, i + k - i1 + 1, i1, k, false);
            }
            if (k + 1 != j1) {
                travel(r, i + k - i1 + 1, j, k + 1, j1, true);
            }
            System.out.println();
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        pre = preorder;
        in = inorder;
        int position = 0;
        for (int i: in) {
            if (i == root.val) {
                break;
            }
            position++;
        }
        if (position != 0) {
            travel(root, 1, 2, 0, position, false);
        }
        if (position + 1 != in.length) {
            travel(root, 1 + position, in.length, position + 1, in.length, true);
        }
        return root;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ns1 = reader.readLine().split(" ");
        String[] ns2 = reader.readLine().split(" ");
        int[] preorder = new int[ns1.length];
        int[] inorder = new int[ns2.length];
        
        for (int i = 0; i < ns1.length; i++) {
            preorder[i] = Integer.parseInt(ns1[i]);
        }
        
        for (int i = 0; i < ns2.length; i++) {
            inorder[i] = Integer.parseInt(ns2[i]);
        }
        
        TreeNode root = new BuildTree().buildTree(preorder, inorder);
        TreeNode.postorderTra(root);
    }

}
