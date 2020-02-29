package com.vc.medium;

class L1151 {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;

        int countOnes = 0;
        for(int i = 0; i < arr.length; i++) if(arr[i] == 1) countOnes++;

        int countZeros = 0;
        for(int i = 0; i < countOnes; i++) {
            if(arr[i] == 0) countZeros++;
        }

        int min = countZeros;
        for(int i = countOnes; i < n; i++) {
            if(arr[i] == 0) countZeros++;
            if(arr[i - countOnes] == 0) countZeros--;
            min = Math.min(min, countZeros);
        }

        return min;
    }
}
