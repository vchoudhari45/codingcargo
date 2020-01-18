package com.vc.medium;

import java.util.*;

class L220 {
    public boolean containsNearbyAlmostDuplicate(int[] arr, int k, int t) {
        TreeSet<Long> set = new TreeSet<Long>();
        for(int i = 0; i < arr.length; i++) {
            long element = arr[i];

            Long floor = set.floor(element + t);
            Long ceiling = set.ceiling(element - t);
            if ((floor != null && floor >= arr[i]) || (ceiling != null && ceiling <= arr[i]))
                return true;

            set.add(element);
            if(i >= k) set.remove((long)arr[i - k]);
        }
        return false;
    }
}
