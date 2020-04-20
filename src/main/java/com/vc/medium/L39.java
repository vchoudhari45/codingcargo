package com.vc.medium;

import java.util.ArrayList;
import java.util.List;

class L39 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        if(candidates.length == 0) return res;
        helper(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> list) {
        if(target < 0) return;
        if(target == 0) res.add(new ArrayList<>(list));

        for(int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, i, target - candidates[i], list);
            list.remove(list.size() - 1);
        }
    }
}
