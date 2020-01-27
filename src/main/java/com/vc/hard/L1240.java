package com.vc.hard;

class L1240 {
    int min = Integer.MAX_VALUE;
    public int tilingRectangle(int rows, int cols) {
        if(rows == 0) return 0;
        boolean[][] status = new boolean[rows][cols];
        solve(0, 0, rows, cols, status, 0, 0);
        return min;
    }

    private void solve(int r, int c, int n, int m, boolean[][] status, int count, int loop) {
        //System.out.println(count(loop)+"-> Starting with values: ("+r+", "+c+")"+" count "+count);
        if(count > min) return;

        if(r >= n) {
            //System.out.println(count(loop)+"-> Assigning Value: ("+r+", "+c+")"+" count "+count);
            min = Math.min(min, count);
            return;
        }

        if(c >= m) {
            solve(r + 1, 0, n, m, status, count, loop + 1);
            return;
        }

        if(status[r][c]) {
            solve(r, c + 1, n, m, status, count, loop + 1);
            return;
        }

        for(int square = Math.min(n - r, m - c); square >= 1 && isAvailable(status, r, c, square); square--) {
            cover(status, r, c, square);
            //System.out.println(count(loop)+"-> Covering with square of "+square+" from point ("+r+", "+c+")");
            solve(r, c + square, n, m, status, count + 1, loop + 1);
            uncover(status, r, c, square);
        }
    }

    private String count(int loop) {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < loop; i++) s.append("---");
        return s.toString();
    }

    private void cover(boolean[][] status, int r, int c, int k) {
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                status[r + i][c + j] = true;
            }
        }
    }

    private void uncover(boolean[][] status, int r, int c, int k) {
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                status[r + i][c + j] = false;
            }
        }
    }

    private boolean isAvailable(boolean[][] status, int r, int c, int k) {
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < k; j++) {
                if(status[r + i][c + j]) return false;
            }
        }
        return true;
    }
}
