package com.fhlxc.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年2月13日 下午2:53:52
* @ClassName SearchInsert
* @Description 
* 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
* 你可以假设数组中无重复元素。
* 示例 1:
* 输入: [1,3,5,6], 5
* 输出: 2
* 示例 2:
* 输入: [1,3,5,6], 2
* 输出: 1
* 示例 3:
* 输入: [1,3,5,6], 7
* 输出: 4
* 示例 4:
* 输入: [1,3,5,6], 0
* 输出: 0
*/

public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        int result = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= target) {
                break;
            }
        }
        result = i;
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ns = reader.readLine().split(" ");
        int target = Integer.parseInt(reader.readLine());
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(nums, target));
    }

}
