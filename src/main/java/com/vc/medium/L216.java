package com.vc.medium;

import java.util.*;

class L216 {

    private List<List<Integer>> res;
    private boolean[] visited;
    private int k, n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.res = new ArrayList<>();
        this.visited = new boolean[9];
        this.k = k;
        this.n = n;
        helper(0, 0, new ArrayList<>());
        return res;
    }

    private void helper(int index, int current, List<Integer> list) {
        if(list.size() == k) {
            if(current == n) res.add(new ArrayList<>(list));
        }

        for(int i = index; i < visited.length; i++) {
            if(visited[i]) continue;

            list.add(i + 1);
            visited[i] = true;
            helper(i, current + i + 1, list);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
