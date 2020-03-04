package com.vc.medium;

import java.util.*;

class L40 {
    private List<List<Integer>> res;
    private int target;
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(this.candidates);
        helper(0, 0, new boolean[candidates.length], new ArrayList<Integer>());
        return res;
    }

    private void helper(int index, int current, boolean[] visited, List<Integer> list) {
        if(current > target) return;

        if(current == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(visited[i]) continue;
            if(i > 0 && candidates[i - 1] == candidates[i] && !visited[i - 1]) continue;

            visited[i] = true;
            list.add(candidates[i]);
            helper(i + 1, current + candidates[i], visited, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
