package com.fhlxc.week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年3月1日 上午11:12:05
* @ClassName PermuteUnique
* @Description 
*/

public class PermuteUnique {

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    private void backtrace(List<Integer> tmp, List<Integer> nums) {
        int n = nums.size();
        List<Integer> list = new ArrayList<>();
        if (n == 0) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < n; i++) {
            Integer t = nums.get(i);
            if (list.contains(t)) {
                continue;
            }
            tmp.add(t);
            nums.remove(i);
            backtrace(tmp, nums);
            nums.add(i, t);
            tmp.remove(tmp.size() - 1);
            list.add(t);
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (Integer i: nums) {
            numbers.add(i);
        }
        backtrace(new ArrayList<>(), numbers);
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        String[] ns = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        System.out.println(new PermuteUnique().permuteUnique(nums));
    }

}
