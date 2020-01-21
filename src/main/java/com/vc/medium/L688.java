package com.vc.medium;

class L688 {
    private int[][] dirs = {{1,  2}, {2,  1}, {-1, 2}, {-2, 1},{-1,-2}, {-2, -1}, {1, -2}, {2, -1}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] memo = new double[K + 1][N + 1][N + 1];
        return solve(N, K, r, c, memo);
    }

    private double solve(int N, int K, int r, int c, double[][][] memo) {
        if(!(r >= 0 && r < N && c >= 0 && c < N)) return 0;
        else if(memo[K][r][c] != 0) return memo[K][r][c];
        else if(K == 0) return 1;
        double prob = 0;
        for(int[] dir: dirs) {
            int rNew = r + dir[0];
            int cNew = c + dir[1];
            double sub = solve(N, K - 1, rNew, cNew, memo);
            prob += 0.125 * sub;
        }
        memo[K][r][c] = prob;
        return prob;
    }
}
