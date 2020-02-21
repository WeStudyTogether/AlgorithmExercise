package com.fhlxc.week07;

/**
* @author Xingchao Long
* @date 2020年2月21日 上午11:06:53
* @ClassName SolveSudoku
* @Description 
* 编写一个程序，通过已填充的空格来解决数独问题。
* 一个数独的解法需遵循如下规则：
*     数字 1-9 在每一行只能出现一次。
*     数字 1-9 在每一列只能出现一次。
*     数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
* 空白格用 '.' 表示。
*/

public class SolveSudoku {

    private boolean isValid(char[][] board, int count) {
        int row = count / 9;
        int column = count % 9;
        
        //判断行
        for (int i = 0; i < 9; i++) {
            if (i == column || board[row][i] == '.') {
                continue;
            }
            if (board[row][i] == board[row][column]) {
                return false;
            }
        }
        
        //判断列
        for (int i = 0; i < 9; i++) {
            if (i == row || board[i][column] == '.') {
                continue;
            }
            if (board[i][column] == board[row][column]) {
                return false;
            }
        }
        
        //判断方块
        int n = row / 3 * 27 + column / 3 * 3;
        
        int r = n / 9;
        int c = n % 9;
        
        for (int i = 0; i < 9; i++) {
            int p = i / 3;
            int q = i % 3;
            if (r + p == row && c + q == column) {
                continue;
            }
            if (board[r + p][c + q] == board[row][column]) {
                return false;
            }
        }
        
        return true;
    }
    
    private void backtrace(char[][] result, char[][] nums, int count) {
        if (count == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    result[i][j] = nums[i][j];
                }
            }
            return;
        }
        int r = count / 9;
        int c = count % 9;
        
        if (nums[r][c] == '.') {
            for (int i = 1; i < 10; i++) {
                nums[r][c] = (char) (i + '0');
                if (isValid(nums, count)) {
                    backtrace(result, nums, count + 1);
                }
            }
            nums[r][c] = '.';
        } else {
            backtrace(result, nums, count + 1);
        }
    }
    
    public void solveSudoku(char[][] board) {
        char[][] result = new char[9][9];
        backtrace(result, board, 0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = result[i][j];
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
                };

        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
