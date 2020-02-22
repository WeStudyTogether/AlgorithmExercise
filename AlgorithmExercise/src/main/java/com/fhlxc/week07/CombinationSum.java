package com.fhlxc.week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年2月22日 下午3:30:32
* @ClassName CombinationSum
* @Description 
* 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
* candidates 中的数字可以无限制重复被选取。
* 输入: candidates = [2,3,6,7], target = 7,
* 所求解集为:
* [
*   [7],
*   [2,2,3]
* ]
*/

public class CombinationSum {
    
    private void find(List<List<Integer>> result, List<Integer> r, int start, int target, int sum, int[] candidates) {
        for (int i = start; i < candidates.length; i++) {
            r.add(candidates[i]); 
            if (sum + candidates[i] == target) {
                result.add(new ArrayList<>(r));
            } else {
                if (sum + candidates[i] < target) {
                    find(result, r, i, target, sum + candidates[i], candidates);
                } else {
                    r.remove(r.size() - 1);
                    break;
                }
            }
            r.remove(r.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        find(result, new ArrayList<Integer>(), 0, target, 0, candidates);
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] cs = reader.readLine().split(" ");
        int target = Integer.parseInt(reader.readLine());
        int[] candidates = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            candidates[i] = Integer.parseInt(cs[i]);
        }
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }

}
