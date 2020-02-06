package com.vc.hard;

import java.util.*;

class L1301 {
    int MOD = (int)1e9 + 7;
    class State {
        int sum = 0, count = 0;

        State(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    private int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        char[][] cArr = new char[n][n];
        State[][] dp = new State[n][n];

        for(int i = 0; i < board.size(); i++) {
            for(int j = 0; j < board.size(); j++) {
                cArr[i][j] = board.get(i).charAt(j);
                dp[i][j] = new State(0, 0);
            }
        }
        dp[0][0].count = 1;
        cArr[0][0] = cArr[n - 1][n - 1] = '0';

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                if(cArr[x][y] == 'X') continue;

                for(int[] dir: dirs) {
                    int xNew = x + dir[0];
                    int yNew = y + dir[1];
                    if(xNew < n && yNew < n && cArr[xNew][yNew] != 'X') {
                        State prevState = dp[x][y];
                        State currentState = dp[xNew][yNew];

                        int currentDigit = cArr[xNew][yNew] - '0';
                        if(prevState.sum + currentDigit > currentState.sum) {
                            currentState.sum = prevState.sum + currentDigit;
                            currentState.count = prevState.count;
                        }
                        else if(prevState.sum + currentDigit == currentState.sum) {
                            currentState.count = (currentState.count + prevState.count) % MOD;
                        }
                    }
                }
            }
        }
        if(dp[n - 1][n - 1].count == 0) dp[n - 1][n - 1].sum = 0;
        return new int[]{dp[n - 1][n - 1].sum, dp[n - 1][n - 1].count};
    }
}
