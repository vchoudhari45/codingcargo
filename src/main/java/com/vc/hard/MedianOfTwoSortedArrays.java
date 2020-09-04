package com.vc.hard;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if(m > n) return findMedianSortedArrays(B, A);

        int lo = 0;
        int hi = m;
        /**
            We do + 1 here to total length so that we get extra element on the left hand side
            And we can return mid in case total number of elements are odd
         */
        int halfOfTotalElements = (m + n + 1) / 2;
        while(lo <= hi) {
            int midLeft = lo + (hi - lo) / 2;
            int midLeftA = midLeft == 0 ? Integer.MIN_VALUE : A[midLeft - 1];
            int midRightA = midLeft == m ? Integer.MAX_VALUE : A[midLeft];

            int midRight = halfOfTotalElements - midLeft;
            int midLeftB = midRight == 0 ? Integer.MIN_VALUE : B[midRight - 1];
            int midRightB = midRight == n ? Integer.MAX_VALUE : B[midRight];

            if(midLeftA > midRightB) {
                hi = midLeft - 1;
            }
            else if(midLeftB > midRightA) {
                lo = midLeft + 1;
            }
            else {
                midLeft = Math.max(midLeftA, midLeftB);
                midRight = Math.min(midRightA, midRightB);
                if((m + n) % 2 == 0) return (midLeft + midRight) / 2.0;
                else return midLeft;
            }
        }
        return -1;
    }
}