package com.vc.hard;

class L265 {
    public int minCostII(int[][] costs) {
        int min1 = 0;
        int min2 = 0;
        int minIndex = -1;
        for(int i = 0; i < costs.length; i++) {
            int currentMin1 = Integer.MAX_VALUE;
            int currentMin2 = Integer.MAX_VALUE;
            int currentMinIndex = -1;
            for(int j = 0; j < costs[0].length; j++) {
                int cost = costs[i][j] + (j == minIndex ? min2 : min1);
                if(cost < currentMin1) {
                    currentMin2 = currentMin1;
                    currentMin1 = cost;
                    currentMinIndex = j;
                }
                else if(cost < currentMin2) {
                    currentMin2 = cost;
                }
            }
            min1 = currentMin1;
            min2 = currentMin2;
            minIndex = currentMinIndex;
        }
        return min1;
    }
}