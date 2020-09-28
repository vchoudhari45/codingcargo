package com.vc.medium;

class RangeSumQueryMutable {
    private int[] arr;
    private int[] tree;
    private int n;

    public RangeSumQueryMutable(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
        tree = new int[n + 1];
        for(int i = 0; i < n; i++) {
            set(i, arr[i]);
        }
    }

    //Add element to each of it's child
    private void set(int index, int val) {
        for(int i = index + 1; i <= n; i = getNext(i)) tree[i] += val;
    }

    public void update(int i, int val) {
        int delta = val - arr[i];
        arr[i] = val;
        set(i, delta);
    }

    private int sum(int index) {
        int sum = 0;
        for(int i = index; i > 0; i = getParent(i)) {
            sum += tree[i];
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

    /**
         Java uses two's complement to represent binary number
         Two's complement is invert all the digits and add one
         so for e.g. we have
         5 => 101
         -5 => 010 + 001 => 011

         5 & -5 should give us last set bit
         5 & -5 => 101 & 011 => 001

         And we have to remove last set bit in a number to get to it's parent
     */
    private int getParent(int x) {
        return x - (x & -x);
    }

    private int getNext(int x) {
        return x + (x & -x);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */