package com.fhlxc.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年2月10日 下午3:10:35
* @ClassName Divide
* @Description
*/

public class Divide {

    private static long[] cal(long n1, long n2) {
        long[] n = new long[3];
        int result = 0;
        while (true) {
            n2 = n2 << 1;
            if (n1 - n2 < 0) {
                n2 = n2 >> 1;
                break;
            }
            result++;
        }
        n[0] = 1;
        for (int i = 0; i < result; i++) {
            n[0] = n[0] << 1;
        }
        if (result == 0) {
            n[0] = 1;
        }
        n[1] = (int) (n1 - n2);
        n[2] = result;
        return n;
    }
    
    private static int divide(int dividend, int divisor) {
        long result = 0;
        long n1 = Math.abs((long)dividend);
        long n2 = Math.abs((long)divisor);
        long[] n = new long[3];
        
        if (dividend == 0) {
            return 0;
        }
        if ((dividend == Integer.MIN_VALUE && divisor == -1) || (dividend == Integer.MAX_VALUE && divisor == 1)) {
            return Integer.MAX_VALUE;
        }
        if ((dividend == Integer.MIN_VALUE && divisor == 1) || (dividend == Integer.MAX_VALUE && divisor == -1)) {
            return Integer.MIN_VALUE;
        }
        
        n[1] = n1;
        n[2] = 5;
        
        while (true) {
            if (n[1] < n2) {
                break;
            }
            n = cal(n[1], n2);
            result = result + n[0];
            if (n[2] == 0) {
                break;
            }
        }
        
        if ((dividend ^ divisor) < 0) {
            result = -result;
        }
        return (int) result;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int dividend = Integer.parseInt(reader.readLine());
        int divisor = Integer.parseInt(reader.readLine());
        System.out.println(divide(dividend, divisor));
    }

}
