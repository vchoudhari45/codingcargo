package com.vc.medium;

class L47 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        solve(new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }

    private void solve(List<Integer> list, int[] arr, boolean[] visited) {
        if(list.size() == arr.length) {
            res.add(new ArrayList<>(list));
        }

        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            if(i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            list.add(arr[i]);
            solve(list, arr, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
