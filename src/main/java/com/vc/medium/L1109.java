package com.vc.medium;

class L1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for(int[] booking: bookings) {
            int from = booking[0];
            int to = booking[1];

            res[from - 1] += booking[2];
            if(to < n) res[to] += -1 * booking[2];
        }

        int runningSum = 0;
        for(int i = 0; i < res.length; i++) {
            res[i] += runningSum;
            runningSum = res[i];
        }
        return res;
    }
}
