package com.vc.medium;

import java.util.Arrays;

class L1040 {
    public int[] numMovesStonesII(int[] A) {
        Arrays.sort(A);
        /**
             For e.g.
             4 _ 6 7 _ _ _ 11

             Calculation for Higher Bound:
             11 - 6 - 4 + 2
             11 - 6 = How long is the right most window
             -4 = How many numbers we have to fit int
             +2 = Two numbers are already in place so no moves of those
         */
        int i = 0, n = A.length, low = n;
        //For Upper Bound we try to Move all the Stones to LeftMost or RightMost slot
        //+2 Because 2 numbers are already there in the window
        int high = Math.max(A[n - 1] - n + 2 - A[1], A[n - 2] - A[0] - n + 2);

        //For Lower Bound we slide Window of Size N and see which window has max element
        for (int j = 1; j < n; ++j) {
            while (A[j] - A[i] >= n) ++i;
            if (j - i == n - 2 && A[j] - A[i] == n - 2)
                /*
                    For case where we have window size == total number of elements - 1
                    e.g. 3 4 5 6 _ _ _ _ _ 12 case however many number of slots are
                    there answer is always 2

                    Moves are as below
                        1. 4 5 6 _ 3 _ _ _ 12
                        2. 4 5 6 12 3

                    else Minimum moves is number of empty slots
                */
                low = Math.min(low, 2);
            else
                low = Math.min(low, n - (j - i + 1));
        }
        return new int[] {low, high};
    }
}
