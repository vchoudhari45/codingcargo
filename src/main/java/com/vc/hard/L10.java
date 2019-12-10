package com.vc.hard;

class L10 {
    public boolean isMatch(String s, String p) {
        int sn = s.length();
        int pn = p.length();

        boolean[][] dp = new boolean[sn + 1][pn + 1];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) dp[i][j] = true;
                else if(j == 0) dp[i][j] = false;
                else if(i == 0) {
                    if(p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 2];
                    }
                    else dp[i][j] = false;
                }
                else if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if(p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
                else if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else dp[i][j] = false;
            }
        }

        // for(int i = 0; i <= s.length(); i++) {
        //     for(int j = 0; j <= p.length(); j++) {
        //         if(dp[i][j])
        //             System.out.print("T");
        //         else
        //             System.out.print("F");
        //     }
        //     System.out.println();
        // }
        return dp[sn][pn];
    }
}
