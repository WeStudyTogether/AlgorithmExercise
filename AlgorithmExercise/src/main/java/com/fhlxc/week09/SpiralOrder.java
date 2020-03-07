package com.fhlxc.week09;

import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年3月7日 上午10:49:55
* @ClassName SpiralOrder
* @Description 
* 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
* 示例 1:
* 输入:
* [
*  [ 1, 2, 3 ],
*  [ 4, 5, 6 ],
*  [ 7, 8, 9 ]
* ]
* 输出: [1,2,3,6,9,8,7,4,5]
* 示例 2:
* 输入:
* [
*   [1, 2, 3, 4],
*   [5, 6, 7, 8],
*   [9,10,11,12]
* ]
* 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int height = matrix.length;
        if (height == 0) {
            return result;
        }
        int width = matrix[0].length;
        int n;
        
        if (Math.min(width, height) % 2 == 0) {
            n = Math.min(width, height) / 2;
        } else {
            n = Math.min(width, height) / 2 + 1;
        }
        
        for (int i = 0; i < n; i++) {
            int p = i;
            int q = i;
            int w = width - 2 * i - 1;
            int h = height - 2 * i - 1;
            result.add(matrix[p][q]);
            while (true) {
                if (p == i && q != i + w) {
                    q++;
                } else {
                    if (p == i + h && q != i) {
                        q--;
                    } else {
                        if (q == i + w && p != i + h) {
                            p++;
                        } else {
                            if (q == i && p != i) {
                                p--;
                            }
                        }
                    }
                }
                if (p == i && q == i) {
                    break;
                }
                result.add(matrix[p][q]);
                if (h == 0) {
                    if (q == i + w) {
                        break;
                    }
                }
                if (w == 0) {
                    if (p == i + h) {
                        break;
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {2,3,3},
            {4,5,6},
            {7,5,9}
        };
        System.out.println(new SpiralOrder().spiralOrder(matrix));
    }

}
