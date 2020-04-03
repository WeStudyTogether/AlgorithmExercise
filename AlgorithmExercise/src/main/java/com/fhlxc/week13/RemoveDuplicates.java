package com.fhlxc.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年4月3日 上午10:49:05
* @classname RemoveDuplicates
* @description 
* 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
* 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
* 示例 1:
* 给定 nums = [1,1,1,2,2,3],
* 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
* 你不需要考虑数组中超出新长度后面的元素。
* 示例 2:
* 给定 nums = [0,0,1,1,1,1,2,3,3],
* 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
* 你不需要考虑数组中超出新长度后面的元素。
*/

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int nowPosition = -1;
        int count = 1;
        if (length == 0) {
            return 0;
        }
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tmp == nums[i]) {
                count++;
            } else {
                if (count > 2) {
                    length = length - count + 2;
                }
                count = 1;
                tmp = nums[i];
            }
            if (nowPosition == -1 && count > 2) {
                nowPosition = i;
            }
            if (count < 3 && nowPosition != -1) {
                nums[nowPosition] = nums[i];
                nowPosition++;
            }
        }
        if (count > 2) {
            length = length - count + 2;
        }
        return length;
    }
    
    public static void main(String[] args) throws IOException {
        String[] ns = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        int length = new RemoveDuplicates().removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
