package com.vc.medium;

class L858 {
    public int mirrorReflection(int p, int q) {
        //Keep on substracting q from p and update directions
        boolean up = true;
        boolean east = true;
        int remain = p;
        while (true) {
            remain -= q;
            if (remain == 0) {
                if(!east) return 2;
                return up ? 1 : 0;
            }
            if (remain < 0) {
                remain+=p;
                up=!up;
            }
            east = !east;
        }
    }
}
