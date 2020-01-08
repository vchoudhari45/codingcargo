package com.vc.hard;

class L805 {
    public boolean splitArraySameAverage(int[] arr) {
        int sum = 0;
        int n = arr.length;
        if(n == 0) return true;

        for(int i = 0; i < n; i++) sum += arr[i];
        System.out.println(sum);

        /**
            sumleft / sizeleft = sumright / sizeright

            For length sizeleft
            if sumright * sizeleft % sizeright == 0
            Then problem comes down to checking if there are exist no of sizeleft elements in arr which adds up to sumleft
         */
        for(int sizeleft = 1; sizeleft < n; sizeleft++) {
            if(sum * sizeleft % n == 0) {
                int sumleft = sum * sizeleft / n;
                if(solve(arr, 0, sumleft, sizeleft, 0)) {
                    // System.out.println("sumleft: "+sumleft+
                    //                    " sizeleft: "+sizeleft+
                    //                    " sumright: "+sum+
                    //                    " sizeright: "+n);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean solve(int[] arr, int index, int sum, int size, int loop) {
        //System.out.println("checking if "+size+" elements adds up to "+sum+" starting with index: "+index);
        if(size == 0) return sum == 0;
        else {
            for(int i = index; i < arr.length; i++) {
                //System.out.println("checking if "+size+" elements adds up to "+sum+" starting with index: "+i);
                if(i > index && arr[i] == arr[i - 1]) continue;
                if(solve(arr, i + 1, sum - arr[i], size - 1, loop + 1)) return true;
            }
            return false;
        }
    }
}