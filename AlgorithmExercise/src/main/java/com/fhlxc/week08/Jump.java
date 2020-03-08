package com.fhlxc.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年2月28日 下午3:46:31
* @ClassName Jump
* @Description 
*/

public class Jump {
    private int result = Integer.MAX_VALUE;
    
    //算法超时
    @SuppressWarnings("unused")
    private void backtrace(int start, int n, int[] nums) {
        if (start == nums.length - 1) {
            if (result > n) {
                result = n;
            }
            return;
        }
        if (start >= nums.length) {
            return;
        }
        if (n >= result) {
            return;
        }
        for (int i = nums[start]; i >= 1; i--) {
            backtrace(start + i, n + 1, nums);
        }
    }

    /**
     * 思路：每个位置均可达，那么记录每次能跳跃的最远距离，当i走到那个，最远距离，说明要跳到那里。
     */
    public int jump(int[] nums) {
        int max = 0;
        int tmp = 0;
        int r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(i + nums[i], max);
            if (i == tmp) {
                tmp = max;
                r++;
            }
        }
        return r;
    }
    
    public static void main(String[] args) throws IOException {
        String[] ns = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        System.out.println(new Jump().jump(nums));
    }

}
