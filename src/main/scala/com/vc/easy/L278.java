package com.vc.easy;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class L278 {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(!isBadVersion(mid)) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public boolean isBadVersion(int mid) {
        return true;
    }
}
