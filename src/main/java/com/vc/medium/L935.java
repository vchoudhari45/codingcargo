package com.vc.medium;

class L935 {
    public static final int MOD = 1000000007;
    public int knightDialer(int N) {
        int[][] graph = new int[][]{{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{2,4}};
        int cnt = 0;
        Integer[][] memo = new Integer[N+1][10];
        for (int i = 0; i <= 9; i++)
            cnt = (cnt + helper(N-1, i, graph, memo)) % MOD;
        return cnt;
    }
    private int helper(int N, int cur, int[][] graph, Integer[][] memo) {
        if (N == 0)
            return 1;
        if (memo[N][cur] != null)
            return memo[N][cur];
        int cnt = 0;
        for (int nei : graph[cur])
            cnt = (cnt + helper(N-1, nei, graph, memo)) % MOD;
        memo[N][cur] = cnt;
        return cnt;
    }
}