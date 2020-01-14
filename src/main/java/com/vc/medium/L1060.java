package com.vc.medium;

class L1060 {
    public int missingElement(int[] arr, int k) {
        int n = arr.length;

        if(k > missingCount(n - 1, arr))
            return arr[n - 1] + k - missingCount(n - 1, arr);

        int index = 0;
        while(missingCount(index, arr) < k) index++;

        return arr[index - 1] + k - missingCount(index - 1, arr);
    }

    private int missingCount(int index, int[] arr) {
        return arr[index] - arr[0] - index;
    }
}
