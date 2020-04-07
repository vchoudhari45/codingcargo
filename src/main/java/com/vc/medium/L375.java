package com.vc.medium;

//Recursive
//class L375 {
//    public int getMoneyAmount(int n) {
//        int[][] dp = new int[n + 1][n + 1];
//        return solve(1, n, dp);
//    }
//
//    private int solve(int lo, int hi, int[][] dp) {
//        if(lo >= hi) return 0;
//        if(dp[lo][hi] > 0) return dp[lo][hi];
//        int res = Integer.MAX_VALUE;
//        for(int i = lo; i <= hi; i++) {
//            res = Math.min(res, Math.max(i + solve(lo, i - 1, dp), i + solve(i + 1, hi, dp)));
//        }
//        dp[lo][hi] = res;
//        return res;
//    }
//}


//Iterative
class L375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n][n];
        for(int l = 0; l < n; l++) {
            for(int from = 0; from + l < n; from++) {
                int to = from + l;

                if(l == 0) {
                    dp[from][to] = 0;
                }
                else if(l == 1) {
                    dp[from][to] = Math.min(from + 1, to + 1);
                }
                else {
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int partition = from; partition <= to; partition++) {
                        int beforePartition = partition - 1 >= 0 ? dp[from][partition - 1] : 0;
                        int afterPartition  = partition + 1 < n ? dp[partition + 1][to] : 0;
                        dp[from][to] = Math.min(dp[from][to], (partition + 1) + Math.max(beforePartition, afterPartition));
                        //System.out.println("from: "+from+" to: "+to+" partition: "+partition+" before: "+beforePartition+" after: "+afterPartition+"");
                    }
                }
            }
        }
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.format("%3s", dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[0][n - 1];
    }
}
