package com.vc.medium;

class L926 {
    public int minFlipsMonoIncr(String S) {
        /**
             0123456789  Index
             0101100011  Given String
             0112333345  Number of flips to make zero until ith index from left side
             5443332100  Number of flips to make one until ith index from right side
        */
        if(S == null || S.length() == 0) return 0;

        int n = S.length();
        int[] makeZero = new int[n];
        int[] makeOne = new int[n];

        if(S.charAt(0) == '1') makeZero[0] = 1;
        for(int i = 1; i < n; i++) {
            if(S.charAt(i) == '1') makeZero[i] = makeZero[i - 1] + 1;
            else makeZero[i] = makeZero[i - 1];
        }

        if(S.charAt(n - 1) == '0') makeOne[n - 1] = 1;
        for(int i = n - 2; i >= 0; i--) {
            if(S.charAt(i) == '0') makeOne[i] = makeOne[i + 1] + 1;
            else makeOne[i] = makeOne[i + 1];
        }

        int count = S.length() + 1;
        for(int i = 0; i < n; i++) {
            //Make everything from ith index 1
            count = Math.min(count, makeOne[i] + (i > 0 ? makeZero[i - 1]: 0));

            //Make everything from (i + 1) index 1
            count = Math.min(count, makeZero[i] + (i + 1 < n ? makeOne[i + 1] : 0));
        }
        return count;
    }
}
