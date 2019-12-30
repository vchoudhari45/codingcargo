package com.vc.hard;

class L668 {
    public int findKthNumber(int m, int n, int k) {
        int lo = 0;
        int hi = m * n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = count(m, n, mid);
            if(count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    private int count(int m, int n, int number) {
        int row = 1;
        int col = n;
        int count = 0;
        while(row <= m && col > 0) {
            if(row * col <= number) {
                count += col;
                row++;
            }
            else col--;
        }
        return count;
    }
}
