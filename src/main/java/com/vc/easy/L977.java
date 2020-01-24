package com.vc.easy;

class L977 {
    public int[] sortedSquares(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        int[] res = new int[arr.length];
        int index = hi;
        while(lo <= hi) {
            int le = Math.abs(arr[lo]);
            int he = Math.abs(arr[hi]);
            if(le > he) {
                res[index--] = (int)Math.pow(le, 2);
                lo++;
            }
            else {
                res[index--] = (int)Math.pow(he, 2);
                hi--;
            }
        }
        return res;
    }
}
