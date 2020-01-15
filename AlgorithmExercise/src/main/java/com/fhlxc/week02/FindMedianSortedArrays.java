package com.fhlxc.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/19/15 10:19:43
* @ClassName FindMedianSortedArrays
* @Description 
* 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
* 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
* 你可以假设 nums1 和 nums2 不会同时为空。
*/

public class FindMedianSortedArrays {
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        int j = 0;
        int k = 0;
        double middle = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (j >= nums1.length) {
                for (; k < nums2.length; k++) {
                    nums[i] = nums2[k];
                    i++;
                }
                break;
            }
            if (k >= nums2.length) {
                for (; j < nums1.length; j++) {
                    nums[i] = nums1[j];
                    i++;
                }
                break;
            }
            if (nums1[j] < nums2[k]) {
                nums[i] = nums1[j];
                j++;
            } else {
                nums[i] = nums2[k];
                k++;
            }
        }
        if (nums.length % 2 == 0) {
            int n = nums.length / 2;
            middle = (double) (nums[n - 1] + nums[n]) / 2;
        } else {
            int n = nums.length / 2;
            middle = nums[n];
        }
        return middle;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String nums1 = reader.readLine();
            String nums2 = reader.readLine();
            String[] strings;
            strings = nums1.split(" ");
            int[] num1 = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                num1[i] = Integer.parseInt(strings[i]);
            }
            strings = nums2.split(" ");
            int[] num2 = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                num2[i] = Integer.parseInt(strings[i]);
            }
            System.out.println(findMedianSortedArrays(num1, num2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
