package com.vc.medium;

class L418 {
    public int wordsTyping(String[] s, int rows, int cols) {
        int n = s.length;
        int[] dp = new int[n];
        for(int i = 0; i < dp.length; i++) {
            int words = 0, index = i, used = 0;
            while(used + s[index % n].length() <= cols) {
                used = used + s[index % n].length() + 1;
                index++;
                words++;
            }
            dp[i] = words;
        }

        //for(int i = 0; i < dp.length; i++) System.out.println(dp[i]);

        int words = 0, index = 0;
        for(int i = 0; i < rows; i++) {
            words += dp[index];
            index = (dp[index] + index) % n;
        }
        return words / n;
    }
}
