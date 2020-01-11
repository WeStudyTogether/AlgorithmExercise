package com.fhlxc.week01;

import java.util.Scanner;

/**
* @author Xingchao Long
* @date 2020/27/11 09:27:35
* @ClassName EliminateString
* @Description 
* 字母连连看，给定一个由小写字母组成的字符串，如果字符串中有两个连续的字母相同，则这两个字母可同时消除，并不断重复，直到没有重复为止。
* 输入说明：一串字符串
* 输出说明：如果可以完全消除，输出YES；否则输出消除后的结果。
* 输入样例1：abacddcaba
* 输出样例1：YES
* 输入样例2：asdfghhgf
* 输出样例2：asd
*/

public class EliminateString {

    private static String eliminateString(String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        for (int i = 0; i < stringBuffer.length() - 1; i++) {
            char c1 = stringBuffer.charAt(i);
            char c2 = stringBuffer.charAt(i+1);
            if (c1 == c2) {
                stringBuffer.deleteCharAt(i);
                stringBuffer.deleteCharAt(i);
                i = i - 2;
            }
        }
        if (stringBuffer.length() == 0) {
            stringBuffer.append("YES");
        }
        return stringBuffer.toString();
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        input.close();
        System.out.println(eliminateString(inputString));
    }

}
