package com.vc.medium;

class L838 {
    public String pushDominoes(String dominoes) {
        if(dominoes == null || dominoes.length() == 0) return "";
        int n = dominoes.length();
        int[] c = new int[n];

        boolean right = false;
        int force = n;
        for(int i = 0; i < n; i++) {
            if(dominoes.charAt(i) == 'R') {
                right = true;
                force = n;
                c[i] += force--;
            }
            else if(dominoes.charAt(i) == 'L') {
                right = false;
                force = 0;
            }
            else if(right) {
                c[i] += force--;
            }
        }

        boolean left = false;
        force = n;
        for(int i = n - 1; i >= 0; i--) {
            if(dominoes.charAt(i) == 'L') {
                left = true;
                force = n;
                c[i] -= force--;
            }
            else if(dominoes.charAt(i) == 'R') {
                left = false;
                force = 0;
            }
            else if(left) {
                c[i] -= force--;
            }
        }

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(c[i] > 0) str.append('R');
            else if(c[i] < 0) str.append('L');
            else str.append('.');
        }
        return str.toString();
    }
}
