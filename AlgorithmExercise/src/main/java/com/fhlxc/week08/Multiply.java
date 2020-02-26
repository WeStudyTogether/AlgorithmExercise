package com.fhlxc.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年2月26日 下午6:57:49
* @ClassName Multiply
* @Description 
*/

public class Multiply {

    private StringBuilder add(StringBuilder r, StringBuilder adds) {
        StringBuilder result = new StringBuilder(r);
        int n = result.length() - adds.length();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                adds.insert(0, '0');
            }
        } else {
            if (n < 0) {
                for (int i = 0; i < -n; i++) {
                    result.insert(0, '0');
                }
            }
        }
        n = result.length();
        int n1 = 0;
        int n2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            n1 = result.charAt(i) - '0';
            n2 = adds.charAt(i) - '0';
            n  = n1 + n2;
            if (n < 10) {
                result.replace(i, i + 1, n + "");
            } else {
                int j = i - 1;
                result.replace(i, i + 1, n % 10 + "");
                do {
                    if (j == -1) {
                        result.insert(0, '1');
                        adds.insert(0, '0');
                        i++;
                        break;
                    }
                    n1 = result.charAt(j) - '0';
                    n1 += 1;
                    if (n1 < 10) {
                        result.replace(j, j + 1, n1 + "");
                        break;
                    } else {
                        result.replace(j, j + 1, n1 % 10 + "");
                    }
                    j--;
                } while(true);
            }
        }
        return result;
    }
    
    private String multiply(StringBuilder num1, StringBuilder num2) {
        StringBuilder result = new StringBuilder("0");
        
        int n = 0;
        int length = num2.length() - 1;
        for (int i = length; i >= 0; i--) {
            n = num2.charAt(i) - '0';
            StringBuilder curr = new StringBuilder(num1);
            if (n != 0) {
                for (int j = 0; j < n - 1; j++) {
                    curr = add(curr, new StringBuilder(num1));
                }

                for (int k = 0; k < length - i; k++) {
                    curr.append('0');
                }
                result = add(result, curr);
            } else {
                result = add(result, new StringBuilder("0"));
            }
        }
        return result.toString();
    }
    
    public String multiply(String num1, String num2) {
        String result = "";
        if (num1.length() > num2.length()) {
            result = multiply(new StringBuilder(num1), new StringBuilder(num2));
        } else {
            result = multiply(new StringBuilder(num2), new StringBuilder(num1));
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        String[] ns = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        System.out.println(new Multiply().multiply(ns[0], ns[1]));
    }

}
