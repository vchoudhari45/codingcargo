package com.vc.hard;

import java.util.*;

class L480 {
    public double[] medianSlidingWindow(int[] arr, int k) {
        PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer x, Integer y) {
                return y.compareTo(x);
            }
        });

        PriorityQueue<Integer> right = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer x, Integer y) {
                return x.compareTo(y);
            }
        });

        int n = arr.length;
        if(n == 0) return new double[0];

        double[] res = new double[n - k + 1];
        int index = 0;
        int i = 0;
        for(index = 0; index < k; index++) {
            add(left, right, arr[index]);
        }
        res[i++] = getMedian(left, right);

        for(index = index; index < n; index++) {
            if(!left.remove(arr[index - k])) right.remove(arr[index - k]);
            add(left, right, arr[index]);
            res[i++] = getMedian(left, right);
        }
        return res;
    }

    private void add(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int element) {
        //System.out.println("====================================================================");
        //System.out.println("Before adding element: "+element+" left: "+left+" right: "+right);
        if(left.size() > right.size()) {
            left.offer(element);
            right.offer(left.poll());
        }
        else {
            right.offer(element);
            left.offer(right.poll());
        }
        //System.out.println("After adding element: "+element+" left: "+left+" right: "+right);
    }
    private double getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if(left.size() > right.size()) {
            //System.out.println("left: "+left+" right: "+right+" Returning: "+left.peek());
            return (double) left.peek();
        }
        else {
            double d = (double) (((double)left.peek() + (double)right.peek()) / (double)2.0);
            //System.out.println("left: "+left+" right: "+right+" Returning: "+d);
            return d;
        }
    }
}