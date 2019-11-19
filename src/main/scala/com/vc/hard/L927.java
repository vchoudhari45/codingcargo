package com.vc.hard;

class Solution {
    public int[] threeEqualParts(int[] arr) {
        int countOnes = 0;
        for(int k = 0; k < arr.length; k++) {
            if(arr[k] == 1) countOnes++;
        }

        if(countOnes == 0) return new int[] {0, arr.length - 1};
        if(countOnes % 3 != 0) return new int[]{-1, -1};

        int eachPartitionOneCount = countOnes / 3;

        int first = getNextIndex(arr, 0);
        int second = getNextIndex(arr, getNextPartitionStart(arr, first, eachPartitionOneCount));
        int third = getNextIndex(arr, getNextPartitionStart(arr, second, eachPartitionOneCount));

        //System.out.println("First: "+first+" Second: "+second+" third: "+third);
        while(third < arr.length
                && arr[first] == arr[second]
                && arr[second] == arr[third]) {
            //System.out.println("First: "+first+" Second: "+second+" third: "+third);
            first++;
            second++;
            third++;
        }

        if(third == arr.length) return new int[] {first - 1, second};
        return new int[] {-1, -1};
    }

    private int getNextPartitionStart(int[] arr, int start, int eachPartitionOneCount) {
        int i = start;
        while(i < arr.length && eachPartitionOneCount > 0) {
            if(arr[i] == 1) eachPartitionOneCount--;
            i++;
        }
        return i;
    }
    private int getNextIndex(int[] arr, int start) {
        int i = start;
        while(i < arr.length && arr[i] != 1) i++;
        return i;
    }
}
