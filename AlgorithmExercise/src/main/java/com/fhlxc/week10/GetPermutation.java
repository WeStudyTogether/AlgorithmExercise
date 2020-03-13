package com.fhlxc.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年3月13日 上午11:09:15
* @ClassName GetPermutation
* @Description 
* 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
* 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
*     "123"
*     "132"
*     "213"
*     "231"
*     "312"
*     "321"
* 给定 n 和 k，返回第 k 个排列。
* 说明：
*     给定 n 的范围是 [1, 9]。
*     给定 k 的范围是[1,  n!]。
* 示例 1:
* 输入: n = 3, k = 3
* 输出: "213"
* 示例 2:
* 输入: n = 4, k = 9
* 输出: "2314"
*/

public class GetPermutation {
    
    private int circle(int n) {
        int sum = 1;
        for (;n > 0; n--) {
            sum *= n;
        }
        return sum;
    }
    
    public String getPermutation(int n, int k) {
        int tmp = 0;
        int t  = 0;
        int x = 0;
        String result = "";
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (k <= circle(i)) {
                tmp = i;
                break;
            }
        }
        
        for (int i = 1; i <= n - tmp; i++) {
            result += i;
        }
        
        for (int i = n - tmp + 1; i <= n; i++) {
            list.add(i);
        }
        
        while (tmp != 0) {
            tmp -= 1;
            x = circle(tmp);
            if (k % x != 0) {
                t = k / x + 1; 
            } else {
                t  = k / x;
            }
            result += list.get(t - 1);
            list.remove(t - 1);
            k = k - (t - 1) * x;
        }
        
        return result;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        System.out.println(new GetPermutation().getPermutation(n, k));
    }

}
