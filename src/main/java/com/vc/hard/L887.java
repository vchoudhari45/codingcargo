package com.vc.hard;

class L887 {
    public int superEggDrop(int eggs, int floor) {
        Integer[][] memo = new Integer[eggs + 1][floor + 1];
        return solve(eggs, floor, memo);
    }

    private int solve(int eggs, int floor, Integer[][] memo) {
        if(eggs == 1) return floor;
        if(memo[eggs][floor] != null) return memo[eggs][floor];

        /** This is KN^2 Solution because we consider each floor
             int minMoves = floor;
             for(int i = 1; i <= floor; i++) {
             //let's assume egg breaks at ith floor

             //All the floors below it will have one less egg and i - 1 floor to check
             int below = solve(eggs - 1, i - 1, memo);

             //All the floors above it will have all the egss and floor - i to check
             int above = solve(eggs, floor - i, memo);

             minMoves = Math.min(minMoves, Math.max(below, above) + 1);
         } */


        //We can use Binary search and reduce the complexity to KNlogN
        int minMoves = floor;
        int lo = 1, hi = floor;
        while(lo < hi) {
            //Floor at which egg will break
            int mid = lo + (hi - lo) / 2;

            int below = solve(eggs - 1, mid - 1, memo);
            int above = solve(eggs, floor - mid, memo);

            minMoves = Math.min(minMoves, Math.max(below, above) + 1);

            //If floor increases move increases for same number of eggs
            //We want to minimize so value of above & below should be equal
            if(above > below) lo = mid + 1;
            else hi = mid; //let's remove some floors from below
        }

        memo[eggs][floor] = minMoves;
        return minMoves;
    }
}