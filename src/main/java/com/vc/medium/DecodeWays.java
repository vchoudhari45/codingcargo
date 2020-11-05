package com.vc.medium;

class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1; // How many ways we can decode empty string
        dp[1] = s.charAt(0) == '0' ? 0 : 1; // How many ways we can decode first character of a string

        //dp[i] means how many ways we can decode string ending at position i
        for(int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if(oneDigit >= 1 && oneDigit <= 9) dp[i] += dp[i - 1];
            if(twoDigit >= 10 && twoDigit <= 26) dp[i] += dp[i - 2];
        }

        return dp[n];
    }
}
