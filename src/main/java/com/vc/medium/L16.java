package com.vc.medium;

import java.util.Arrays;

class L16 {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        //for(Integer i: arr) System.out.print(i+", ");
        //System.out.println("\nStarting.....");
        int closest = Integer.MAX_VALUE;
        int ans = 0;
        for(int f = 0; f < arr.length - 2; f++) {
            int s = f + 1;
            int t = arr.length - 1;
            int first = arr[f];
            while(s < t) {
                int second = arr[s];
                int third = arr[t];

                int sum = first + second + third;

                //System.out.println("first: "+first+" second: "+second+" third: "+third+" sum: "+sum);

                if(sum == target) return sum;

                else if(target - sum > 0) s++;
                else if(target - sum < 0) t--;

                if(closest > Math.abs(sum - target)) {
                    closest = Math.abs(sum - target);
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
