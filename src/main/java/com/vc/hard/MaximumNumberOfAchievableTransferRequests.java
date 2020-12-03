package com.vc.hard;

class MaximumNumberOfAchievableTransferRequests {
    public int maximumRequests(int n, int[][] requests) {
        int r = requests.length;
        int max = 0;
        for(int subset = 1; subset < (1 << r); subset++) {
            int[] buildings = new int[n];
            int completedRequest = 0;
            for(int bit = 0; bit < r; bit++) {
                if(((subset >> bit) & 1) == 1) {
                    int from = requests[r - bit - 1][0];
                    int to = requests[r - bit - 1][1];
                    buildings[from]--;
                    buildings[to]++;
                    completedRequest++;
                }
            }
            if(isValid(buildings)) max = Math.max(max, completedRequest);
        }
        return max;
    }

    private boolean isValid(int[] buildings) {
        for(int building: buildings) if(building != 0) return false;
        return true;
    }
}