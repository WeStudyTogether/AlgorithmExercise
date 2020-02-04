package com.fhlxc.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年2月4日 上午11:02:11
* @ClassName GenerateParenthesis
* @Description 生成有效括号
*/

public class GenerateParenthesis {
    
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left: generateParenthesis(i)) {
                    for (String right: generateParenthesis(n - 1 - i)) {
                        result.add("(" + left + ")" + right);
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(generateParenthesis(n));
    }

}
