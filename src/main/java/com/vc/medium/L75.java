package com.vc.medium;

class L75 {
    public void sortColors(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        for(int i = low; i <= high;) {
            if(arr[i] == 0) {
                swap(i++, low++, arr);
            }
            else if(arr[i] == 2) {
                swap(i, high--, arr);
            }
            else i++;
        }
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
}