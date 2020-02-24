package com.fhlxc.week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
* @author Xingchao Long
* @date 2020年2月23日 上午11:27:39
* @ClassName FirstMissingPositive
* @Description 
* 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
* 示例 1:
* 输入: [1,2,0]
* 输出: 3
* 示例 2:
* 输入: [3,4,-1,1]
* 输出: 2
* 示例 3:
* 输入: [7,8,9,11,12]
* 输出: 1
* 说明:
* 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
*/

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        Arrays.sort(nums);
        int result = 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (result == nums[i]) {
                result++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ns = reader.readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }

}
