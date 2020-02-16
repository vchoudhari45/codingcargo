package com.vc.medium;

import java.util.*;

class L90 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        Arrays.sort(arr);
        solve(0, new ArrayList<Integer>(), arr, visited);
        return res;
    }

    private void solve(int index, List<Integer> list, int[] arr, boolean[] visited) {
        res.add(new ArrayList<>(list));
        for(int i = index; i < arr.length; i++) {
            if(visited[i]) continue;
            if(i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;

            list.add(arr[i]);
            visited[i] = true;
            solve(i + 1, list, arr, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
