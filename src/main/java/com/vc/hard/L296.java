package com.vc.hard;

class L296 {
    public int minTotalDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }

        System.out.print("Rows: ");
        for(Integer r: row) System.out.print(r+" ");

        //System.out.print("\nColumn: ");
        for(Integer c: col) System.out.print(c+" ");

        int minDistanceRow = minDistance(row);
        int minDistanceCol = minDistance(col);

        //System.out.print("\nValues: ");
        //System.out.print(minDistanceRow+" "+minDistanceCol);
        return minDistanceRow + minDistanceCol;
    }

    private int minDistance(int[] r) {
        int i = -1;
        int j = r.length;
        int left = 0;
        int right = 0;

        int d = 0;
        while(i < j) {
            if(left < right) {
                d += left;
                left += r[++i];
            }
            else {
                d += right;
                right += r[--j];
            }
        }
        return d;
    }
}