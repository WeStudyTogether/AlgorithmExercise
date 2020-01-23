package com.fhlxc.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/51/23 15:51:50
* @ClassName LongestCommonPrefix
* @Description 
*/

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int min = Integer.MAX_VALUE;
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
