package com.fhlxc.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
* @author Xingchao Long
* @date 2020年3月11日 上午10:31:45
* @ClassName PlusOne
* @Description 
* 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
* 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
* 你可以假设除了整数 0 之外，这个整数不会以零开头。
* 示例 1:
* 输入: [1,2,3]
* 输出: [1,2,4]
* 解释: 输入数组表示数字 123。
* 示例 2:
* 输入: [4,3,2,1]
* 输出: [4,3,2,2]
* 解释: 输入数组表示数字 4321。
*/

public class PlusOne {
    
    public int[] plusOne(int[] digits) {
        int up = 1;
        int tmp = 0;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        for (int i: digits) {
            s1.push(i);
        }
        while (!s1.empty()) {
            tmp = s1.pop() + up;
            if (tmp > 9) {
                s2.push(tmp % 10);
                up = 1;
            } else {
                s2.push(tmp);
                up = 0;
            }
        }
        
        if (up == 1) {
            s2.push(1);
        }
        int[] result = new int[s2.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = s2.pop();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String[] ds = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int[] digits = new int[ds.length];
        for (int i = 0; i < ds.length; i++) {
            digits[i] = Integer.parseInt(ds[i]);
        }
        int[] result = new PlusOne().plusOne(digits);
        for (int i: result) {
            System.out.print(i + " ");
        }
    }

}
