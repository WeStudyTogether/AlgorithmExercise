package com.fhlxc.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月22日 下午4:54:27
* @classname MySqrt
* @description 
* 实现 int sqrt(int x) 函数。
* 计算并返回 x 的平方根，其中 x 是非负整数。
* 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
* 示例 1:
* 输入: 4
* 输出: 2
* 示例 2:
* 输入: 8
* 输出: 2
* 说明: 8 的平方根是 2.82842..., 
*      由于返回类型是整数，小数部分将被舍去。
*/

public class MySqrt {

    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long tmp = 0;
        long pre = -1;
        
        if (x == 1) {
            return 1;
        }
        
        while (tmp != pre) {
            pre = tmp;
            tmp = (left + right) / 2;
            if (tmp * tmp > x) {
                right = tmp;
            } else {
                left = tmp;
            }
        }
        
        return (int) tmp;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println(new MySqrt().mySqrt(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())));
    }

}
