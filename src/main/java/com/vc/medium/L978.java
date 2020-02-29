package com.vc.medium;

class L978 {
    public int maxTurbulenceSize(int[] A) {
        int anchor = 0, n = A.length;
        if(n == 1) return 1;
        int max = 0;
        for(int i = 1; i < n; i++) {
            int c = Integer.compare(A[i - 1], A[i]);
            if(c == 0) anchor = i;
            if(i == n - 1 || c * Integer.compare(A[i], A[i + 1]) != -1) {
                max = Math.max(max, i - anchor + 1);
                anchor = i;
            }
        }
        return max;
    }
}
