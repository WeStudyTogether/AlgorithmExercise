package com.fhlxc.week15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年4月15日 上午11:37:17
* @classname NumTrees
* @description 
* 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
* 示例:
* 输入: 3
* 输出: 5
* 解释:
* 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
*    1         3     3      2      1
*     \       /     /      / \      \
*      3     2     1      1   3      2
*     /     /       \                 \
*    2     1         2                 3
*/

public class NumTrees {
    
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
          for (int j = 1; j <= i; ++j) {
            G[i] += G[j - 1] * G[i - j];
          }
        }
        return G[n];
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println(new NumTrees().numTrees(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

}
