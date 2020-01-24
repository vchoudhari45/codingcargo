package com.vc.easy;

class L942 {
    public int[] diStringMatch(String S) {
        int left = 0;
        int right = S.length();
        int[] res = new int[S.length() + 1];
        for(int i = 0; i < S.length(); i++) {
            res[i] = S.charAt(i) == 'I' ? left++ : right--;
        }
        res[S.length()] = left;
        return res;
    }
}
