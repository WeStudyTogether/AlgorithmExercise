package com.fhlxc.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/38/27 10:38:59
* @ClassName IntToRoman
* @Description 整数转成罗马数字
*/

public class IntToRoman {

    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        int[] specials = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romans = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = specials.length - 1;
        for (; num > 0; ) {
            for (; i >= 0; i--) {
                if (num - specials[i] >= 0) {
                    break;
                }
            }
            if (i == -1) {
                break;
            }
            result.append(romans[i]);
            num -= specials[i];
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println(intToRoman(Integer.parseInt(reader.readLine())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
