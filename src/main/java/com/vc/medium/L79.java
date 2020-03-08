package com.vc.medium;

class L79 {

    private char[][] board;
    private String word;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        /**
             A B C E
             S F E S
             A D E E

             ABCEFSADEESE
         */
        if(board == null || board.length == 0) return false;

        int n = board.length;
        int m = board[0].length;

        this.board = board;
        this.word = word;
        this.visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(0) && helper(1, i, j)) return true;
            }
        }
        return false;
    }

    private int[][] dirs = {{0, 1},{1, 0},{0, -1},{-1, 0}};
    private boolean helper(int index, int row, int col) {
        if(visited[row][col]) return false;

        if(index == word.length()) return true;

        visited[row][col] = true;
        for(int[] dir: dirs) {
            int rowNew = row + dir[0];
            int colNew = col + dir[1];
            if(rowNew >= 0 && rowNew < board.length && colNew >= 0
                    && colNew < board[0].length && board[rowNew][colNew] == word.charAt(index)) {
                if(helper(index + 1, rowNew, colNew)) return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
