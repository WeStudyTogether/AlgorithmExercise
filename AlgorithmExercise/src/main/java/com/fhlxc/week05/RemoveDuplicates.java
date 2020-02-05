package com.fhlxc.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
* @author Xingchao Long
* @date 2020年2月5日 上午10:50:59
* @ClassName RemoveDuplicates
* @Description 移除相同的整数
*/

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int result = nums.length;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < result; i++) {
            set.add(nums[i]);
        }
        int i = 0;
        for (Integer s: set) {
            nums[i] = s;
            i++;
        }
        result = i;
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = reader.readLine().split(" ");
        int[] nums = new int[numbers.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numbers[i]);
        }
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
