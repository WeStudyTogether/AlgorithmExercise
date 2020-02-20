package com.fhlxc.week07;

import java.util.ArrayList;
import java.util.List;

/**
* @author Xingchao Long
* @date 2020年2月20日 下午3:05:20
* @ClassName IsValidSudoku
* @Description 
* 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
*    数字 1-9 在每一行只能出现一次。
*    数字 1-9 在每一列只能出现一次。
*    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
* 数独部分空格内已填入了数字，空白格用 '.' 表示。。
*/

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int raw = i / 3;
            int column = i % 3;
            int begin = raw * 27 + column * 3;
            List<Character> list = new ArrayList<Character>();
            for (int j = 0; j < 9; j++) {
                int r = j / 3;
                int c = j % 3;
                int x = begin + r * 9 + c;
                r = x / 9;
                c = x % 9;
                if (board[r][c] == '.') {
                    continue;
                }
                for (Character ca: list) {
                    if (ca == board[r][c]) {
                        return false;
                    }
                }
                list.add(board[r][c]);
                for (int k = 1; k < 9 - c; k++) {
                    if (board[r][c] == board[r][c + k]) {
                        return false;
                    }
                }
                for (int k = 1; k < 9 - r; k++) {
                    if (board[r][c] == board[r + k][c]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        char[][] board = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
                };

        IsValidSudoku isValidSudoku = new IsValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(board));
    }

}
