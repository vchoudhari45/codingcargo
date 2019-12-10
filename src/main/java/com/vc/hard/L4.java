package com.vc.hard;

class L4 {
    public double findMedianSortedArrays(int[] xArr, int[] yArr) {
        int x = xArr.length;
        int y = yArr.length;

        if(x > y) return findMedianSortedArrays(yArr, xArr);

        int totalPartition = (x + y + 1) / 2;
        int lo = 0;
        int hi = x;
        while(lo <= hi) {
            int xPartition = lo + (hi - lo) / 2;
            int yPartition = totalPartition - xPartition;

            int maxLeftX = Integer.MIN_VALUE;
            int maxLeftY = Integer.MIN_VALUE;
            int minRightX = Integer.MAX_VALUE;
            int minRightY = Integer.MAX_VALUE;

            if(xPartition > 0) maxLeftX = xArr[xPartition - 1];
            if(yPartition > 0) maxLeftY = yArr[yPartition - 1];
            if(xPartition < x) minRightX = xArr[xPartition];
            if(yPartition < y) minRightY = yArr[yPartition];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if((x + y) % 2 == 0)
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                else
                    return Math.max(maxLeftX, maxLeftY);
            }
            else if(maxLeftX > minRightY) hi = xPartition - 1;
            else lo = xPartition + 1;
        }
        return -1.0;
    }
}