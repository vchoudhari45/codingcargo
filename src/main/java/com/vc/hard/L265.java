package com.vc.hard;

class L265 {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        int n = costs.length, m = costs[0].length;
        for(int currentRow = n - 2; currentRow >= 0; currentRow--) {
            int nextRow = currentRow + 1;

            int minColor1 = -1, minColor2 = -1;
            for(int color = 0; color < m; color++) {
                if(minColor1 == -1 || costs[nextRow][color] < costs[nextRow][minColor1]) {
                    minColor2 = minColor1;
                    minColor1 = color;
                }
                else if(minColor2 == -1 || costs[nextRow][color] < costs[nextRow][minColor2]) {
                    minColor2 = color;
                }
            }

            //System.out.println("For row: "+nextRow+" minColor1: "+minColor1+" minColor2: "+minColor2);
            for(int color = 0; color < m; color++) {
                if(color != minColor1) {
                    costs[currentRow][color] += costs[nextRow][minColor1];
                }
                else {
                    costs[currentRow][color] += costs[nextRow][minColor2];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) min = Math.min(costs[0][i], min);
        return min;
    }
}