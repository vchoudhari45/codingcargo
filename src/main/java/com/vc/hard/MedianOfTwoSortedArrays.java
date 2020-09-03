package com.vc.hard;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if (m > n) return findMedianSortedArrays(B, A);

        int lo = 0, hi = m;
        int total = (m + n + 1) / 2;
        while (lo <= hi) {
            int midRight = lo + (hi - lo) / 2;
            int midLeft = total - midRight;

            int leftA = midRight == 0 ? Integer.MIN_VALUE : A[midRight - 1];
            int rightA = midRight == m ? Integer.MAX_VALUE : A[midRight];
            int leftB = midLeft == 0 ? Integer.MIN_VALUE : B[midLeft - 1];
            int rightB = midLeft == n ? Integer.MAX_VALUE : B[midLeft];

            if (leftA > rightB) {
                hi = midRight - 1;
            }
            else if (leftB > rightA) {
                lo = midRight + 1;
            }
            else {
                int maxLeft = Math.max(leftA, leftB);
                int minRight = Math.min(rightA, rightB);
                if ((m + n) % 2 == 1) return maxLeft; // # of left_part = # of right_part + 1;
                else return (maxLeft + minRight) / 2.0;
            }
        }
        return -1;
    }
}