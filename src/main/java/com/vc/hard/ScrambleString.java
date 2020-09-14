package com.vc.hard;

class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        /**
         *   We use 3D Array here where,
         *   First n is for start index of s1
         *   Second n is for start index of s2
         *   Third n is for length
         **/
        boolean [][][] dp = new boolean[n][n][n + 1];
        //s1 => great   s2 => rgeat
        for (int total = 1; total <= n; total++) {
            for (int start1 = 0; start1 + total <= n; start1++) {
                for (int start2 = 0; start2 + total <= n; start2++) {
                    if (total == 1) {
                        dp[start1][start2][total] = s1.charAt(start1) == s2.charAt(start2);
                    } else {
                        for (int len = 1; len < total && !dp[start1][start2][total]; len++) {
                            boolean s1LeftVsS2Left = dp[start1][start2][len];                           //g    Vs //r
                            boolean s1RightVsS2Right = dp[start1 + len][start2 + len][total - len];     //reat Vs //geat
                            dp[start1][start2][total]  = s1LeftVsS2Left && s1RightVsS2Right;

                            boolean s1LeftVsS2ReverseRight = dp[start1][start2 + total - len][len];     //g    Vs //t
                            boolean s1RightVsS2ReverseLeft = dp[start1 + len][start2][total - len];     //reat Vs //rgea
                            dp[start1][start2][total] |= s1LeftVsS2ReverseRight && s1RightVsS2ReverseLeft;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
