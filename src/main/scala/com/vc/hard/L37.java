package com.vc.hard;

class L37 {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char k = '1'; k <= '9'; k++) {
                        if(isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if(solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3;
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == num || board[row][i] == num || board[blkrow + i / 3][blkcol + i % 3] == num)
                return false;
        }
        return true;
    }
}