package com.fhlxc.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/37/16 16:37:52
* @ClassName LongestPalindrome
* @Description 给定一个字符串s，找到s中最长的回文子串。你可以假设s的最大长度为1000.
* 输入：babad
* 输出：bab
*/

public class LongestPalindrome {
    
    public static String longestPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder result = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int j = i - 1;
            int k = i + 1;
            StringBuilder s1 = new StringBuilder();
            s1.append(stringBuilder.charAt(i));
            for (;j >= 0 && k < length;) {
                char c1 = stringBuilder.charAt(j);
                char c2 = stringBuilder.charAt(k);
                if (c1 == c2) {
                    s1.insert(0, c1);
                    s1.append(c1);
                } else {
                    break;
                }
                j--;
                k++;
            }
            if (result.length() < s1.length()) {
                result = s1;
            }
        }
        for (int i = 0; i < length - 1; i++) {
            int j = i - 1;
            int k = i + 2;
            StringBuilder s1 = new StringBuilder();
            char c1 = stringBuilder.charAt(i);
            char c2 = stringBuilder.charAt(i + 1);
            if (c1 != c2) {
                continue;
            }
            s1.append(c1);
            s1.append(c2);
            for (;j >= 0 && k < length;) {
                char c3 = stringBuilder.charAt(j);
                char c4 = stringBuilder.charAt(k);
                if (c3 == c4) {
                    s1.insert(0, c3);
                    s1.append(c4);
                } else {
                    break;
                }
                j--;
                k++;
            }
            if (result.length() < s1.length()) {
                result = s1;
            }
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            System.out.println(longestPalindrome(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
