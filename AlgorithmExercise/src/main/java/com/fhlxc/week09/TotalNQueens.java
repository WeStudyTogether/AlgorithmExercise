package com.fhlxc.week09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年3月6日 上午9:32:29
* @ClassName TotalNQueens
* @Description 
* 找出n皇后问题解法的个数
*/

public class TotalNQueens {

    private char[][] result;
    private int total = 0;
    
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
            total++;
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
    
    public int totalNQueens(int n) {
        result = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = '.';
            }
        }
        backtrace(0, n);
        return total;
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        System.out.println(new TotalNQueens().totalNQueens(n));
    }

}
