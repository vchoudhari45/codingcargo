package com.vc.medium;

class L289 {

    private int[][] board;
    private int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1,-1},
            {0,-1}, {-1,-1}, {-1, 0}, {-1, 1}};

    private int n, m;
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;

        this.n = board.length;
        this.m = board[0].length;
        this.board = board;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                update(i, j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) board[i][j] = board[i][j] >> 1;
        }
    }

    /**
         NewState    Old   Value
                0      0       0
                0      1       1
                1      0       2
                1      1       3
     */
    private void update(int row, int col) {
        int neighbours = 0;
        for(int[] dir: dirs) {
            int rowNew = row + dir[0];
            int colNew = col + dir[1];
            if(rowNew >= 0 && rowNew < n && colNew >= 0 && colNew < m) {
                if((board[rowNew][colNew] & 1) == 1) neighbours++;
            }
        }
        if((board[row][col] & 1) == 1 && neighbours >= 2 && neighbours <= 3) {
            board[row][col] = 3;
        }
        if((board[row][col] & 1) == 0 && neighbours == 3) {
            board[row][col] = 2;
        }
    }
}
