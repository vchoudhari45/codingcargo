package com.vc.medium;

class L370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];

        for(int[] update: updates) {
            int startIndex = update[0];
            int endIndex = update[1];
            int inc = update[2];

            arr[startIndex] += inc;

            if(endIndex + 1 < length) arr[endIndex + 1] -= inc;
        }

        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += arr[i];
            arr[i] = sum;
        }
        return arr;
    }
}
