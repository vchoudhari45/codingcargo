package com.vc.hard;

class EncodeStringWithShortestLength {
    public String encode(String s) {
        if(s == null || s.length() == 0) return "";

        int n = s.length();
        String[][] dp = new String[n][n];
        for(int len = 0; len < s.length(); len++) {
            for(int from = 0; from + len < s.length(); from++) {
                int to = from + len;

                String subStr = s.substring(from, to + 1);
                dp[from][to] = subStr;

                if(to - from < 4) continue;

                //See if length is less if we combine two half
                for(int middle = from; middle < to; middle++) {
                    int length = (dp[from][middle] + dp[middle + 1][to]).length();
                    if(length < dp[from][to].length()) {
                        dp[from][to] = dp[from][middle] + dp[middle + 1][to];
                    }
                }

                //See if we can find any repeat String
                int index = (subStr + subStr).indexOf(subStr, 1);

                if(index < subStr.length()) {
                    subStr = subStr.length() / index + "["+dp[from][from + index - 1]+"]";
                }

                if(subStr.length() < dp[from][to].length()) {
                    dp[from][to] = subStr;
                }
            }
        }
        return dp[0][n - 1];
    }
}