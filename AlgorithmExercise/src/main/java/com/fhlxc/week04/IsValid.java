package com.fhlxc.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
* @author Xingchao Long
* @date 2020年2月1日 上午11:08:47
* @ClassName IsValid
* @Description 有效括号
*/

public class IsValid {

    public static boolean isValid(String s) {
        boolean result = true;
        char[] input = s.toCharArray();
        
        Stack<Character> brackets = new Stack<>();
        
        out: for (char bracket: input) {
            switch (bracket) {
                case '(': {
                    brackets.add(bracket);
                    break;
                }
                case ')': {
                    if (brackets.empty()) {
                        result = false;
                        break out;
                    } else {
                        char c = brackets.pop();
                        if (c != '(') {
                            result = false;
                            break out;
                        }
                    }
                    break;
                }
                case '[': {
                    brackets.add(bracket);
                    break;
                }
                case ']': {
                    if (brackets.empty()) {
                        result = false;
                        break out;
                    } else {
                        char c = brackets.pop();
                        if (c != '[') {
                            result = false;
                            break out;
                        }
                    }
                    break;
                }
                case '{': {
                    brackets.add(bracket);
                    break;
                }
                case '}': {
                    if (brackets.empty()) {
                        result = false;
                        break out;
                    } else {
                        char c = brackets.pop();
                        if (c != '{') {
                            result = false;
                            break out;
                        }
                    }
                    break;
                }
                case ' ': {
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unexpected value: " + bracket);
            }
        }
        if (!brackets.empty()) {
            result = false;
        }
        return result;
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(isValid(reader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
