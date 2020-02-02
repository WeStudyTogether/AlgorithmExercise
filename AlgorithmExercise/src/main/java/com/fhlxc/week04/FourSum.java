package com.fhlxc.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年2月2日 下午4:08:35
* @ClassName FourSum
* @Description 四数相加
*/

public class FourSum {

    private static boolean repeat(List<List<Integer>> nums, List<Integer> list) {
        int n1 = list.get(0);
        int n2 = list.get(1);
        int n3 = list.get(2);
        int n4 = list.get(3);
        for (List<Integer> l: nums) {
            if (l.get(0) == n1 && l.get(1) == n2 && l.get(2) == n3 && l.get(3) == n4) {
                return true;
            }
        }
        return false;
    }
    
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        Collections.sort(numbers);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int m = j + 1; m < nums.length; m++) {
                    for (int n = m + 1; n < nums.length; n++) {
                        int x = numbers.get(i) + numbers.get(j) + numbers.get(m) + numbers.get(n) - target;
                        if (x == 0) {
                            List<Integer> list = new ArrayList<>();
                            list.add(numbers.get(i));
                            list.add(numbers.get(j));
                            list.add(numbers.get(m));
                            list.add(numbers.get(n));
                            Collections.sort(list);
                            if (!repeat(result, list)) {
                                result.add(list);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String numbers = reader.readLine();
        int target = Integer.parseInt(reader.readLine());
        String[] ns = numbers.split(" ");
        int[] nums = new int[ns.length];
        int i = 0;
        for (String s: ns) {
            nums[i] = Integer.parseInt(s);
            i++;
        }
        System.out.println(fourSum(nums, target));
    }

}
