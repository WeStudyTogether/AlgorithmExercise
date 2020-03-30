package com.fhlxc.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月28日 上午10:34:17
* @classname SortColors
* @description 
* 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
* 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
* 注意:
* 不能使用代码库中的排序函数来解决这道题。
* 示例:
* 输入: [2,0,2,1,1,0]
* 输出: [0,0,1,1,2,2]
* 进阶：
*     一个直观的解决方案是使用计数排序的两趟扫描算法。
*     首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
*     你能想出一个仅使用常数空间的一趟扫描算法吗？
*/

public class SortColors {
    
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                i = left;
                left++;
            } else {
                if (nums[i] == 2) {
                    nums[i] = nums[right];
                    nums[right] = 2;
                    right--;
                    i = left - 1;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) throws IOException {
        String[] ns = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        new SortColors().sortColors(nums);
        for (int i: nums) {
            System.out.print(i + " ");
        }
    }

}
