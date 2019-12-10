package com.vc.hard;

import java.util.*;

class L51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] state = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                state[i][j] = '.';
            }
        }
        solve(0, n, state, res);
        return res;
    }

    private void solve(int row, int n, char[][] state, List<List<String>> res) {
        //print(state);
        if(row == n) {
            List<String> list = new ArrayList<String>();
            for(int i = 0; i < state.length; i++) {
                StringBuilder str = new StringBuilder();
                for(int j = 0; j < state[i].length; j++) {
                    str.append(state[i][j]);
                }
                list.add(str.toString());
                str.setLength(0);
            }
            res.add(list);
        }
        else {
            for(int col = 0; col < n; col++) {
                if(isValid(row, col, n, state)) {
                    state[row][col] = 'Q';
                    solve(row + 1, n, state, res);
                    state[row][col] = '.';
                }
            }
        }
    }

    private void print(char[][] state) {
        System.out.println("==========================================");
        for(int i = 0; i < state.length; i++) {
            for(int j = 0; j < state[0].length; j++) {
                System.out.print(state[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("==========================================");
    }

    private boolean isValid(int row, int col, int n, char[][] state) {
        int drow = row;
        int dcol = col;
        int dacol = col;
        //System.out.println("Trying row: "+row+" col: "+col);
        for(int i = 0; i < n; i++) {
            //Checking for same column
            if(state[i][col] == 'Q') {
                //System.out.println("Failed for column validation in row: "+i+" and col: "+col);
                return false;
            }

            //Checking diagonal
            if(drow >= 0 && dcol >= 0 && state[drow][dcol] == 'Q') {
                //System.out.println("Failed for diagonal validation in row: "+drow+" and col: "+dcol);
                return false;
            }

            //Checking anti-diagonal
            if(drow >= 0 && dacol < n && state[drow][dacol] == 'Q') {
                //System.out.println("Failed for Anti-diagonal validation in row: "+drow+" and col: "+dacol);
                return false;
            }

            drow--;
            dacol++;
            dcol--;
        }
        return true;
    }
}
