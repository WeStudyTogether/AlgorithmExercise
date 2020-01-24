package com.fhlxc.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/57/24 15:57:44
* @ClassName MaxArea
* @Description
* 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 
* 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
* 输入：1 8 6 2 5 4 8 3 7
* 输出：49
*/

public class MaxArea {
    
    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        int tmp;
        while (true) {
            if (i == j) {
                break;
            }
            if (height[i] < height[j]) {
                tmp = (j - i) * height[i];
                if (max < tmp) {
                    max = tmp;
                }
                i++;
            } else {
                tmp = (j - i) * height[j];
                if (max < tmp) {
                    max = tmp;
                }
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int[] height = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                height[i] = Integer.parseInt(input[i]);
            }
            System.out.println(maxArea(height));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
