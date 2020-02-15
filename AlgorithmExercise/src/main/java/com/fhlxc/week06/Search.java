package com.fhlxc.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年2月15日 下午3:02:33
* @ClassName Search
* @Description 
* 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
* ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
* 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
* 你可以假设数组中不存在重复的元素。
* 你的算法时间复杂度必须是 O(log n) 级别。
* 示例 1:
* 输入: nums = [4,5,6,7,0,1,2], target = 0
* 输出: 4
* 示例 2:
* 输入: nums = [4,5,6,7,0,1,2], target = 3
* 输出: -1
*/

public class Search {

    public int search(int[] nums, int target) {
        int result = -1;
        int i = 0;
        int length = nums.length;
        if (nums.length == 0) {
            return -1;
        }
        if (target < nums[0]) {
            i = nums.length - 1;
            for (;i >= 0 ; i--) {
                if (target == nums[i]) {
                    result = i;
                    break;
                }
                if (i > 0) {
                    if (nums[i - 1] > nums[i]) {
                        break;
                    }
                }
            }
        } else {
            i = 0;
            for (;i < length; i++) {
                if (target == nums[i]) {
                    result = i;
                    break;
                }
                if (i < length - 1) {
                    if (nums[i + 1] < nums[i]) {
                        break;
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        String[] ns = reader.readLine().split(" ");
        int target = Integer.parseInt(reader.readLine());
        int[] nums = new int[ns.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        Search search = new Search();
        System.out.println(search.search(nums, target));
    }

}
