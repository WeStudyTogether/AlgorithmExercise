package com.fhlxc.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年4月9日 上午10:39:14
* @classname SubsetsWithDup
* @description 
* 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
* 说明：解集不能包含重复的子集。
* 示例:
* 输入: [1,2,2]
* 输出:
* [
*   [2],
*   [1],
*   [1,2,2],
*   [2,2],
*   [1,2],
*   []
* ]
*/

public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> init = new ArrayList<Integer>();
        init.add(-1);
        result.add(init);
        int start = 0;
        int end = result.size();
        for (int p = start; p < end; p++) {
            List<Integer> temp = result.get(p);
            int q = temp.remove(temp.size() - 1) + 1;
            List<Integer> t = new ArrayList<Integer>();
            for (; q < nums.length; q++) {
                if (!t.contains(nums[q])) {
                    List<Integer> tp = new ArrayList<Integer>(temp);
                    tp.add(nums[q]);
                    tp.add(q);
                    result.add(tp);
                    t.add(nums[q]);
                }
            }
            start = end;
            end = result.size();
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] ns = reader.readLine().split(" ");
        int[] nums = new int[ns.length];
        for (int i = 0; i < ns.length; i++) {
            nums[i] = Integer.parseInt(ns[i]);
        }
        System.out.println(new SubsetsWithDup().subsetsWithDup(nums));
    }

}
