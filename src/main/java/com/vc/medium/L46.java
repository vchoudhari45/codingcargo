package com.vc.medium;

import java.util.*;

class L46 {
    private List<List<Integer>> res;
    private boolean[] visited;
    private int n;
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList<>();
        this.n = nums.length;
        this.visited = new boolean[n];
        this.nums = nums;
        solve(new ArrayList<Integer>());
        return res;
    }

    private void solve(List<Integer> list) {
        if(list.size() == n) res.add(new ArrayList<>(list));
        else {
            for(int i = 0; i < n; i++) {
                if(visited[i]) continue;

                visited[i] = true;
                list.add(nums[i]);
                solve(list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
