package com.vc.medium;

class L351 {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] =
                skip[3][7] = skip[7][3] = skip[4][6] = skip[6][4] = 5;

        int res = 0;
        for(int i = m; i <= n; i++) {
            res += dfs(1, i, skip, new boolean[10]) * 4;    //1 3 7 9 are symmetric
            res += dfs(2, i, skip, new boolean[10]) * 4;    //2 4 6 8 are symmetric
            res += dfs(5, i, skip, new boolean[10]);
        }
        return res;
    }

    private int dfs(int from, int remaining, int[][] skip, boolean[] visited) {
        if(remaining <= 0) return 0;
        if(remaining == 1) return 1;

        if(visited[from]) return 0;

        visited[from] = true;
        int res = 0;
        for(int to = 1; to <= 9; to++) {
            if(!visited[to] && (skip[from][to] == 0 || visited[skip[from][to]])) {
                res += dfs(to, remaining - 1, skip, visited);
            }
        }
        visited[from] = false;
        return res;
    }
}