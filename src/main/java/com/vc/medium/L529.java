package com.vc.medium;

import java.util.*;

class L529 {

    private int[][] dirs = {{0, 1},{1, 1},{1, 0},{1, -1},{0, -1},{-1, -1},{-1, 0},{-1, 1}};
    private char[][] board;
    private Stack<int[]> intermediate = new Stack<int[]>();

    public char[][] updateBoard(char[][] board, int[] click) {
        this.board = board;
        Stack<int[]> st = new Stack<>();
        st.push(click);

        while(!st.isEmpty()) {
            int[] e = st.pop();
            int row = e[0], col = e[1];

            if(board[row][col] == 'M') board[row][col] = 'X';
            else {
                intermediate.clear();
                int count = countAdjacentMines(row, col);
                if(count > 0) board[row][col] = (char)(count + '0');
                else {
                    board[row][col] = 'B';
                    st.addAll(intermediate);
                }
            }
        }
        return board;
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for(int[] dir: dirs) {
            int rowNew = dir[0] + row;
            int colNew = dir[1] + col;
            if(rowNew >= 0 && rowNew < board.length && colNew >= 0 && colNew < board[0].length) {
                if(board[rowNew][colNew] == 'X' || board[rowNew][colNew] == 'M') count++;
                else if(board[rowNew][colNew] == 'E') intermediate.add(new int[]{rowNew, colNew});
            }
        }
        return count;
    }

}
