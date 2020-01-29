package com.fhlxc.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年1月29日 下午3:55:44
* @ClassName ThreeSumClosed
* @Description 
* 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
*/

public class ThreeSumClosed {

    public static int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+ 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int n = nums[i] + nums[j] + nums[k] - target;
                    if (Math.abs(n) < Math.abs(result)) {
                        result = n;
                    }
                }
            }
        }
        return result + target;
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            String[] numbers = input.split(" ")[0].split(",");
            int target = Integer.parseInt(input.split(" ")[1]);
            int[] nums = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                nums[i] = Integer.parseInt(numbers[i]);
            }
            System.out.println(threeSumClosest(nums, target));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
