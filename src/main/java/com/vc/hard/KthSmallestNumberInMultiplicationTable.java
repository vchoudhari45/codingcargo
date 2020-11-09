package com.vc.hard;

class KthSmallestNumberInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int lo = 0;
        int hi = m * n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int index = getIndex(m, n, mid);
            if(index < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    private int getIndex(int m, int n, int number) {
        int row = 1;
        int col = n;
        int numberIndex = 0;
        while(row <= m && col > 0) {
            if(row * col <= number) {
                numberIndex += col;
                row++;
            }
            else col--;
        }
        return numberIndex;
    }
}
