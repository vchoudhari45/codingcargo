package com.vc.hard;

class NumberOfWaysToFormATargetStringGivenADictionary {
    public int numWays(String[] words, String target) {
        long MOD = (int)1e9 + 7;
        int n = target.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for(int wIndex = 0; wIndex < words[0].length(); wIndex++) {
            int[] count = new int[26];
            for(String word: words) {
                count[word.charAt(wIndex) - 'a']++;
            }
            for(int targetIndex = n - 1; targetIndex >= 0; targetIndex--) {
                dp[targetIndex + 1] += dp[targetIndex] * count[target.charAt(targetIndex) - 'a'];
                if(dp[targetIndex + 1] < 0) dp[targetIndex + 1] += MOD;
                else dp[targetIndex + 1] %= MOD;
            }
        }
        return (int)dp[n];
    }
}