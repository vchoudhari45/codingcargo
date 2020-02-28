package com.vc.medium;

import java.util.*;

class L78 {
    private int n = 0;
    private boolean[] visited;
    private List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] arr) {
        this.n = arr.length;
        visited = new boolean[n];
        res = new ArrayList<>();
        solve(0, new ArrayList<Integer>());
        return res;
    }

    private void solve(int index, List<Integer> list) {
        res.add(new ArrayList<>(list));

        for(int i = index; i < n; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            list.add(i + 1);

            solve(i, list);

            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
