package com.fhlxc.week11;
/**
* @author Xingchao Long
* @date 2020年3月20日 上午11:50:57
* @classname MinPathSum
* @description 
* 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
* 说明：每次只能向下或者向右移动一步。
* 示例:
* 输入:
* [
*   [1,3,1],
*   [1,5,1],
*   [4,2,1]
* ]
* 输出: 7
* 解释: 因为路径 1→3→1→1→1 的总和最小。
*/
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int column = grid[0].length;
        
        for (int i = 1; i < column; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1]);
            }
        }
        
        return grid[row - 1][column - 1];
    }
    
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1}
        };
        System.out.println(new MinPathSum().minPathSum(grid));
    }

}
