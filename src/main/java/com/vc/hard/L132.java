package com.vc.hard;

class L132 {
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int l = 0; l < n; l++) {
            for(int from = 0; from < n - l; from++) {
                int to = from + l;
                if(l == 0) dp[from][to] = 0;
                else if(l == 1) {
                    if(s.charAt(from) == s.charAt(to)) dp[from][to] = 0;
                    else dp[from][to] = 1;
                }
                else {
                    dp[from][to] = Integer.MAX_VALUE;
                    if(isPalindrome(s, from, to)) {
                        dp[from][to] = 0;
                    }
                    else {
                        //System.out.println("l: "+l+" from: "+from+" to: "+to);
                        for(int cut = from; cut < to; cut++) {
                            // System.out.println("    left: "+s.substring(from, cut + 1)+" "+dp[from][cut]
                            //                   +" right: "+s.substring(cut + 1, to + 1)+" "+dp[cut + 1][to]);
                            dp[from][to] = Math.min(dp[from][to], 1 + dp[from][cut] + dp[cut + 1][to]);
                        }
                    }
                }
            }
        }
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) System.out.print(dp[i][j]+" ");
        //     System.out.println();
        // }
        return dp[0][n - 1];
    }

    private boolean isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
