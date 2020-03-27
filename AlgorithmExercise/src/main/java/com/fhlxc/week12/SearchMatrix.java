package com.fhlxc.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月27日 下午3:20:50
* @classname SearchMatrix
* @description 
* 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
*     每行中的整数从左到右按升序排列。
*     每行的第一个整数大于前一行的最后一个整数。
* 示例 1:
* 输入:
* matrix = [
*   [1,   3,  5,  7],
*   [10, 11, 16, 20],
*   [23, 30, 34, 50]
* ]
* target = 3
* 输出: true
* 示例 2:
* 输入:
* matrix = [
*   [1,   3,  5,  7],
*   [10, 11, 16, 20],
*   [23, 30, 34, 50]
* ]
* target = 13
* 输出: false
*/

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;
        int mid = (left + right) / 2;
        while (left <= right) {
            mid = left + right;
            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right == -1) {
            return false;
        }
        int i = right;
        left = 0;
        right = matrix[i].length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (matrix[i][mid] == target) {
                return true;
            }
            if (matrix[i][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] matrix = {
                  {1,   3,  5,  7}
                  };
        int target = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(new SearchMatrix().searchMatrix(matrix, target));
    }

}
