package com.fhlxc.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/47/17 10:47:30
* @ClassName Convert
* @Description 
* 字符串的z型变化。
* 输入: s = "LEETCODEISHIRING", numRows = 4
* 输出: LDREOEIIECIHNTSG
* 解释:
* L     D     R
* E   O E   I I
* E C   I H   N
* T     S     G
*/

public class Convert {
    
    public static String convert(String s, int numRows) {
        int length = s.length();
        StringBuilder result = new StringBuilder();
        int stride = 2 * numRows - 2;
        int n = 2 * numRows - 2;
        if (n == 0) {
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            int k = i;
            while (true) {
                if (k >= length) {
                    break;
                }
                result.append(s.charAt(k));
                
                if (stride != n && k + stride < length) {
                    result.append(s.charAt(k + stride));
                }
                k += n;
            }
            stride = stride - 2;
            if (stride == 0) {
                stride = n;
            }
        }
        return result.toString();
    }
    
    public static void main(String ... args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            int row = Integer.parseInt(reader.readLine());
            System.out.println(convert(s, row));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
