package com.vc.medium;

class NumArray {

    int[] arr;
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        this.arr = nums;
        this.n = nums.length;
        tree = new int[n + 1];
        for(int i = 0; i < n; i++) {
            set(i, arr[i]);
        }
    }

    private void set(int index, int val) {
        //System.out.println("Setting Value: "+index);
        for(int i = index + 1; i <= n; i = getNext(i)) {
            //System.out.println("--> index: "+i);
            tree[i] += val;
        }
    }

    public void update(int i, int val) {
        int delta = val - arr[i];
        arr[i] = val;
        set(i, delta);
        // for(int k = 0; k <= n; k++) {
        //     System.out.print(tree[k]+" ");
        // }
    }

    private int sum(int index) {
        int sum = 0;
        //System.out.println("Getting Value: "+index);
        for(int i = index; i > 0; i = getParent(i)) {
            //System.out.println("--> index: "+i);
            sum += tree[i];
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return sum(j + 1) - sum(i);
    }

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