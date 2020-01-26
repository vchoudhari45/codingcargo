package com.vc.medium;

class L794 {
    public boolean validTicTacToe(String[] board) {
        int[] row = new int[3];
        int[] col = new int[3];
        int diagonal = 0, antidiagonal = 0;
        int turn = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i].charAt(j) == 'X') {
                    row[i]++;
                    col[j]++;
                    if(i == j) diagonal++;
                    if(i + j == 2) antidiagonal++;
                    turn++;
                }
                else if(board[i].charAt(j) == 'O') {
                    row[i]--;
                    col[j]--;
                    if(i == j) diagonal--;
                    if(i + j == 2) antidiagonal--;
                    turn--;
                }
            }
        }

        boolean xWin = row[0] == 3 || row[1] == 3 || row[2] == 3 || diagonal == 3 || antidiagonal == 3
                || col[0] == 3 || col[1] == 3 || col[2] == 3;

        boolean oWin = row[0] ==-3 || row[1] ==-3 || row[2] ==-3 || diagonal ==-3 || antidiagonal ==-3
                || col[0] ==-3 || col[1] ==-3 || col[2] ==-3;

        if(xWin && turn == 0 || oWin && turn == 1) return false;

        return turn == 0 || turn == 1;
    }
}
