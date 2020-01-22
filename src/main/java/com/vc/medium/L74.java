package com.vc.medium;

class L74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if(r == 0) return false;
        int c = matrix[0].length;

        int lo = 0;
        int hi = r * c - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midValue = matrix[mid / c][mid % c];

            if(midValue == target) return true;
            else if(midValue > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}
