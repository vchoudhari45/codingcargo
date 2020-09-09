package com.vc.hard;

class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                if(board[row][col] == '.') {
                    for(char num = '1'; num <= '9'; num++) {
                        if(isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if(solve(board)) return true;
                            else board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int blkRow = (row / 3) * 3, blkCol = (col / 3) * 3;
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == num) return false;
            if(board[row][i] == num) return false;
            if(board[blkRow + i / 3][blkCol + i % 3] == num) return false;
        }
        return true;
    }
}