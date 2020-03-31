package com.fhlxc.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年3月31日 下午2:05:55
* @classname Combine
* @description 
* 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
* 示例:
* 输入: n = 4, k = 2
* 输出:
* [
*   [2,4],
*   [3,4],
*   [2,3],
*   [1,2],
*   [1,3],
*   [1,4],
* ]
*/

public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (k == 0) {
            return null;
        }
        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(i);
            result.add(temp);
        }
        for (int i = 2; i <= k; i++) {
            List<List<Integer>> tmp = new ArrayList<List<Integer>>();
            for (List<Integer> list: result) {
                int j = list.get(list.size() - 1);
                for (j = j + 1; j <= n; j++) {
                    List<Integer> temp = new ArrayList<Integer>(list);
                    temp.add(j);
                    tmp.add(temp);
                }
            }
            result = tmp;
        }
        return result;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        System.out.println(new Combine().combine(n, k));
    }

}
