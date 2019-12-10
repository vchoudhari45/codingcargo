package com.vc.hard;

class L471 {
    public String encode(String s) {
        int n = s.length();
        String[][] dp = new String[n][n];

        for(int l = 0; l < n; l++) {
            for(int i = 0; i < n - l; i++) {
                int j = i + l;

                String substr = s.substring(i, j + 1);
                dp[i][j] = substr;

                for(int k = i; k < j; k++) {
                    int len = (dp[i][k] + dp[k + 1][j]).length();
                    if(len < dp[i][j].length()) {
                        dp[i][j] = dp[i][k] + dp[k + 1][j];
                    }
                }

                for(int k = 0; k < substr.length(); k++) {
                    String repeatString = substr.substring(0, k + 1);
                    if(substr.length() % repeatString.length() == 0
                            && substr.replaceAll(repeatString, "").equals("")) {
                        //System.out.println("SubString: "+substr+" Repeated String: "+dp[i][i + k]+" i: "+i+" k: "+k);
                        String candidate = substr.length() / repeatString.length() + "["+dp[i][i + k]+"]";
                        if(dp[i][j].length() >= candidate.length())
                            dp[i][j] = candidate;
                    }
                }
            }
        }

        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.format("%10s", dp[i][j]);
        //     }
        //     System.out.println();
        // }
        return dp[0][n - 1];
    }
}
