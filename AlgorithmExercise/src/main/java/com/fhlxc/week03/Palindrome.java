package com.fhlxc.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/10/20 16:10:48
* @ClassName Palindrome
* @Description 
* 判断回文数字，是返回true，不是返回false。
*/

public class Palindrome {

    public static boolean isPalindrome(int x) {
        int tmp = 0;
        int y = x;
        
        if (x == 0) {
            return true;
        }
        
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        
        for (;x > 0;) {
            tmp = tmp * 10 + x % 10;
            x = x / 10;
        }
        return tmp == y;
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int x = Integer.parseInt(reader.readLine());
            System.out.println(isPalindrome(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
