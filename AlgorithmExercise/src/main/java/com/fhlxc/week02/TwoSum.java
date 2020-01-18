package com.fhlxc.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/00/18 10:00:08
* @ClassName TwoSum
* @Description 
* 给定一个整数数组nums和一个目标值target，请你在数组中找出和为目标值的两个整数，并返回他们的数组下标。
* 你可以假设每种输入只会对应一个答案。但是你不能利用这个数组中同样的元素。
* 输入：2 7 11 15
* 9
* 输出：0 1
*/

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        out: for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break out;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = reader.readLine();
            int target = Integer.parseInt(reader.readLine());
            String[] ns = s.split(" ");
            int[] nums = new int[ns.length];
            for (int i = 0; i < ns.length; i++) {
                nums[i] = Integer.parseInt(ns[i]);
            }
            int[] result = twoSum(nums, target);
            System.out.println(result[0] + " " + result[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
