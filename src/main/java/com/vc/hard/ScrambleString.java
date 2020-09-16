package com.vc.hard;

class ScrambleString {
    private int m;
    private Boolean[][][] dp;
    public boolean isScramble(String s1, String s2) {
        m = s1.length();
        dp = new Boolean[m][m][m];
        return dfs(s1, s2, 0, m - 1, 0, m - 1);
    }

    private boolean dfs(String s1, String s2, int l1, int r1, int l2, int r2) {
        if (l1 == r1) return s1.charAt(l1) == s2.charAt(l2);

        if (dp[l1][l2][r1 - l1] != null) return dp[l1][l2][r1 - l1];

        dp[l1][l2][r1 - l1] = false;
        for(int i = 0; i + l1 <= r1; i++) {
            int left1 = l1 + i;
            int left2 = l2 + i;
            int right1 = r2 - i;
            int right2 = l2 + r1 - l1 - i - 1;

            dp[l1][l2][r1 - l1] = dp[l1][l2][r1 - l1] ||
                    (dfs(s1, s2, l1, left1, l2, left2) && dfs(s1, s2,left1 + 1, r1, left2 + 1, r2)) ||
                    (dfs(s1, s2, l1, left1, right1, r2) && dfs(s1, s2,left1 + 1, r1, l2, right2));

            if(dp[l1][l2][r1 - l1]) return true;
        }
        return dp[l1][l2][r1 - l1];
    }
}