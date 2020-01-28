package com.fhlxc.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年1月28日 下午4:46:45
* @ClassName ThreeSum
* @Description 
* 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
* 注意：答案中不可以包含重复的三元组。
*/

public class ThreeSum {
    
    private static boolean repeat(List<List<Integer>> nums, List<Integer> list) {
        int n1 = list.get(0);
        int n2 = list.get(1);
        int n3 = list.get(2);
        for (List<Integer> l: nums) {
            if (l.get(0) == n1 && l.get(1) == n2 && l.get(2) == n3) {
                return true;
            }
        }
        return false;
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        Collections.sort(numbers);
        for (int i = 0; i < nums.length; i++) {
            int j = i - 1;
            int k = i + 1;
            while(true) {
                if (j < 0 || k >= nums.length) {
                    break;
                }
                int n = numbers.get(i) + numbers.get(j) + numbers.get(k);
                if (n == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers.get(j));
                    list.add(numbers.get(i));
                    list.add(numbers.get(k));
                    Collections.sort(list);
                    if (!repeat(result, list)) {
                        result.add(list);
                    }
                    j--;
                    k++;
                } else {
                    if (n < 0) {
                        k++;
                    } else {
                        j--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            String[] numbers = input.split(" ");
            int[] nums = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                nums[i] = Integer.parseInt(numbers[i]);
            }
            List<List<Integer>> result = threeSum(nums);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
