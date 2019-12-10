package com.vc.medium;


class ArrayReader {
    public int get(int i) {
        return i;
    }
}

public class L702 {
    public int search(ArrayReader reader, int target) {
        int hi = 1;
        while(reader.get(hi) < target) {
            hi <<= 1;
        }

        int lo = 0;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(reader.get(mid) > target) hi = mid - 1;
            else if(reader.get(mid) < target) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
