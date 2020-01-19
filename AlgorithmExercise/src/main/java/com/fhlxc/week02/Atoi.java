package com.fhlxc.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @author Xingchao Long
* @date 2020/43/19 09:43:36
* @ClassName Atoi
* @Description 
* 请你来实现一个 atoi 函数，使其能将字符串转换成整数。

* 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

* 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

* 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

* 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

* 在任何情况下，若函数不能进行有效的转换时，请返回 0.
*/

public class Atoi {

    public static int myAtoi(String str) {
        String regx = "[-+]?[0-9]+";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str.trim());
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;
        if (matcher.find()) {
            if (matcher.start() != 0) {
                return 0;
            }
            String s = matcher.group();
            BigInteger bigInteger = new BigInteger(s);
            if (bigInteger.compareTo(new BigInteger(max.toString())) == 1) {
                return max;
            }
            if (bigInteger.compareTo(new BigInteger(min.toString())) == -1) {
                return min;
            }
            return bigInteger.intValue();
        }
        
        return 0;
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
            System.out.println(myAtoi(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
