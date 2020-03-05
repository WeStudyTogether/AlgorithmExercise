package com.fhlxc.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年3月5日 上午10:24:01
* @ClassName SolveNQueens
* @Description 
* n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
* 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
* 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
* 输入: 4
* 输出: [
*  [".Q..",  // 解法 1
*   "...Q",
*   "Q...",
*   "..Q."],
*  ["..Q.",  // 解法 2
*   "Q...",
*   "...Q",
*   ".Q.."]
* ]
* 解释: 4 皇后问题存在两个不同的解法。
*/

public class SolveNQueens {

    private char[][] result;
    private List<List<String>> solution = new ArrayList<>();
    
    private boolean queen(int i, int j, int n) {
        for (int k = 0; k < n; k++) {
            if (k == i) {
                continue;
            }
            if (result[k][j] == 'Q') {
                return false;
            }
        }
        for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
            if (result[k][l] == 'Q') {
                return false;
            }
        }
        for (int k = i + 1, l = j - 1; k < n && l >= 0; k++, l--) {
            if (result[k][l] == 'Q') {
                return false;
            }
        }
        for (int k = i + 1, l = j + 1; k < n && l < n; k++, l++) {
            if (result[k][l] == 'Q') {
                return false;
            }
        }
        for (int k = i - 1, l = j + 1; k >= 0 && l < n; k--, l++) {
            if (result[k][l] == 'Q') {
                return false;
            }
        }
        return true;
    }
    
    private void backtrace(int i, int n) {
        if (i == n) {
            List<String> a = new ArrayList<>();
            for (char[] c: result) {
                String s = "";
                for (char h: c) {
                    s += h;
                }
                a.add(s);
            }
            solution.add(a);
            return;
        }
        for (int k = 0; k < n; k++) {
            result[i][k] = 'Q';
            if (queen(i, k, n)) {
                backtrace(i + 1, n);
            } 
            result[i][k] = '.';
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        result = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = '.';
            }
        }
        backtrace(0, n);
        return solution;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(new SolveNQueens().solveNQueens(n));
    }

}
