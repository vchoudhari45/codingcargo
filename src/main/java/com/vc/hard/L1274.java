package com.vc.hard;

/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 */
class Sea {
    public boolean hasShips(int[] topRight, int[] bottomLeft) {
        return true;
    }
}

class L1274 {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if(!sea.hasShips(topRight, bottomLeft)) return 0;
        if(bottomLeft[0] == topRight[0] && bottomLeft[1] == topRight[1]) return 1;

        int midx = (bottomLeft[0] + topRight[0]) / 2;
        int midy = (bottomLeft[1] + topRight[1]) / 2;
        return countShips(sea, new int[]{midx, midy}, bottomLeft)
                + countShips(sea, topRight, new int[]{midx + 1, midy + 1})
                + countShips(sea, new int[]{midx, topRight[1]}, new int[]{bottomLeft[0], midy + 1})
                + countShips(sea, new int[]{topRight[0], midy}, new int[]{midx + 1, bottomLeft[1]});
    }
}