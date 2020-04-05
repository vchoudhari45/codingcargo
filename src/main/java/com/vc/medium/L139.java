package com.vc.medium;

import java.util.HashSet;
import java.util.List;

class L139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        //return helper(s, 0, dict);

        //Converting to iterative
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int from = 0; from < n; from++) {
            if(!dp[from]) continue;
            for(int to = from + 1; to <= n; to++) {
                String prefix = s.substring(from, to);
                if(dict.contains(prefix)) {
                    dp[to] = true;
                    //System.out.println(Arrays.toString(dp));
                }
            }
        }
        return dp[n];
    }

//     private boolean helper(String s, int start, HashSet<String> dict) {
//         if(start == s.length()) return true;

//         for(int i = start + 1; i <= s.length(); i++) {
//             String prefix = s.substring(start, i);
//             if(dict.contains(prefix)) {
//                 //System.out.println("Found Prefix: "+prefix);
//                 if(helper(s, i, dict)) return true;
//             }
//         }
//         return false;
//     }
}
