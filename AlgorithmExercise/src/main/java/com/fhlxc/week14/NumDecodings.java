package com.fhlxc.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年4月10日 上午10:55:02
* @classname NumDecodings
* @description 
* 一条包含字母 A-Z 的消息通过以下方式进行了编码：
* 'A' -> 1
* 'B' -> 2
* ...
* 'Z' -> 26
* 给定一个只包含数字的非空字符串，请计算解码方法的总数。
* 示例 1:
* 输入: "12"
* 输出: 2
* 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
* 示例 2:
* 输入: "226"
* 输出: 3
* 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
*/

public class NumDecodings {

    private int length = 0;
    private int n = 0;
    
    private void backtrace(String s, int i) {
        if (i > n - 1) {
            length++;
            return;
        }
        int first = s.charAt(i) - '0';
        int second = -1;
        if (i + 1 < n) {
            second = s.charAt(i + 1) - '0';
        }
        int total = 0;
        if (second != -1) {
            total = first * 10 + second;
        }
        if (first == 0) {
            return;
        }
        backtrace(s, i + 1);
        if (total <= 26 && total >= 1) {
            backtrace(s, i + 2);
        }
    }
    
    public int numDecodings(String s) {
        n = s.length();
        backtrace(s, 0);
        return length;
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(new NumDecodings().numDecodings(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

}
