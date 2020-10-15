package com.vc.hard;

import java.util.*;

class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null) return null;
        if(nums.length == 0) return new double[0];

        TreeSet<Integer> left = new TreeSet<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                int cmp = Integer.compare(nums[i1], nums[i2]);
                return cmp == 0 ? Integer.compare(i1, i2) : cmp;
            }
        });

        TreeSet<Integer> right = new TreeSet<>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                int cmp = Integer.compare(nums[i2], nums[i1]);
                return cmp == 0 ? Integer.compare(i1, i2): cmp;
            }
        });

        int n = nums.length;
        for(int i = 0; i < k; i++) {
            add(left, right, i);
        }

        double[] res = new double[n - k + 1];
        for(int i = k; i < n; i++) {
            res[i - k] = getMedian(left, right, nums);
            left.remove(i - k);
            right.remove(i - k);
            add(left, right, i);
        }

        res[res.length - 1] = getMedian(left, right, nums);
        return res;
    }

    private void add(TreeSet<Integer> left, TreeSet<Integer> right, int index) {
        if(left.size() > right.size()) {
            left.add(index);
            right.add(left.pollFirst());
        }
        else {
            right.add(index);
            left.add(right.pollFirst());
        }
    }

    private double getMedian(TreeSet<Integer> left, TreeSet<Integer> right, int[] nums) {
        if(left.size() > right.size()) {
            return nums[left.first()];
        }
        else {
            double d = (double)nums[left.first()] + (double)nums[right.first()];
            return d / 2.0;
        }
    }
}