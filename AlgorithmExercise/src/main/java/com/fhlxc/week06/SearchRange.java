package com.fhlxc.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年2月16日 下午1:51:26
* @ClassName SearchRange
* @Description
* 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
* 你的算法时间复杂度必须是 O(log n) 级别。
* 如果数组中不存在目标值，返回 [-1, -1]。
* 示例 1:
* 输入: nums = [5,7,7,8,8,10], target = 8
* 输出: [3,4]
* 示例 2:
* 输入: nums = [5,7,7,8,8,10], target = 6
* 输出: [-1,-1]
*/

public class SearchRange {
    
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
            if (target == nums[mid]) {
                list.add(mid);
                for (int k = 0; ; k++) {
                    if (mid - k < 0 && mid + k >= nums.length ) {
                        break;
                    }
                    boolean b = true;
                    if (mid - k >= 0) {
                        if (nums[mid - k] == nums[mid]) {
                            list.add(mid - k);
                            b = false;
                        }
                    }
                    if (mid + k < nums.length) {
                        if (nums[mid + k] == nums[mid]) {
                            list.add(mid + k);
                            b = false;
                        }
                    }
                    if (b) {
                        break;
                    }
                }
                break;
            }
        }
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        if (list.size() == 0) {
            result[0] = result[1] = -1;
            return result;
        }
        for (Integer i: list) {
            if (result[0] > i) {
                result[0] = i;
            }
            if (result[1] < i) {
                result[1] = i;
            }
        }
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
        SearchRange searchRange = new SearchRange();
        int[] r = searchRange.searchRange(nums, target);
        for (int i: r) {
            System.out.print(i + " ");
        }
    }

}
