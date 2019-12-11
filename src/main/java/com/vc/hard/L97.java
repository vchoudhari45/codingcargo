package com.vc.hard;

class L97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m + n != s3.length()) return false;
        boolean[][] arr = new boolean[m + 1][n + 1];
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i == 0 && j == 0) arr[i][j] = true;
                else if(i == 0) {
                    arr[i][j] = arr[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
                }
                else if(j == 0) {
                    arr[i][j] = arr[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
                }
                else {
                    arr[i][j] = arr[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1);
                    arr[i][j] = arr[i][j] || arr[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1);
                }
            }
        }
        return arr[m][n];
    }
}
