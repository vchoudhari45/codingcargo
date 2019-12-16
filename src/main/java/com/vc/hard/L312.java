package com.vc.hard;

class L312 {
    public int maxCoins(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][n];
        for(int len = 0; len < n; len++) {
            for(int i = 0; i + len < n; i++) {
                int j = i + len;
                int leftValue = i - 1 >= 0 ? arr[i - 1] : 1;
                int rightValue = j + 1 < n ? arr[j + 1] : 1;

                System.out.println("i: "+i+" j: "+j);
                for(int k = i; k <= j; k++) {
                    int before = k - 1 >= i ? dp[i][k - 1] : 0;
                    int after = k + 1 <= j ? dp[k + 1][j] : 0;
                    // System.out.println("Bursting ballon: "+k +" last"
                    //                    +" before: "+before
                    //                    +" after: "+after
                    //                    +" leftValue: "+leftValue
                    //                    +" rightValue: "+rightValue
                    //                    +" value: "+arr[k]);
                    dp[i][j] = Math.max(dp[i][j], before + after + leftValue * arr[k] * rightValue);
                }
            }
        }
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.format("%5d", dp[i][j]);
        //     }
        //     System.out.println("");
        // }
        return dp[0][n - 1];
    }
}
