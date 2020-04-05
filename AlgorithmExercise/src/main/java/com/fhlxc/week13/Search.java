package com.fhlxc.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年4月5日 上午11:02:32
* @classname Search
* @description 
* 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
* ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
* 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
* 示例 1:
* 输入: nums = [2,5,6,0,0,1,2], target = 0
* 输出: true
* 示例 2:
* 输入: nums = [2,5,6,0,0,1,2], target = 3
* 输出: false
*/

public class Search {

    private boolean oneOfTwo(int[] nums, int start, int end, int target) {
        int middle = 0;
        int left = start;
        int right = end;
        while (left <= right) {
            middle = (left + right) / 2;
            if (target == nums[middle]) {
                return true;
            }
            if (target > nums[middle]) {
                left = middle + 1;
            } 
            if (target < nums[middle]) {
                right = middle - 1;
            }
        }
        return false;
    }
    
    public boolean search(int[] nums, int target) {
        int middle = 0;
        boolean b = false;
        if (nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (target == nums[i]) {
                return true;
            }
            if (nums[i] > nums[i + 1]) {
                middle = i;
            }
        }
        if (nums[nums.length - 1] == target) {
            return true;
        }
        b = oneOfTwo(nums, middle + 1, nums.length - 1, target);
        return b;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ns = reader.readLine().split(" ");
        int target = Integer.parseInt(reader.readLine());
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        System.out.println(new Search().search(nums, target));
    }

}
