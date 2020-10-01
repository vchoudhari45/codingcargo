package com.vc.hard;

class PatchingArray {
    public int minPatches(int[] arr, int n) {
        int missingCount = 0;
        long missing = 1;
        int i = 0;
        while(missing <= n) {
            if(i < arr.length && arr[i] <= missing) {
                missing += arr[i++];
            }
            else {
                missing += missing;
                missingCount++;
            }
        }
        return missingCount;
    }
}
