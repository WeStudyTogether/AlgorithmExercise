package com.fhlxc.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/51/23 15:51:50
* @ClassName LongestCommonPrefix
* @Description 
* 编写一个函数来查找字符串数组中的最长公共前缀。

* 如果不存在公共前缀，返回空字符串 ""。

* 示例 1:

* 输入: ["flower","flow","flight"]
* 输出: "fl"

* 示例 2:

* 输入: ["dog","racecar","car"]
* 输出: ""
* 解释: 输入不存在公共前缀。
*/

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int min = Integer.MAX_VALUE;
        if (strs.length == 0) {
            return "";
        }
        for (String s: strs) {
            int n = s.length();
            if (min > n) {
                min = n;
            }
        }
        out: for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (String s: strs) {
                if (c != s.charAt(i)) {
                    break out;
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] strs = reader.readLine().split(" ");
            System.out.println(longestCommonPrefix(strs));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
