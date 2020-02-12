package com.vc.hard;

class L639 {
    int MOD = (int)1e9 + 7;

    public int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];

        if(n == 0) return 0;

        dp[0] = 1; // how many different ways empty string can be decoded
        dp[1] = helper(s.charAt(0)+""); //how many different ways first character of string can be decoded

        //dp[i] means how many ways we can decode string ending at position i
        for(int i = 2; i <= n; i++) {
            long singleDigit = helper(s.substring(i - 1, i));
            long doubleDigits = helper(s.substring(i - 2, i));

            if(singleDigit != 0) dp[i] += (dp[i - 1] * singleDigit) % MOD;
            if(doubleDigits != 0) dp[i] += (dp[i - 2] * doubleDigits) % MOD;

            dp[i] %= MOD;
        }

        //for(int i = 0; i <= n; i++) System.out.print(dp[i]+" ");
        return (int)dp[n];
    }

    private int helper(String s) {
        if(s.length() == 1) {
            if(s.charAt(0) == '*') return 9;
            else if(s.charAt(0) == '0') return 0; //Zero can't be decoded as anything on it's own
            else return 1;
        }
        else if(s.equals("**")) {
            return 15; //11 to 26 except 20
        }
        else if(s.charAt(0) == '*') {
            if(s.charAt(1) >= '0' && s.charAt(1) <= '6') return 2;
            else return 1;
        }
        else if(s.charAt(1) == '*'){
            if(s.charAt(0) == '1') return 9;
            else if(s.charAt(0) == '2') return 6;
            else return 0;
        }
        else {
            int num = Integer.parseInt(s);
            return (num >= 10 && num <= 26) ? 1 : 0;
        }
    }
}