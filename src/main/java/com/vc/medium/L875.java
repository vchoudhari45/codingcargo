package com.vc.medium;

class L875 {
    public int minEatingSpeed(int[] piles, int H) {
        long lo = 1;
        long hi = 0;
        for(int i = 0; i < piles.length; i++) {
            hi += piles[i];
        }

        /**
         *  Minimize the maximum
         **/
        while(lo < hi) {
            long mid = lo + (hi - lo) / 2;
            boolean isPossible = isPossible(piles, mid, H);
            //System.out.println("Mid: "+mid+" isPossible: "+isPossible);
            if(!isPossible) lo = mid + 1;
            else hi = mid;
        }
        return (int)lo;
    }

    private boolean isPossible(int[] piles, long mid, int H) {
        int count = 0;
        for(int i = 0; i < piles.length; i++) {
            count += piles[i] / mid;
            if(piles[i] % mid != 0) count += 1;
            if(count > H) return false;
        }
        return true;
    }
}