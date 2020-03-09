package com.fhlxc.week10;

import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年3月9日 上午9:21:53
* @ClassName Merge
* @Description 
* 给出一个区间的集合，请合并所有重叠的区间。
* 示例 1:
* 输入: [[1,3],[2,6],[8,10],[15,18]]
* 输出: [[1,6],[8,10],[15,18]]
* 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
* 示例 2:
* 输入: [[1,4],[4,5]]
* 输出: [[1,5]]
* 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
*/

public class Merge {

    private boolean overlap(Integer[] interval1, Integer[] interval2) {
        return Math.min(interval1[1], interval2[1]) >= Math.max(interval1[0], interval2[0]);
    }
    
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer[] t = {intervals[i][0], intervals[i][1]};
            list.add(t);
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            boolean back = false;
            for (int j = i + 1; j < list.size(); j++) {
                Integer[] interval1 = list.get(i);
                Integer[] interval2 = list.get(j);
                if (overlap(interval1, interval2)) {
                    left = Math.min(interval1[0], interval2[0]);
                    right = Math.max(interval1[1], interval2[1]);
                    list.set(i, new Integer[] {left, right});
                    list.remove(j);
                    back = true;
                }
            }
            if (back) {
                i--;
            }
        }
        int[][] result = new int[list.size()][2];
        n = list.size();
        for (int i = 0; i < n; i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};
        int[][] result = new Merge().merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

}
