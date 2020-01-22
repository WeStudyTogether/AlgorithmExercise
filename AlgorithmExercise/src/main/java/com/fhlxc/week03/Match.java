package com.fhlxc.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author Xingchao Long
* @date 2020/44/21 09:44:20
* @ClassName Match
* @Description 
* 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
* 样例："mississippi"
        "mis*is*ip*."
* 输出：true
*/

public class Match {
    
    public static boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher match = pattern.matcher(s);
        return match.matches();
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
