package com.vc.hard;

class L330 {
    public int minPatches(int[] arr, int n) {
        //https://leetcode.com/problems/patching-array/discuss/78488/Solution-%2B-explanation
        int missingCount = 0;
        long missing = 1;
        int i = 0;
        while(missing <= n) {
            //System.out.println(arr[i]+" missing: "+missing+" count: "+missingCount);
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
