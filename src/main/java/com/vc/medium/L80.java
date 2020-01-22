package com.vc.medium;

class L80 {
    public int removeDuplicates(int[] arr) {
        int i = 0;
        for(int n: arr) {
            if(i < 2 || n > arr[i - 2])
                arr[i++] = n;
        }
        return i;
    }
}
