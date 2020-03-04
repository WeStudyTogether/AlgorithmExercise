package com.fhlxc.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月4日 上午9:54:30
* @ClassName MyPow
* @Description
* 计算n次幂——分半算法
* 示例 1:
* 输入: 2.00000, 10
* 输出: 1024.00000
* 示例 2:
* 输入: 2.10000, 3
* 输出: 9.26100
* 示例 3:
* 输入: 2.00000, -2
* 输出: 0.25000
* 解释: 2-2 = 1/22 = 1/4 = 0.25
*/

public class MyPow {

    private double cal(double x, long n) {
        if (n == 1) {
            return x;
        }
        if (n == 2) {
            return x * x;
        }
        double t = cal(x, n / 2);
        if (n % 2 == 0) {
            return t * t;
        } else {
            return t * t * x;
        }
    }
    
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        if (n == 1) {
            return x;
        }
        if (x == 1 || n == 0) {
            return 1;
        }
        return cal(x, N);
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double x = Double.parseDouble(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        System.out.println(String.format("%.5f", new MyPow().myPow(x, n)));
    }

}
