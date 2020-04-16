package com.vc.easy;

class L896 {
    public boolean isMonotonic(int[] A) {
        if(A == null || A.length <= 1) return true;

        boolean increasing = false, decreasing = false;
        for(int i = 0; i < A.length - 1; i++) {
            int current = A[i];
            int next = A[i + 1];
            int compare = Integer.compare(current, next);
            if(compare > 0) decreasing = true;
            else if(compare < 0) increasing = true;
        }
        return !(increasing && decreasing);
    }
}
