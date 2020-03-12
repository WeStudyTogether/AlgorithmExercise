package com.fhlxc.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月12日 下午7:09:55
* @ClassName GenerateMatrix
* @Description 
* 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
* 示例:
* 输入: 3
* 输出:
* [
*  [ 1, 2, 3 ],
*  [ 8, 9, 4 ],
*  [ 7, 6, 5 ]
* ]
*/

public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int count = 1;
        int total = n * n;
        int i = 0;
        int j = 0;
        int circul = 0;
        while (count <= total) {
            result[i][j] = count;
            if (i == circul && j < circul + n - 1) {
                j++;
            } else {
                if (j == circul+ n - 1 && i < circul + n - 1) {
                    i++;
                } else {
                    if (i == circul + n - 1 && j != circul) {
                        j--;
                    } else {
                        if (j == circul && i != circul) {
                            i--;
                        }
                    }
                }
            }
            if (i == circul && j == circul) {
                circul++;
                i = j = circul;
                n -= 2;
            }
            count++;
        }
        return result;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] result = new GenerateMatrix().generateMatrix(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        for (int[] r: result) {
            for (int i: r) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

}
