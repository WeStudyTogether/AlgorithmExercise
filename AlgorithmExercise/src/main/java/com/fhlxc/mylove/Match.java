package com.fhlxc.mylove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
* @author Xingchao Long
* @date 2020年2月5日 下午4:06:57
* @ClassName Match
* @Description leetcode 10
* 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
* '.' 匹配任意单个字符
* '*' 匹配零个或多个前面的那一个元素
* 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
* 示例 1:
* 输入:
* s = "aa"
* p = "a"
* 输出: false
* 解释: "a" 无法匹配 "aa" 整个字符串。
* 示例 2:
* 输入:
* s = "aa"
* p = "a*"
* 输出: true
* 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
* 示例 3:
* 输入:
* s = "ab"
* p = ".*"
* 输出: true
* 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
* 示例 4:
* 输入:
* s = "aab"
* p = "c*a*b"
* 输出: true
* 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
* 示例 5:
* 输入:
s = "mississippi"
* p = "mis*is*p*."
* 输出: false
*/

public class Match {

    public static boolean isMatch(String s, String p) {
        List<String> pattern = new ArrayList<String>();
        Stack<Character> tmp = new Stack<>();
        StringBuilder s1 = new StringBuilder(s);
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) != '*') {
                pattern.add(0, p.charAt(i) + "");
            } else {
                i--;
                pattern.add(0, p.charAt(i) + "*");
            }
        }
        int j = 0;
        int i = 0;
        try {
            for (; i < s1.length(); i++, j++) {
                if (pattern.get(j).length() > 1) {
                    if (s1.charAt(i) != pattern.get(j).charAt(0) && pattern.get(j).charAt(0) != '.') {
                        i--;
                    } else {
                        if (i != s1.length() - 1) {
                            j--;
                        }
                        tmp.add(s1.charAt(i));
                    }
                } else {
                    if (s1.charAt(i) != pattern.get(j).charAt(0) && pattern.get(j).charAt(0) != '.') {
                        if (pattern.get(j - 1).charAt(0) == s1.charAt(i)) {
                            if (!tmp.empty()) {
                                if (tmp.peek() != pattern.get(j).charAt(0)) {
                                    return false;
                                } else {
                                    tmp.pop();
                                    j--;
                                }
                            } else {
                                return false;
                            }
                        }
                        return false;
                    }
                    s1.replace(i, i + 1, "*");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        String str = "";
        int n = 0;
        
        while (j < pattern.size()) {
            if (pattern.get(j).length() <= 1) {
                str += pattern.get(j);
                n++;
            }
            j++;
        }
        int begin = s.length() - n;
        if (begin < 0) {
            begin = 0;
        }
        String ss = s1.substring(begin);
        
        try {
            for (int k = 0; k < n; k++) {
                if (ss.charAt(k) == '*') {
                    return false;
                }
                if (ss.charAt(k) != str.charAt(k) && str.charAt(k) != '.') {
                    return false;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            String p = reader.readLine();
            System.out.println(isMatch(s, p));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
