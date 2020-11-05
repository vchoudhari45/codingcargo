package com.vc.hard;

class DecodeWaysIi {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;

        int MOD = (int)1e9 + 7;
        int n = s.length();
        long[] dp = new long[n + 1];

        dp[0] = 1; // how many different ways empty string can be decoded
        dp[1] = helper(s.charAt(0) + "");

        //dp[i] means how many ways we can decode string ending at position i
        for(int i = 2; i <= n; i++) {
            long oneDigit = helper(s.substring(i - 1, i));
            long twoDigit = helper(s.substring(i - 2, i));

            if(oneDigit != 0) dp[i] += (dp[i - 1] * oneDigit) % MOD;
            if(twoDigit != 0) dp[i] += (dp[i - 2] * twoDigit) % MOD;

            dp[i] %= MOD;
        }
        return (int)dp[n];
    }

    private long helper(String str) {
        if(str.length() == 1) {
            if(str.charAt(0) == '*') return 9;
            else if(str.charAt(0) == '0') return 0; //Zero can't be decoded as anything on it's own
            else return 1;
        }
        else if(str.equals("**")) {
            return 15; //11 to 26 except 20 as * can't be Zero
        }
        else if(str.charAt(0) == '*') {
            /**
                 Consider str.charAt(1) = 0
                 10
                 20

                 Consider str.charAt(1) = 1
                 11
                 21

                 Consider str.charAt(1) = 2
                 12
                 22

                 Consider str.charAt(1) = 3
                 13
                 23

                 Consider str.charAt(1) = 4
                 14
                 24

                 Consider str.charAt(1) = 5
                 15
                 25

                 Consider str.charAt(1) = 6
                 16
                 26

                 After 6 we can only make 1 number
                 Consider str.charAt(1) = 7
                 17

                 Consider str.charAt(1) = 8
                 18

                 Consider str.charAt(1) = 9
                 19
            */
            if(str.charAt(1) >= '0' && str.charAt(1) <= '6') return 2;
            else return 1;
        }
        else if(str.charAt(1) == '*') {
            if(str.charAt(0) == '1') return 9;
            else if(str.charAt(0) == '2') return 6;
            else return 0;
        }
        else {
            int num = Integer.parseInt(str);
            return (num >= 10 && num <= 26) ? 1 : 0;
        }
    }
}