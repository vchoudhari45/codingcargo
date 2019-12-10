package com.vc.hard;

class L1255 {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        if(words == null || words.length == 0 || letters == null || letters.length == 0 || score == null || score.length == 0) return 0;

        int n = score.length;
        int[] count = new int[n];
        for(Character ch: letters) {
            count[ch - 'a']++;
        }

        return solve(0, words, count, score);
    }

    private int solve(int index, String[] words, int[] count, int[] score) {
        int max = 0;
        for(int i = index; i < words.length; i++) {
            int res = 0;
            boolean isValid = true;
            for(Character ch: words[i].toCharArray()) {
                count[ch - 'a']--;
                res += score[ch - 'a'];
                if(count[ch - 'a'] < 0) isValid = false;
            }
            if(isValid) {
                res += solve(i + 1, words, count, score);
                max = Math.max(max, res);
            }
            for(Character ch: words[i].toCharArray()) {
                count[ch - 'a']++;
            }
        }
        return max;
    }
}
