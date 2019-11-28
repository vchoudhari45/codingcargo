package com.vc.hard;

import java.util.*;

class L480 {
    PriorityQueue<Integer> left = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));
    PriorityQueue<Integer> right = new PriorityQueue<Integer>((a, b) -> a.compareTo(b));

    public double[] medianSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        double[] res = new double[n - k + 1];

        if(n == 0) return new double[0];
        for(int i = 0; i < k; i++) {
            //System.out.println("left: "+left+" right: "+right);
            if(left.size() <= right.size()) {
                //System.out.println("Adding "+arr[i]+" to right first");
                right.offer(arr[i]);
                left.offer(right.poll());
            }
            else {
                //System.out.println("Adding "+arr[i]+" to left first");
                left.offer(arr[i]);
                right.offer(left.poll());
            }
        }

        int index = 0;
        for(int i = k; i < n; i++) {
            res[index] = getMedian();
            //System.out.println("left: "+left+" right: "+right+" Median("+index+"): "+res[index]);
            index++;
            if(!left.remove(arr[i - k])) right.remove(arr[i - k]);
            if(left.size() <= right.size()) {
                right.offer(arr[i]);
                left.offer(right.poll());
            }
            else {
                left.offer(arr[i]);
                right.offer(left.poll());
            }
        }
        res[res.length - 1] = getMedian();
        return res;
    }

    private double getMedian() {
        if(left.size() == right.size()) {
            return ((double)left.peek() + (double)right.peek()) / 2.0D;
        }
        else return (double)left.peek();
    }
}
