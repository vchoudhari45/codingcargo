package com.vc.hard;

class FirstMissingPositive {
    public int firstMissingPositive(int[] arr) {

        int positiveNumberIndex = -1;
        //Since we have to return smallest missing positive number,
        //let's move all the negative number to the end
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) swap(arr, i, ++positiveNumberIndex);
        }

        //Now problem reduces to finding a missing positive number within a set of +ve numbers
        for(int i = 0; i <= positiveNumberIndex; i++) {
            int index = Math.abs(arr[i]) - 1;
            if(index <= positiveNumberIndex && arr[index] > 0) arr[index] = -1 * arr[index];
        }

        //Now number which is still positive, that number's index is missing number
        for(int i = 0; i <= positiveNumberIndex; i++) {
            if(arr[i] > 0) return i + 1;
        }

        return Math.min(positiveNumberIndex + 1, arr.length) + 1;
    }

    private void swap(int[] arr, int from, int to) {
        int element = arr[from];
        arr[from] = arr[to];
        arr[to] = element;
    }
}
