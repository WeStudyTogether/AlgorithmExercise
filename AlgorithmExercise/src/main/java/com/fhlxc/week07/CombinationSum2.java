package com.fhlxc.week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年2月23日 上午10:56:59
* @ClassName CombinationSum2
* @Description 
* 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
* candidates 中的每个数字在每个组合中只能使用一次。
* 说明：
*     所有数字（包括目标数）都是正整数。
*     解集不能包含重复的组合。 
* 示例 1:
* 输入: candidates = [10,1,2,7,6,1,5], target = 8,
* 所求解集为:
* [
*   [1, 7],
*   [1, 2, 5],
*   [2, 6],
*   [1, 1, 6]
* ]
* 示例 2:
* 输入: candidates = [2,5,2,1,2], target = 5,
* 所求解集为:
* [
*   [1,2,2],
*   [5]
* ]
*/

public class CombinationSum2 {
    
    private void backTrace(List<List<Integer>> result, List<Integer> tmp, int[] candidates, int start, int sum, int target) {
        for (int i = start; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            int t = sum + candidates[i];
            if (t == target) {
                List<Integer> l = new ArrayList<>(tmp);
                if (!result.contains(l)) {
                    result.add(l);
                }
            } else {
                if (t < target) {
                    backTrace(result, tmp, candidates, i + 1, t, target);
                } else {
                    tmp.remove(tmp.size() - 1);
                    break;
                }
            }
            tmp.remove(tmp.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrace(result, new ArrayList<>(), candidates, 0, 0, target);
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
        System.out.println(new CombinationSum2().combinationSum2(candidates, target));
    }

}
