package com.fhlxc.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月30日 下午3:24:48
* @classname LastRemaining
* @description 
* 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
* 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
* 示例 1：
* 输入: n = 5, m = 3
* 输出: 3
* 示例 2：
* 输入: n = 10, m = 17
* 输出: 2
* 限制：
*     1 <= n <= 10^5
*     1 <= m <= 10^6
*/

public class LastRemaining {

    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        System.out.print(new LastRemaining().lastRemaining(n, m));
    }

}
