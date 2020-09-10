package com.vc.hard;

import java.util.HashSet;

class NQueensII {

    private HashSet<Integer> cols = new HashSet<>();
    private HashSet<Integer> diagonals = new HashSet<>();
    private HashSet<Integer> antiDiagonals = new HashSet<>();

    int count = 0;
    public int totalNQueens(int n) {
        solve(0, n);
        return count;
    }

    private void solve(int row, int total) {
        if(row == total) count++;
        else {
            for(int col = 0; col < total; col++) {
                if(isValid(row, col)) {
                    cols.add(col);
                    diagonals.add(row + col);
                    antiDiagonals.add(row - col);

                    solve(row + 1, total);

                    cols.remove(col);
                    diagonals.remove(row + col);
                    antiDiagonals.remove(row - col);
                }
            }
        }
    }

    private boolean isValid(int row, int col) {
        if(cols.contains(col)) return false;
        if(diagonals.contains(row + col)) return false;
        if(antiDiagonals.contains(row - col)) return false;
        return true;
    }
}