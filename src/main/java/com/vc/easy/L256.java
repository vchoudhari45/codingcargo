package com.vc.easy;

class L256 {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        int n = costs.length;
        for(int currentRow = n - 2; currentRow >= 0; currentRow--) {
            int nextRow = currentRow + 1;
            costs[currentRow][0] += Math.min(costs[nextRow][1], costs[nextRow][2]);
            costs[currentRow][1] += Math.min(costs[nextRow][0], costs[nextRow][2]);
            costs[currentRow][2] += Math.min(costs[nextRow][0], costs[nextRow][1]);
        }
        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }
}