package com.vc.medium;

class L75 {
    public void sortColors(int[] arr) {
        int r = 0;
        int w = 0;
        int b = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) r++;
            else if(arr[i] == 1) w++;
            else b++;
        }
        for(int i = 0; i < arr.length; i++) {
            if(r-- > 0) arr[i] = 0;
            else if(w-- > 0) arr[i] = 1;
            else arr[i] = 2;
        }
    }
}
