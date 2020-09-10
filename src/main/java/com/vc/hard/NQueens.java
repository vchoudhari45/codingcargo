package com.vc.hard;

import java.util.*;

class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(board, 0, n, res);
        return res;
    }

    private void solve(char[][] board, int row, int total, List<List<String>> res) {
        if(row == total) {
            List<String> list = new ArrayList<>();
            for(int r = 0; r < total; r++) {
                StringBuilder sb = new StringBuilder();
                for(int c = 0; c < total; c++) {
                    sb.append(board[r][c]);
                }
                list.add(sb.toString());
            }
            res.add(list);
        }
        else {
            //For Given Row row, try all the possible columns
            for(int col = 0; col < total; col++) {
                if(isValid(board, row, col, total)) {
                    board[row][col] = 'Q';
                    //If it is Valid Fill next Row
                    solve(board, row + 1, total, res);
                    //Backtrack
                    board[row][col] = '.';
                }
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int total) {
        int dCol = col;
        int dACol = col;
        while(row >= 0) {
            if(board[row][col] == 'Q') return false;
            if(dCol >= 0 && board[row][dCol] == 'Q') return false;
            if(dACol < total && board[row][dACol] == 'Q') return false;
            row--;
            dCol--;
            dACol++;
        }
        return true;
    }
}