package com.vc.medium;

class L1011 {
    public int shipWithinDays(int[] arr, int D) {
        int lo = Integer.MIN_VALUE;
        int hi = 0;

        for(int i = 0; i < arr.length; i++) {
            lo = Math.max(arr[i], lo);
            hi += arr[i];
        }

        /**
            Minimize the maximum
         */
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            boolean isPossible = isPossible(arr, mid, D);
            //System.out.println("Mid: "+mid+" isPossible: "+isPossible);
            if(!isPossible) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    private boolean isPossible(int[] arr, int weight, int D) {
        int total = 0;
        int count = 1;
        for(int i = 0; i < arr.length; i++) {
            total += arr[i];
            if(total > weight) {
                total = arr[i];
                count++;
                if(count > D) return false;
            }
        }
        return true;
    }
}