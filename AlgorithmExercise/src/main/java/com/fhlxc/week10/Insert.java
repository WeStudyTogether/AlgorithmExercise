package com.fhlxc.week10;

import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年3月10日 下午3:49:41
* @ClassName Insert
* @Description
* 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
* 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
* 示例 1:
* 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
* 输出: [[1,5],[6,9]]
* 示例 2:
* 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
* 输出: [[1,2],[3,10],[12,16]]
* 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
*/

public class Insert {

    private boolean overlap(Integer[] interval1, Integer[] interval2) {
        return Math.min(interval1[1], interval2[1]) >= Math.max(interval1[0], interval2[0]);
    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer[]> list = new ArrayList<>();
        int[][] result;
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            list.add(new Integer[] {intervals[i][0], intervals[i][1]});
        }
        if (newInterval.length == 0) {
            return intervals;
        }
        
        int left = 0; 
        int right = 0;
        Integer[] newIntegers = {newInterval[0], newInterval[1]}; 
        
        int curr = 0;
        n = list.size();
        for (int i = 0; i < n; i++) {
            Integer[] tmp = list.get(i);
            if (newIntegers[0] < tmp[0]) {
                list.add(i, newIntegers);
                curr = i;
                break;
            }
            if (i == n - 1) {
                list.add(newIntegers);
                curr = i + 1;
            }
        }
        
        for (int i = curr + 1; i < list.size(); i++) {
            Integer[] tmp = list.get(i);
            if (overlap(list.get(curr), tmp)) {
                left = Math.min(list.get(curr)[0], tmp[0]);
                right = Math.max(list.get(curr)[1], tmp[1]);
                list.set(curr, new Integer[] {left, right});
                list.remove(i);
                i--;
            }
        }
        for (int i = curr - 1; i >= 0; i--) {
            Integer[] tmp = list.get(i);
            if (curr == i) {
                break;
            }
            if (overlap(list.get(curr), tmp)) {
                left = Math.min(list.get(curr)[0], tmp[0]);
                right = Math.max(list.get(curr)[1], tmp[1]);
                list.set(curr, new Integer[] {left, right});
                list.remove(i);
                curr--;
                i++;
            }
        }
        
        if (intervals.length == 0) {
            list.add(newIntegers);
        }
        
        n = list.size();
        result = new int[n][2];
        for (int i = 0; i < n; i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        int[][] result = new Insert().insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

}
