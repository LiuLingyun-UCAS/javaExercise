package com.lly.chapter08.leetcode;

import java.util.Stack;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class Offer12 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {{'A','B','C','E'},
                          {'S','F','E','S'},
                          {'A','D','E','E'}};
        String word = "ABCEFSADEESE";
        System.out.println(solution.exist(board, word));
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, i, j, w)){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, int row, int column, char[] word){
        boolean[][] visited = new boolean[board.length][board[0].length];
        int[][] offset = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        if(board[row][column] != word[0]){
            return false;
        }

        Stack<Position> st = new Stack<>();
        st.push(new Position(row, column, 0));
        visited[row][column] = true;
        int cur = 1;
        if(cur == word.length) return true;

        while(!st.empty()){
            Position p = st.peek();
            int x = p.x;
            int y = p.y;
            int dir = p.dir;
            for(int i = dir; i < 4; i++){
                int nextX = x + offset[i][0];
                int nextY = y + offset[i][1];

                if(nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length
                        && !visited[nextX][nextY] && board[nextX][nextY] == word[cur]){
                    if(cur == word.length - 1) return true;
                    st.push(new Position(nextX, nextY, 0));
                    p.dir = i + 1;
                    visited[nextX][nextY] = true;
                    cur++;
                    break;
                }else if(i == 3){
                    st.pop();
                    visited[x][y] = false;
                    cur--;
                }
            }
        }
        return false;

    }
}

class Position{
    int x;
    int y;
    int dir;

    public Position(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
