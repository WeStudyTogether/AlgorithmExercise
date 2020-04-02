package com.fhlxc.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年4月1日 上午9:52:40
* @classname Subsets
* @description 
* 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
* 说明：解集不能包含重复的子集。
* 示例:
* 输入: nums = [1,2,3]
* 输出:
* [
*   [3],
*   [1],
*   [2],
*   [1,2,3],
*   [1,3],
*   [2,3],
*   [1,2],
*   []
* ]
*/

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = 1;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        if (n >= 1) {
            for (int i = 0; i < n; i++) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(i);
                result.add(tmp);
            }
            start = end;
            end = result.size();
        }
        for (int i = 2; i <= n; i++) {
            for (int p = start; p < end; p++) {
                List<Integer> tmp = new ArrayList<Integer>(result.get(p));
                for (int q = tmp.get(tmp.size() - 1) + 1; q < n; q++) {
                    List<Integer> temp = new ArrayList<Integer>(tmp);
                    temp.add(q);
                    result.add(temp);
                }
            }
            start = end;
            end = result.size();
        }
        for (List<Integer> list: result) {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, nums[list.get(i)]);
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        String[] ns = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        System.out.println(new Subsets().subsets(nums));
    }

}
