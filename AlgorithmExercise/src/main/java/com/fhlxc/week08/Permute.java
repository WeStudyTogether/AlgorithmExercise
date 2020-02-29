package com.fhlxc.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年2月29日 上午10:47:26
* @ClassName Permute
* @Description 
* 给定一个没有重复数字的序列，返回其所有可能的全排列。
* 输入: [1,2,3]
* 输出:
* [
*   [1,2,3],
*   [1,3,2],
*   [2,1,3],
*   [2,3,1],
*   [3,1,2],
*   [3,2,1]
* ]
*/

public class Permute {
    
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    private void backtrace(List<Integer> tmp, List<Integer> nums) {
        int n = nums.size();
        if (n == 0) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < n; i++) {
            int t = nums.get(i);
            tmp.add(t);
            nums.remove(i);
            backtrace(tmp, nums);
            nums.add(i, t);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (Integer i: nums) {
            numbers.add(i);
        }
        backtrace(new ArrayList<>(), numbers);
        return result;
    }

    public static void main(String[] args) throws IOException {
        String[] ns = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        System.out.println(new Permute().permute(nums));
    }

}
