package com.fhlxc.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    
    private int[] find(int[] nums, int i, int j, int[] result) {
        int m = i;
        int n = j;
        
        for (m = i; m >= j; m--) {
            for (n = j; n < m; n++) {
                if (m == i && n == j) {
                    continue;
                }
                if (nums[m] > nums[n]) {
                    if (n == j) {
                        if (nums[m] >= nums[i]) {
                            continue;
                        }
                    }
                    result[0] = m;
                    result[1] = n;
                    result[2] = 1;
                    return result;
                }
            }
        }
        result[2] = 0;
        return result;
    }
    
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        int j = 0;
        int[] r = {0, 0, 0};
        
        out: for (; i >= 0; i--) {
            for (j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    r[0] = i;
                    r[1] = j;
                    r[2] = 1;
                    break out;
                }
            }
        }
        
        int t = 0;
        
        if (r[2] == 0) {
            for (i = r[1]; i < nums.length; i++) {
                for (j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        t = nums[i];
                        nums[i] = nums[j];
                        nums[j] = t;
                    }
                }
            } 
            return;
        }
        
        while (r[2] == 1) {
            r = find(nums, r[0], r[1], r);
        }
        t = nums[r[0]];
        nums[r[0]] = nums[r[1]];
        nums[r[1]] = t;
        for (i = r[1] + 1; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
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
