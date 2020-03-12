package com.fhlxc.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/55/10 18:55:47
* @ClassName AddTwoNumbersTest
* @Description 
*/

public class AddTwoNumbersTest {
    
    public static void test(String s) {
        try {
            System.out.println(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String s = reader.readLine();
                test(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
