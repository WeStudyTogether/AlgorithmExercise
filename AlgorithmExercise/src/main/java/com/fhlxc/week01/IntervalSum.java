package com.fhlxc.week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020/54/12 16:54:32
* @ClassName IntervalSum
* @Description 
* 由N个整数组成的数组，其中连续K个元素构成一个区间，称为K区间。
* 一个K区间内的所有素数的和记为Sk，请计算整个数组中，所有K区间的最大Sk值，并输出。
* 输入说明：第一行是两个整数N和K，第二行输入N个数，表示数组中的元素。
* 输出说明：最大Sk值
* 输入样例：8 2
* 12 23 27 34 19 17 45 8
* 输出样例：36
*/

public class IntervalSum {

    private static int primes(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return 0;
            }
        }
        return num;
    }
    
    public static int intervalSum(int[] nums, int k) {
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < length - k; i += k) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                if (i + j < length) {
                    sum += primes(nums[i + j]);
                }
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String string1 = reader.readLine();
            String[] strings = string1.split(" ");
            int n = Integer.parseInt(strings[0]);
            int k = Integer.parseInt(strings[1]);
            String string2 = reader.readLine();
            String[] strings1 = string2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(strings1[i]);
            }
            System.out.println(intervalSum(nums, k));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
