package com.fhlxc.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月25日 上午10:39:02
* @classname BuildTree2
* @description 
* 根据一棵树的中序遍历与后序遍历构造二叉树。
* 注意:
* 你可以假设树中没有重复的元素。
* 例如，给出
* 中序遍历 inorder = [9,3,15,20,7]
* 后序遍历 postorder = [9,15,7,20,3]
* 返回如下的二叉树：
*     3
*    / \
*   9  20
*     /  \
*    15   7
*/

public class BuildTree2 {

    private int[] in;
    private int[] post;
    
    private void travel(TreeNode root, int i, int j, int i1, int j1, boolean direction) {
        TreeNode r;
        if (direction) {
            root.right = new TreeNode(post[j - 1]);
            r = root.right;
        } else {
            root.left = new TreeNode(post[j - 1]);
            r = root.left;
        }
        int k = i1;
        for (; k < j1; k++) {
            if (in[k] == post[j - 1]) {
                break;
            }
        }
        
        if (k != i1) {
            travel(r, i, i + k - i1, i1, k, false);
        }
        if (k + 1 != j1) {
            travel(r, i + k - i1, j - 1, k + 1, j1, true);
        }
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder;
        post = postorder;
        if (postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int k = 0;
        for (; k < in.length; k++) {
            if (in[k] == root.val) {
                break;
            }
        }
        if (k != 0) {
            travel(root, 0, k, 0, k, false);
        }
        if (k + 1 != in.length) {
            travel(root, k, in.length - 1, k + 1, in.length, true);
        }
        return root;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ns1 = reader.readLine().split(" ");
        String[] ns2 = reader.readLine().split(" ");
        int[] inorder = new int[ns1.length];
        int[] postorder = new int[ns2.length];
        
        for (int i = 0; i < ns1.length; i++) {
            inorder[i] = Integer.parseInt(ns1[i]);
        }
        
        for (int i = 0; i < ns2.length; i++) {
            postorder[i] = Integer.parseInt(ns2[i]);
        }
        
        TreeNode root = new BuildTree2().buildTree(inorder, postorder);
        TreeNode.preorderTra(root);
    }

}
