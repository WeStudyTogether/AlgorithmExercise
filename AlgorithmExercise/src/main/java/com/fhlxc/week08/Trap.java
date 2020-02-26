package com.fhlxc.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年2月25日 下午2:44:24
* @ClassName Trap
* @Description 
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
* 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
* 输出: 6
*/

public class Trap {

    private int findSecond(int first, int[] height) {
        int i = first;
        int max = 0;
        for (i = i + 1; i < height.length; i++) {
            if (height[i] > height[first]) {
                return i;
            }
            if (max < height[i]) {
                max = height[i];
            }
        }
        for (i = first + 1; i < height.length; i++) {
            if (height[i] == max) {
                break;
            }
        }
        return i;
    }
    
    private int findFirst(int first, int[] height) {
        int i = first;
        for (; i < height.length - 1; i++) {
            if (height[i] > height[i + 1]) {
                break;
            }
        }
        return i;
    }
    
    public int trap(int[] height) {
        int first = 0;
        int second = 0;
        int result = 0;
        
        first = findFirst(0, height);
        second = findSecond(first, height);
        while (true) {
            if (first >= second || first == height.length || second == height.length) {
                break;
            }
            int min = Math.min(height[first], height[second]);
            result = result + (second - first - 1) * min;
            for (first = first + 1; first < second; first++) {
                if (height[first] > min) {
                    result -= min;
                } else {
                    result -= height[first];
                }
            }
            first = findFirst(first, height);
            second = findSecond(first, height);
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ns = reader.readLine().split(" ");
        int[] height = new int[ns.length];
        for (int i = 0; i < height.length; i++) {
            height[i] = Integer.parseInt(ns[i]);
        }
        System.out.println(new Trap().trap(height));
    }

}
