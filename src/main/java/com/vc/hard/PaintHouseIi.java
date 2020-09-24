package com.vc.hard;

class PaintHouseIi {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        int n = costs.length;
        for(int row = 1; row < n; row++) {

            //Find two minimum elements from prevRow
            int minFirstIndex = -1;
            int minSecondIndex = -1;
            for(int col = 0; col < costs[0].length; col++) {
                int cost = costs[row - 1][col];
                if(minFirstIndex == -1 || cost < costs[row - 1][minFirstIndex]) {
                    minSecondIndex = minFirstIndex;
                    minFirstIndex = col;
                }
                else if(minSecondIndex == -1 || cost < costs[row - 1][minSecondIndex]) {
                    minSecondIndex = col;
                }
            }

            //Find minium in current column based on minimum on previous column
            for(int col = 0; col < costs[0].length; col++) {
                if(col == minFirstIndex) {
                    costs[row][col] += costs[row - 1][minSecondIndex];
                }
                else {
                    costs[row][col] += costs[row - 1][minFirstIndex];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int col = 0; col < costs[0].length; col++) {
            res = Math.min(res, costs[n - 1][col]);
        }
        return res;
    }
}