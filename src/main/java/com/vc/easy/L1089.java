package com.vc.easy;

class L1089 {
    public void duplicateZeros(int[] arr) {
        int countZeros = 0;
        for(int i = 0; i < arr.length; i++) if(arr[i] == 0) countZeros++;

        int original = arr.length - 1;
        int length = original + countZeros;

        while(original < length) {
            if(length < arr.length) arr[length] = arr[original];
            if(arr[original] == 0) {
                if(length < arr.length) arr[length] = arr[original];
                length--;
                if(length < arr.length) arr[length] = arr[original];
            }
            original--;
            length--;
        }
    }
}
