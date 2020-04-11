package com.vc.hard;

import java.util.HashSet;

class L52 {
    int res = 0;
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> diagonal = new HashSet<>();
    HashSet<Integer> antidigonal = new HashSet<>();

    public int totalNQueens(int n) {
        char[][] state = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                state[i][j] = '.';
            }
        }
        helper(0, n, state);
        return res;
    }

    private void helper(int row, int n, char[][] state) {
        if(row == n) res += 1;

        for(int col = 0; col < n; col++) {
            if(isValid(row, col, n, state)) {
                state[row][col] = 'Q';
                cols.add(col);
                diagonal.add(row + col);
                antidigonal.add(col - row);

                helper(row + 1, n, state);

                state[row][col] = '.';
                cols.remove(col);
                diagonal.remove(row + col);
                antidigonal.remove(col - row);
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] state) {
        if(cols.contains(col)) return false;
        if(diagonal.contains(row + col)) return false;
        if(antidigonal.contains(col - row)) return false;
        return true;
    }
}