package com.vc.medium;

class L723 {
    public int[][] candyCrush(int[][] board) {
        if(board == null || board.length == 0) return board;

        int n = board.length;
        int m = board[0].length;

        boolean found = true;
        while(found) {
            found = false;
            //Crush
            for(int row = 0; row < n; row++) {
                for(int col = 0; col < m; col++) {
                    //Already visited
                    if(board[row][col] == 0) continue;

                    int val = Math.abs(board[row][col]);

                    //check horizontal
                    if(col + 2 < m
                            && Math.abs(board[row][col + 1]) == val && Math.abs(board[row][col + 2]) == val) {
                        found = true;
                        int c = col;
                        while(c < m && Math.abs(board[row][c]) == val) {
                            board[row][c] = -1 * val;
                            c++;
                        }
                    }

                    //check vertical
                    if(row + 2 < n
                            && Math.abs(board[row + 1][col]) == val && Math.abs(board[row + 2][col]) == val) {
                        found = true;
                        int r = row;
                        while(r < n && Math.abs(board[r][col]) == val) {
                            board[r][col] = -1 * val;
                            r++;
                        }
                    }
                }
            }


            //System.out.println("Crush is finished!");

            //Fall
            if(found) {
                for(int col = 0; col < m; col++) {
                    int storeRow = n - 1;
                    for(int row = n - 1; row >= 0; row--){
                        if(board[row][col] > 0) {
                            board[storeRow--][col] = board[row][col];
                        }
                    }

                    while(storeRow >= 0) board[storeRow--][col] = 0;
                }
            }

            //System.out.println("Fall is finished!");

        }

        return board;
    }
}
