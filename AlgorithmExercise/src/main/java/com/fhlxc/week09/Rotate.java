package com.fhlxc.week09;

/**
* @author Xingchao Long
* @date 2020年3月2日 上午11:32:19
* @ClassName Rotate
* @Description 
*/

public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        int c = n / 2;
        for (int i = 0; i < c; i++) {
            int l = n - 2 * i - 1;
            for (int k = 0; k < l; k++) {
                int p = i;
                int q = p;
                int last = matrix[p][q];
                int tmp = 0;
                while (true) {
                    if (p == i && q != i + l) {
                        q++;
                    } else {
                        if (p == i + l && q != i) {
                            q--;
                        } else {
                            if (q == i + l && p != i + l) {
                                p++;
                            } else {
                                if (q == i && p != i) {
                                    p--;
                                }
                            }
                        }
                    }
                    tmp = matrix[p][q];
                    matrix[p][q] = last;
                    last = tmp;
                    if (p == i && q == i) {
                        break;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {15,13, 2, 5},
            {14, 3, 4, 1},
            {12, 6, 8, 9},
            {16, 7,10,11}
        };
        new Rotate().rotate(matrix);
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
