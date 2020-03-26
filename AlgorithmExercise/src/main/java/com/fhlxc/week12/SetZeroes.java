package com.fhlxc.week12;

/**
* @author Xingchao Long
* @date 2020年3月26日 上午10:09:20
* @classname SetZeroes
* @description 
* 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
* 示例 1:
* 输入: 
* [
*   [1,1,1],
*   [1,0,1],
*   [1,1,1]
* ]
* 输出: 
* [
*   [1,0,1],
*   [0,0,0],
*   [1,0,1]
* ]
* 示例 2:
* 输入: 
* [
*   [0,1,2,0],
*   [3,4,5,2],
*   [1,3,1,5]
* ]
* 输出: 
* [
*   [0,0,0,0],
*   [0,4,5,0],
*   [0,3,1,0]
* ]
*/

public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        
        if (matrix.length == 0) {
            return;
        }
        
        int[] toZero = new int[matrix.length + matrix[0].length];
        
        for (int i = 0; i < toZero.length; i++) {
            toZero[i] = 0;
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    toZero[i] = 1;
                    toZero[j + matrix.length] = 1;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            if (toZero[i] == 1) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int j = 0; j <  matrix[0].length; j++) {
            if (toZero[j + matrix.length] == 1) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1}
        };
        new SetZeroes().setZeroes(matrix);
        for (int[] m: matrix) {
            for (int i: m) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
