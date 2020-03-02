package com.vc.medium;

class L565 {
    public int arrayNesting(int[] arr) {
        if(arr == null || arr.length == 0) return 0;

        int n = arr.length, index = 0, max = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] != -1) {
                int count = nesting(arr, i);
                max = Math.max(max, count);
            }
        }
        return max;
    }

    private int nesting(int[] arr, int index) {
        int count = 0;
        while(arr[index] != -1) {
            int oldIndex = index;
            index = arr[index];
            arr[oldIndex] = -1;
            count++;
        }
        return count;
    }
}
