package com.vc.easy;

class L276 {
    public int numWays(int posts, int color) {
        if(posts == 0) return 0;
        if(posts == 1) return color;

        int diff = color * (color - 1);
        int same = color;
        int total = 0;

        for(int i = 2; i <= posts; i++) {
            total = same + diff;
            same = diff;
            diff = total * (color - 1);
        }
        return total;
    }
}
