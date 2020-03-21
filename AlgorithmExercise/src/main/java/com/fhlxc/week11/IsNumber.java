package com.fhlxc.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author Xingchao Long
* @date 2020年3月21日 下午4:38:52
* @classname IsNumber
* @description 
* 验证给定的字符串是否可以解释为十进制数字。
* 例如:
* "0" => true
* " 0.1 " => true
* "abc" => false
* "1 a" => false
* "2e10" => true
* " -90e3   " => true
* " 1e" => false
* "e3" => false
* " 6e-1" => true
* " 99e2.5 " => false
* "53.5e93" => true
* " --6 " => false
* "-+3" => false
* "95a54e53" => false
* 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
*     数字 0-9
*     指数 - "e"
*     正/负号 - "+"/"-"
*     小数点 - "."
* 当然，在输入中，这些字符的上下文也很重要。
*/

public class IsNumber {

    public boolean isNumber(String s) {
        s = s.trim();
        int i = s.indexOf(".");
        if (s.length() == 0) {
            return false;
        }
        if (i != -1) {
            if (i + 1 < s.length()) {
                if (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-') {
                    return false;
                }
            }
        }
        String[] ss = s.split("e");
        boolean b = false;
        if (s.charAt(s.length() - 1) == 'e') {
            b = true;
        }
        if (ss.length > 0) {
            ss[0] = ss[0].replaceFirst("\\.", "");
            s = "";
            for (String t: ss) {
                s = s + t + "e";
            }
            if (!b) {
                s = s.substring(0, s.length() - 1);
            }
        }
        String regex1 = "[+-]?[0-9]+(e[+-]?[0-9]+)?";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(s);
        return matcher1.matches();
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println(new IsNumber().isNumber(new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

}
