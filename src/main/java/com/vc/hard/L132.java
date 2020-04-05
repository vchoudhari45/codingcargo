package com.vc.hard;

class L132 {
    public int minCut(String s) {
        int len = s.length();
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) dp[i] = i;

        //System.out.println(Arrays.toString(dp));

        for (int i = 0; i < len; i++) {
            search(s, dp, i, i);              //odd length
            search(s, dp, i, i + 1);    //even length
        }

        //System.out.println(Arrays.toString(dp));
        return dp[len - 1];
    }

    private void search(String s, int[] dp, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (left == 0) {
                // left == 0, substring(0, right+1) is palindrome, no cut needed
                dp[right] = 0;
            } else {
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            }
            left--;
            right++;
        }
    }
}