package com.vc.medium;

class L1300 {
    public int findBestValue(int[] arr, int target) {
        int lo = 1;
        int hi = 100000;
        int mid = 0;
        int sum = 0;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            sum = 0;
            for(int i = 0; i < arr.length; i++) sum += Math.min(arr[i], mid);
            if(sum < target) lo = mid + 1;
            else hi = mid;
        }
        int lowerSum = 0;
        for(int i = 0; i < arr.length; i++) lowerSum += Math.min(arr[i], mid - 1);

        int higherSum = 0;
        for(int i = 0; i < arr.length; i++) higherSum += Math.min(arr[i], mid + 1);

        int lower = Math.abs(lowerSum - target);
        int higher = Math.abs(higherSum - target);
        int s = Math.abs(sum - target);

        //System.out.println("lower: "+lowerSum+" higher: "+higherSum+" sum: "+sum+" mid: "+mid);
        if(lower < higher) {
            if(lower < s) return mid - 1;
            else return mid;
        }
        else {
            if(higher < s) return mid + 1;
            else return mid;
        }
    }
}
