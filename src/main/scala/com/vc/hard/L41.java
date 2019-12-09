package com.vc.hard;

class L41 {
    public int firstMissingPositive(int[] arr) {
        //push all the negative numbers to the end
        int k = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                swap(arr, i, ++k);
            }
        }

        //print array
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

        //negate all the indexes with positive numbers
        int l = 0;
        while(l <= k) {
            int index = Math.abs(arr[l]) - 1;
            if(index <= k && arr[index] > 0) arr[index] = -1 * arr[index];
            l++;
        }

        //print array
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

        // return first non-negative number
        l = 0;
        while(l <= k) {
            if(arr[l] > 0) return l + 1;
            l++;
        }

        return Math.min(k + 1, arr.length) + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
