package com.fhlxc.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年1月30日 上午11:11:27
* @ClassName LetterCombinations
* @Description
*/

public class LetterCombinations {

    private static List<StringBuilder> addLetter(List<StringBuilder> resultBuilders, String letters) {
        List<StringBuilder> result = new LinkedList<>();
        char[] ls = letters.toCharArray();
        if (resultBuilders.isEmpty()) {
            for (int i = 0; i < ls.length; i++) {
                StringBuilder s  = new StringBuilder();
                s.append(ls[i]);
                result.add(s);
            }
        } else {
            for (StringBuilder s: resultBuilders) {
                for (int i = 0; i < ls.length; i++) {
                    StringBuilder s1 = new StringBuilder();
                    s1.append(s);
                    s1.append(ls[i]);
                    result.add(s1);
                }
            }
        }
        return result;
    }
    
    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();
        List<StringBuilder> resultBuilders = new LinkedList<>();
        char[] nums = digits.toCharArray();
        for (char c: nums) {
            switch (c) {
            case '2': {
                resultBuilders = addLetter(resultBuilders, "abc");
                break;
            }
            case '3': {
                resultBuilders = addLetter(resultBuilders, "def");
                break;
            }
            case '4': {
                resultBuilders = addLetter(resultBuilders, "ghi");
                break;
            }
            case '5': {
                resultBuilders = addLetter(resultBuilders, "jkl");
                break;
            }
            case '6': {
                resultBuilders = addLetter(resultBuilders, "mno");
                break;
            }
            case '7': {
                resultBuilders = addLetter(resultBuilders, "pqrs");
                break;
            }
            case '8': {
                resultBuilders = addLetter(resultBuilders, "tuv");
                break;
            }
            case '9': {
                resultBuilders = addLetter(resultBuilders, "wxyz");
                break;
            }
            default:
                throw new IllegalArgumentException("Unexpected value: " + c);
            }
        }
        for (StringBuilder s: resultBuilders) {
            result.add(s.toString());
        }
        return result;
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String digits = reader.readLine();
            System.out.println(letterCombinations(digits));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
