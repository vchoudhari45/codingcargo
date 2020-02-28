package com.vc.medium;

class TicTacToe {

    private int[] row, col;
    private int diagonal = 0, antidiagonal = 0, n = 0;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        this.row = new int[n];
        this.col = new int[n];
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param r The row of the board.
        @param c The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int r, int c, int player) {
        if(player == 1) {
            row[r]++;
            col[c]++;
            if(r == c) diagonal++;
            if(r + c == n - 1) antidiagonal++;
        }
        else {
            row[r]--;
            col[c]--;
            if(r == c) diagonal--;
            if(r + c == n - 1) antidiagonal--;
        }

        if(Math.abs(row[r]) == n || Math.abs(col[c]) == n ||
                Math.abs(diagonal) == n || Math.abs(antidiagonal) == n) return player;
        else return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */