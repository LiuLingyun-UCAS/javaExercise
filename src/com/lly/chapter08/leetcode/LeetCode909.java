package com.lly.chapter08.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 刘凌云
 * @version 1.0
 */
public class LeetCode909 {
    public static void main(String[] args) {
        System.out.println(
                new LeetCode909Solution().snakesAndLadders(
                        new int[][]{{-1, -1, -1, -1, -1, -1},
                                {-1, -1, -1, -1, -1, -1},
                                {-1, -1, -1, -1, -1, -1},
                                {-1, 35, -1, -1, 13, -1},
                                {-1, -1, -1, -1, -1, -1},
                                {-1, 15, -1, -1, -1, -1}}
                ));
    }
}

class LeetCode909Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    arr[idx++] = board[n - 1 - i][j];
                } else {
                    arr[idx++] = board[n - 1 - i][n - 1 - j];
                }
            }
        }

        int[] visit = new int[n * n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visit[0] = 1;
        int ans = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                int pos = queue.poll();
                if (pos == n * n - 1) {
                    return ans;
                }
                for (int j = 1; j <= 6; j++) {
                    if (pos + j < n * n) {
                        if (arr[pos + j] == -1 && visit[pos + j] == 0) {
                            queue.offer(pos + j);
                            visit[pos + j] = 1;
                        } else if (arr[pos + j] != -1 && visit[arr[pos + j] - 1] == 0) {
                            queue.offer(arr[pos + j] - 1);
                            visit[arr[pos + j] - 1] = 1;
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
