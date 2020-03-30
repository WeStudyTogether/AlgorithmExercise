package com.fhlxc.week13;

import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年3月30日 下午4:41:45
* @classname Merge
* @description 
* 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
* 说明:
*     初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
*     你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
* 示例:
* 输入:
* nums1 = [1,2,3,0,0,0], m = 3
* nums2 = [2,5,6],       n = 3
* 输出: [1,2,2,3,5,6]
*/

public class Merge {
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> lists = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        for (; i < m && j < n; ) {
            if (nums1[i] < nums2[j]) {
                lists.add(nums1[i]);
                i++;
            } else {
                lists.add(nums2[j]);
                j++;
            }
        }
        while (i < m) {
            lists.add(nums1[i]);
            i++;
        }
        while (j < n) {
            lists.add(nums2[j]);
            j++;
        }
        i = 0;
        for (Integer t: lists) {
            nums1[i] = t;
            i++;
        }
    }
    
    public static void main(String ... args) {
        int[] nums1 = {1, 2, 5, 0, 0, 0};
        int[] nums2 = {0, 5, 6};
        new Merge().merge(nums1, 3, nums2, 3);
        for (Integer i: nums1) {
            System.out.print(i + " ");
        }
    }
    
}
