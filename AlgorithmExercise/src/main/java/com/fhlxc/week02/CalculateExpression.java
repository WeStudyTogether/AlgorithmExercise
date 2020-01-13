package com.fhlxc.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author Xingchao Long
* @date 2020/29/13 09:29:43
* @ClassName CalculateExpression
* @Description 
* 给定一个0-9、‘-’、‘*’的合法数学表达式（长度小于1000），规定‘-’的优先级高于乘
* 号‘*’。请输出计算结果。输入说明：合法的数学表达式（其中没有负数）输出说明：输出表达式的计算
* 结果 输入样例：12*3-12*2 输出样例：-216
*/

public class CalculateExpression {

    public static int calculateExpression(ArrayList<String> tokens) {
        Stack<String> expression = new Stack<>();
        Stack<String> reverse = new Stack<>();
        Stack<String> symbol = new Stack<>();
        Stack<Integer> result = new Stack<>();
        int length = tokens.size();
        
        for (int i = 0; i < length; i++) {
            String token = tokens.get(i);
            if (token.matches("[0-9][0-9]*")) {
                expression.push(token);
            } else {
                if (token.equals("-")) {
                    i = i + 1;
                    String token1 = tokens.get(i);
                    expression.push(token1);
                    expression.push(token);
                } else {
                    if (!symbol.empty()) {
                        expression.push(symbol.pop());
                        symbol.push(token);
                    } else {
                        symbol.push(token);
                    }
                }
            }
        }
        
        if (!symbol.empty()) {
            expression.push(symbol.pop());
        }
        
        while (!expression.empty()) {
            reverse.push(expression.pop());
        }
        
        while (!reverse.empty()) {
            String token = reverse.pop();
            if (token.matches("[0-9][0-9]*")) {
                result.push(Integer.parseInt(token));
            } else {
                int right = result.pop();
                int left = result.pop();
                if (token.equals("-")) {
                    result.push(left - right);
                } else {
                    result.push(left * right);
                }
            }
        }
        return result.pop();
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String expression = reader.readLine();
            String regx = "[0-9][0-9]*|-|\\*";
            ArrayList<String> tokens = new ArrayList<>();
            Pattern pattern = Pattern.compile(regx);
            Matcher matcher = pattern.matcher(expression);
            
            while (matcher.find()) {
                tokens.add(matcher.group());
            }
            
            System.out.println(calculateExpression(tokens));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
