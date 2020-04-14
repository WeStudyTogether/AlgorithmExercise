package com.fhlxc.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.fhlxc.mylove.TreeNode;

/**
* @author Xingchao Long
* @date 2020年4月14日 上午10:46:22
* @classname GenerateTrees
* @description 
* 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
* 示例:
* 输入: 3
* 输出:
* [
*   [1,null,3,2],
*   [3,2,null,1],
*   [3,1,null,null,2],
*   [2,1,3],
*   [1,null,2,null,3]
* ]
* 解释:
* 以上的输出对应以下 5 种不同结构的二叉搜索树：
*    1         3     3      2      1
*     \       /     /      / \      \
*      3     2     1      1   3      2
*    /     /       \                 \
*    2     1         2                 3
*/

public class GenerateTrees {
    
    private List<TreeNode> list = new ArrayList<>();
    private List<List<Integer>> record = new ArrayList<>();
    TreeNode tmp;
    
    private void copy(TreeNode root, TreeNode root1) {
        if (root1 == null) {
            return;
        }
        root.val = root1.val;
        if (root1.left != null) {
            root.left = new TreeNode(0);
        }
        copy(root.left, root1.left);
        if (root1.right != null) {
            root.right = new TreeNode(0);
        }
        copy(root.right, root1.right);
    }
    
    private void read(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        read(list, root.left);
        read(list, root.right);
    }
    
    private void bactrace(List<Integer> l) {
        if (l.size() == 0) {
            TreeNode temp = new TreeNode(0);
            List<Integer> li = new ArrayList<>();
            read(li, tmp);
            if (!record.contains(li)) {
                copy(temp, tmp);
                record.add(li);
                list.add(temp);
            }
        }
        for (int i = 0; i < l.size(); i++) {
            Integer k = l.get(i);
            if (tmp == null) {
                tmp = new TreeNode(k);
                l.remove(i);
                bactrace(l);
                l.add(i, k);
                tmp = null;
            } else {
                TreeNode temp = tmp;
                int m = -1;
                while (true) {
                    if (k >= temp.val) {
                        if (temp.right == null) {
                            temp.right = new TreeNode(k);
                            m = 0;
                            break;
                        }
                        temp = temp.right;
                    } else {
                        if (temp.left == null) {
                            temp.left = new TreeNode(k);
                            m = 1;
                            break;
                        }
                        temp = temp.left;
                    }
                }
                l.remove(i);
                bactrace(l);
                l.add(i, k);
                if (m == 0) {
                    temp.right = null;
                }
                if (m == 1) {
                    temp.left = null;
                }
            }
        }
    }
    
    public List<TreeNode> generateTrees(int n) {
        List<Integer> l = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        for (int i = 1; i <= n; i++) {
            l.add(i);
        }
        bactrace(l);
        return list;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        List<TreeNode> list = new GenerateTrees().generateTrees(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        for (TreeNode root: list) {
            TreeNode.inorderTra(root);
            System.out.println();
        }
    }

}
