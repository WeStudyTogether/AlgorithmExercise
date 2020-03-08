package com.fhlxc.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月8日 上午10:43:13
* @ClassName CanJump
* @Description 
* 给定一个非负整数数组，你最初位于数组的第一个位置。
* 数组中的每个元素代表你在该位置可以跳跃的最大长度。
* 判断你是否能够到达最后一个位置。
* 示例 1:
* 输入: [2,3,1,1,4]
* 输出: true
* 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
* 示例 2:
* 输入: [3,2,1,0,4]
* 输出: false
* 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
*/

public class CanJump {
    
    public boolean canJump(int[] nums) {
        int jump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > jump) {
                return false;
            }
            jump = Math.max(jump, i + nums[i]);
            if (jump > nums.length) {
                break;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        String[] ns = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        System.out.println(new CanJump().canJump(nums));
    }

}
