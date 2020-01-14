package com.fhlxc.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/02/14 10:02:58
* @ClassName MaxLength
* @Description 
* 给定一个字符串，找出不含重复字符的最长子串的长度
* 输入样例：abcabcbb
* 输出样例：3
*/

public class MaxLength {
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder string = new StringBuilder(s);
        
        for (int i = 0; i < length; i++) {
            String c = String.valueOf(string.charAt(i));
            if (result.indexOf(c) == -1) {
                result.append(c);
            } else {
                int l = result.length();
                if (max < l) {
                    max = l;
                }
                result.delete(0, result.indexOf(c) + 1);
                result.append(c);
            }
        }
        
        int l = result.length();
        if (max < l) {
            max = l;
        }
        
        return max;
    }
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            System.out.println(lengthOfLongestSubstring(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
