package com.fhlxc.week13;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* @author Xingchao Long
* @date 2020年4月2日 上午11:25:24
* @classname Exist
* @description 
* 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
* 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
* 示例:
* board =
* [
*   ['A','B','C','E'],
*   ['S','F','C','S'],
*   ['A','D','E','E']
* ]
* 给定 word = "ABCCED", 返回 true
* 给定 word = "SEE", 返回 true
* 给定 word = "ABCB", 返回 false
* 提示：
*     board 和 word 中只包含大写和小写英文字母。
*     1 <= board.length <= 200
*     1 <= board[i].length <= 200
*     1 <= word.length <= 10^3
*/

public class Exist {

    private boolean result = false;
    private Point point = new Point();
    
    private void find(char[][] board, String word, int i) {
        if (i == word.length()) {
            result = true;
            return;
        }
        if (result == true) {
            return;
        }
        char tmp = '.';
        if (point.y - 1 >= 0) {
            if (board[point.x][point.y - 1] == word.charAt(i) && board[point.x][point.y - 1] != '.') {
                point.y--;
                tmp = board[point.x][point.y];
                board[point.x][point.y] = '.';
                find(board, word, i + 1);
                board[point.x][point.y] = tmp;
                point.y++;
            }
        }
        if (result == true) {
            return;
        }
        if (point.x - 1 >= 0) {
            if (board[point.x - 1][point.y] == word.charAt(i)) {
                point.x--;
                tmp = board[point.x][point.y];
                board[point.x][point.y] = '.';
                find(board, word, i + 1);
                board[point.x][point.y] = tmp;
                point.x++;
            }
        }
        if (result == true) {
            return;
        }
        if (point.y + 1 < board[0].length) {
            if (board[point.x][point.y + 1] == word.charAt(i)) {
                point.y++;
                tmp = board[point.x][point.y];
                board[point.x][point.y] = '.';
                find(board, word, i + 1);
                board[point.x][point.y] = tmp;
                point.y--;
            }
        }
        if (result == true) {
            return;
        }
        if (point.x + 1 < board.length) {
            if (board[point.x + 1][point.y] == word.charAt(i)) {
                point.x++;
                tmp = board[point.x][point.y];
                board[point.x][point.y] = '.';
                find(board, word, i + 1);
                board[point.x][point.y] = tmp;
                point.x--;
            }
        }
    }
    
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return false;
        }
        out: for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    point.x = i;
                    point.y = j;
                    char tmp = board[i][j];
                    board[i][j] = '.';
                    find(board, word, 1);
                    board[i][j] = tmp;
                    if (result == true) {
                        break out;
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        char[][] board = {
            {'b', 'a', 'b', 'a'},
            {'b', 'a', 'a', 'a'}
        };
        System.out.println(new Exist().exist(board, new BufferedReader(new InputStreamReader(System.in)).readLine()));
    }

}
