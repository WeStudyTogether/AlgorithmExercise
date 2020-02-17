package com.fhlxc.week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年2月17日 下午5:11:50
* @ClassName MaxSubArray
* @Description 
*/

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int result = 0;
        for (int n: nums) {
            result += n;
        }
        for (int i = 0; i < nums.length; i++) {
            int n = 0;
            for (int j = i; j < nums.length; j++) {
                n += nums[j];
                if (n > result) {
                    result = n;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        String[] ns = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }

}
