package com.vc.medium;

import java.util.*;

class L948 {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int l = 0;
        int r = tokens.length - 1;
        int points = 0;
        int max = 0;
        while(l <= r) {
            if(P >= tokens[l]) {
                P -= tokens[l++];
                points++;
                max = Math.max(max, points);
            }
            else if(P < tokens[l] && points > 0) {
                points--;
                P += tokens[r--];
            }
            else break;
        }
        return max;
    }
}
