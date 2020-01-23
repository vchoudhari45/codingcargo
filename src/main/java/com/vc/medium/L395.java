package com.vc.medium;

class L395 {
    public int longestSubstring(String s, int k) {
        return solve(s, 0, s.length(), k);
    }

    private int solve(String s, int start, int end, int k) {
        if(end - start < k) return 0;

        int[] count = new int[26];
        for(int i = start; i < end; i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }

        for(int j = 0; j < 26; j++) {
            if(count[j] < k && count[j] > 0) {
                for(int i = start; i < end; i++) {
                    if(s.charAt(i) == j + 'a') {
                        int left = solve(s, start, i, k);
                        int right = solve(s, i + 1, end, k);
                        return Math.max(left, right);
                    }
                }
            }
        }
        return end - start;
    }
}
