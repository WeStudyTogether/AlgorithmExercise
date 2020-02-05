package com.fhlxc.mylove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年2月4日 上午11:02:11
* @ClassName GenerateParenthesis
* @Description leetcode 22
* 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
* 例如，给出 n = 3，生成结果为：
* [
*   "((()))",
*   "(()())",
*   "(())()",
*   "()(())",
*   "()()()"
* ]
*/

public class GenerateParenthesis {
    
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        return result;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(generateParenthesis(n));
    }

}
