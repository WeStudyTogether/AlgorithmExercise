package com.fhlxc.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
* @author Xingchao Long
* @date 2020年3月18日 上午9:37:02
* @classname UniquePaths
* @description 
* 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
* 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
* 问总共有多少条不同的路径？
* 示例 1:
* 输入: m = 3, n = 2
* 输出: 3
* 解释:
* 从左上角开始，总共有 3 条路径可以到达右下角。
* 1. 向右 -> 向右 -> 向下
* 2. 向右 -> 向下 -> 向右
* 3. 向下 -> 向右 -> 向右
* 示例 2:
* 输入: m = 7, n = 3
* 输出: 28
*/
public class UniquePaths {
    
    public int uniquePaths(int m, int n) {
        if (m - 1 == 0) {
            return 1;
        }
        BigInteger n1 = new BigInteger("1");
        BigInteger n2 = new BigInteger("1");
        BigInteger n3 = BigInteger.valueOf(n);
        for (int i = m - 2; i >= 0; i--) {
            n1 = n1.multiply(n3.add(BigInteger.valueOf(i)));
        }
        for (int i = m - 1; i > 0; i--) {
            n2 = n2.multiply(BigInteger.valueOf(i));
        }
        return n1.divide(n2).intValue();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ns = reader.readLine().split(" ");
        int m = Integer.parseInt(ns[0]);
        int n = Integer.parseInt(ns[1]);
        
        System.out.println(new UniquePaths().uniquePaths(m, n));
    }

}
