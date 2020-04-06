package com.vc.easy;

class L256 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        int n = costs.length, m = costs[0].length;
        for(int i = n - 2; i >= 0; i--) {
            int currentRow = i;
            int nextRow = i + 1;

            for(int j = 0; j < m; j++) {
                int min = Integer.MAX_VALUE;

                for(int k = 0; k < m; k++) {
                    if(j == k) continue;
                    min = Math.min(costs[nextRow][k], min);
                }
                costs[currentRow][j] += min;
            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) System.out.format("%3s", costs[i][j]+"");
        //     System.out.println();
        // }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) min = Math.min(min, costs[0][i]);
        return min;
    }
}
