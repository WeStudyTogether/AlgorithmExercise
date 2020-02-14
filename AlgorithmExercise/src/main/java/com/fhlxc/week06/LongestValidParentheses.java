package com.fhlxc.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
* @author Xingchao Long
* @date 2020年2月14日 上午11:33:13
* @ClassName LongestValidParentheses
* @Description 
*/

public class LongestValidParentheses {
    
    public int longestValidParentheses(String s) {
        int length = s.length();
        int result = 0;
        Stack<Character> stack = new Stack<>();
        String str = "";
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add('(');
                str += "(";
            } else {
                if (stack.isEmpty()) {
                    str = "*" + str + "*";
                } else {
                    stack.pop();
                    str += ")";
                }
            }
        }
        
        int n = str.length() - 1;
        String ss = "";
        
        while (!stack.isEmpty()) {
            stack.pop();
            ss = ss + "*";
        }
        
        str = str + ss;
        
        StringBuilder stringBuilder = new StringBuilder(str);
        
        if (ss.length() != 0) {
            int l = ss.length();
            int i = 0;
            int k = 0;
            
            while (true) {
                if (str.charAt(n) == ')' || str.charAt(n) == '*') {
                    k++;
                    n--;
                }
                if (str.charAt(n) == '(') {
                    if (k != 0) {
                        k--;
                        n--;
                        continue;
                    }
                    stringBuilder.replace(n, n + 1, "*");
                    n = n - 1;
                    i++;
                    if (i == l) {
                        break;
                    }
                }
            }
        }
        
        String[] strs = stringBuilder.toString().split("\\*");
        
        for (String string: strs) {
            if (result < string.length()) {
                result = string.length();
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(reader.readLine()));
    }

}
