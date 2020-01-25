package com.vc.medium;

class L845 {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i = 1; i < n; i++) {
            if(arr[i - 1] < arr[i]) left[i] = 1;
        }

        for(int i = n - 2; i >= 0; i--) {
            if(arr[i + 1] < arr[i]) right[i] = 1;
        }

//         System.out.println("\nLeft: ");
//         for(int i = 0; i < arr.length; i++) {
//             System.out.print(left[i]+" ");
//         }

//         System.out.println("\nRight: ");
//         for(int j = 0; j < arr.length; j++) {
//             System.out.print(right[j]+" ");
//         }

        int[] total = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            total[i] = left[i] + right[i];
        }

        // System.out.println("\nTotal: ");
        // for(int j = 0; j < arr.length; j++) {
        //     System.out.print(total[j]+" ");
        // }

        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            if(total[i] == 2) {
                int l = i;
                while(l - 1 >= 0 && arr[l - 1] < arr[l]) l--;

                int r = i;
                while(r + 1 < arr.length && arr[r + 1] < arr[r]) r++;

                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}
