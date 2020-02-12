package com.fhlxc.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Xingchao Long
 * @date 2020年2月12日 上午11:26:19
 * @ClassName NextPermutation
 * @Description 
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 必须原地修改，只允许使用额外常数空间。
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
 * 1,2,3 → 1,3,2 
 * 3,2,1 → 1,2,3 
 * 1,1,5 → 1,5,1
 */

public class NextPermutation {
    
    private boolean swap(int[] nums, int i, int j) {
        boolean result = false;
    }
    
    public void nextPermutation(int[] nums) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    return;
                }
            }
            queue.add(nums[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ns = reader.readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
