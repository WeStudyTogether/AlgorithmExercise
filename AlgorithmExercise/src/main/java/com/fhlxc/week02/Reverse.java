package com.fhlxc.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;

/**
* @author Xingchao Long
* @date 2020/16/18 10:16:05
* @ClassName Reverse.java
* @Description 
* 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转.
* 输入：-123
* 输出：-321
*/

public class Reverse {

    public static int reverse(int x) {
        BigInteger result = new BigInteger("0");
        boolean negative;
        Stack<Integer> nums = new Stack<>();
        if (x < 0) {
            negative = true;
            x  = -x;
        } else {
            negative = false;
        }
        for (int i = x; i != 0; ) {
            nums.push(i % 10);
            i = i / 10;
        }
        BigInteger n = new BigInteger("1");
        while (!nums.empty()) {
            BigInteger i = new BigInteger("0");
            i =  n.multiply(new BigInteger(nums.pop().toString()));
            result = result.add(i);
            n = n.multiply(new BigInteger("10"));
        }
        if (negative) {
            result = result.multiply(new BigInteger("-1"));
        }
        Integer max = Integer.MAX_VALUE;
        Integer min = Integer.MIN_VALUE;
        if (result.compareTo(new BigInteger(max.toString())) == 1 || result.compareTo(new BigInteger(min.toString()))  == -1) {
            return 0;
        }
        return result.intValue();
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int x = Integer.parseInt(reader.readLine());
            System.out.println(reverse(x));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
