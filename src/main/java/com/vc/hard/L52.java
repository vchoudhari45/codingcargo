package com.vc.hard;

class L52 {
    int res = 0;
    public int totalNQueens(int n) {
        char[][] state = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++) {
                state[i][j] = '.';
            }
        }
        solve(state, 0, n);
        return res;
    }

    private void solve(char[][] state, int row, int n) {
        if(row == n) res++;
        else {
            for(int col = 0; col < n; col++) {
                if(isValid(state, row, col, n)) {
                    state[row][col] = 'Q';
                    solve(state, row + 1, n);
                    state[row][col] = '.';
                }
            }
        }
    }

    private boolean isValid(char[][] state, int row, int col, int n) {
        int drow = row;
        int dcol = col;
        int dacol = col;

        for(int i = 0; i < n; i++) {
            if(state[i][col] == 'Q') return false;

            if(drow >= 0 && dcol >= 0 && state[drow][dcol] == 'Q') return false;

            if(drow >= 0 && dacol < n && state[drow][dacol] == 'Q') return false;

            drow--;
            dcol--;
            dacol++;
        }
        return true;
    }
}
