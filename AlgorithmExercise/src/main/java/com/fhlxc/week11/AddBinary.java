package com.fhlxc.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月22日 下午4:24:45
* @classname AddBinary
* @description 
* 给定两个二进制字符串，返回他们的和（用二进制表示）。
* 输入为非空字符串且只包含数字 1 和 0。
* 示例 1:
* 输入: a = "11", b = "1"
* 输出: "100"
* 示例 2:
* 输入: a = "1010", b = "1011"
* 输出: "10101"
*/

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        String s = "";
        int i = 0;
        if (a.length() > b.length()) {
            i = a.length() - b.length();
            for (; i > 0; i--) {
                s += "0";
            }
            b = s + b;
        } else {
            i = b.length() - a.length();
            for (; i > 0; i--) {
                s += "0";
            }
            a = s + a;
        }
        
        int bit = 0;
        int sum = 0;
        for (i = a.length() - 1; i >= 0; i--) {
            sum = a.charAt(i) + b.charAt(i) + bit - 48 - 48;
            result.insert(0, sum % 2);
            if (sum > 1) {
                bit = 1;
            } else {
                bit = 0;
            }
        }
        if (bit == 1) {
            result.insert(0, "1");
        }
        return result.toString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        System.out.println(new AddBinary().addBinary(a, b));
    }

}
