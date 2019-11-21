package com.vc.hard;

class L1246 {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int l = 0; l < n; l++) {
            for(int i = 0; i < n - l; i++) {
                int j = i + l;
                if(i == j) dp[i][j] = 1;
                else {
                    dp[i][j] = 1 + dp[i + 1][j];
                    if(arr[i] == arr[i + 1]) {
                        if(i + 2 < n)
                            dp[i][j] = Math.min(1 + dp[i + 2][j], dp[i][j]);
                        else
                            dp[i][j] = Math.min(1, dp[i][j]);
                    }
                    //int min = Integer.MAX_VALUE;
                    for(int k = i + 2; k <= j; k++){
                        //System.out.println("i: "+i+" k: "+k+" j: "+j+" dp: "+dp[i][j]);
                        if(arr[i] == arr[k]) {
                            if(k + 1 == n) {
                                dp[i][j] = Math.min(dp[i + 1][k - 1], dp[i][j]);
                            }
                            else {
                                dp[i][j] = Math.min(dp[i + 1][k - 1] + dp[k + 1][j], dp[i][j]);
                            }
                            //System.out.println("Matching i: "+i+" k: "+k+" j: "+j+" dp: "+dp[i][j]);
                        }
                    }
                    //min = Math.min(min, dp[i][j]);
                }
            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.format("%10d", dp[i][j]);
        //     }
        //     System.out.println();
        // }
        return dp[0][n - 1];
    }
}
