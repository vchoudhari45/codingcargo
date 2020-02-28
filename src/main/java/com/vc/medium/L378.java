package com.vc.medium;

class L378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[n - 1][m - 1];
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int row = 0, col = m - 1, count = 0;
            while(row < n && col >= 0) {
                if(matrix[row][col] <= mid) {
                    count += col + 1;
                    row++;
                }
                else col--;
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
