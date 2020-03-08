package com.fhlxc.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月8日 上午10:43:13
* @ClassName CanJump
* @Description 
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
