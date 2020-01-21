package com.vc.medium;

class L361 {
    public int maxKilledEnemies(char[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;

        int max = 0;
        int rowHits = 0;
        int[] colHits = new int[m];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                int count = 0;
                if(j == 0 || grid[i][j - 1] == 'W') {
                    rowHits = 0;
                    for(int col = j; col < grid[0].length && grid[i][col] != 'W'; col++) {
                        if(grid[i][col] == 'E') rowHits++;
                    }
                }
                if(i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for(int row = i; row < grid.length && grid[row][j] != 'W'; row++) {
                        if(grid[row][j] == 'E') colHits[j]++;
                    }
                }
                if(grid[i][j] == '0'){
                    //System.out.println("Enemies on ith: "+i+" Row jth: "+j+" Col is: "+(colHits[j] + rowHits));
                    max = Math.max(max, colHits[j] + rowHits);
                }
            }
        }
        return max;
    }
}
