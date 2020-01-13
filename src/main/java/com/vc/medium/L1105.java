package com.vc.medium;

class L1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        /**
             [[1,3],[2,4],[3,2]]
             6

             0 height = 0, dp = 0
             1 height = 3, dp = 3
             2 height = 4, dp = 7 ===Optimize===> height = 4, dp = 4
             3 height = 2, dp = 6 ===Optimize===> height = 4, dp = 7 ===Optimize===> height = 4, dp = 4
         */

        for(int i = 1; i <= n; i++) {
            int width = books[i - 1][0];
            int height = books[i - 1][1];
            dp[i] = dp[i - 1] + height;

            for(int j = i - 1; j > 0; j--) {
                width += books[j - 1][0];
                if(width > shelfWidth) break;

                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        //for(int i = 0; i <= n; i++) System.out.print(dp[i]+", ");
        return dp[n];
    }
}
