package com.fhlxc.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月25日 上午9:24:26
* @classname ClimbStairs
* @description 
* 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
* 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
* 注意：给定 n 是一个正整数。
* 示例 1：
* 输入： 2
* 输出： 2
* 解释： 有两种方法可以爬到楼顶。
* 1.  1 阶 + 1 阶
* 2.  2 阶
* 示例 2：
* 输入： 3
* 输出： 3
* 解释： 有三种方法可以爬到楼顶。
* 1.  1 阶 + 1 阶 + 1 阶
* 2.  1 阶 + 2 阶
* 3.  2 阶 + 1 阶
*/

public class ClimbStairs {
    
    public int climbStairs(int n) {
        if (n == 1) {
            return 1; 
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            if (i - 2 >= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            if (i - 2 < 0 && i - 1 >= 0) {
                dp[i] = dp[i - 1];
            }
            if (i - 1 < 0) {
                dp[i] = 1;
            }
        }
        return dp[n];
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println(new ClimbStairs().climbStairs(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

}
