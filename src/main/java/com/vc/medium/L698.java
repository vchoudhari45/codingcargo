package com.vc.medium;

class L698 {
    boolean found = false;
    public boolean canPartitionKSubsets(int[] arr, int k) {
        int n = arr.length;
        if(n < k) return false;

        int sum = 0;
        for(int i = 0; i < n; i++) sum += arr[i];
        if(sum % k != 0) return false;

        sum = sum / k;
        boolean[] visited = new boolean[n];
        return solve(arr, visited, 0, k, 0, sum);
    }

    private boolean solve(int[] arr, boolean[] visited, int index, int k, int current, int required) {
        if(found) return true;
        else if(current > required) return false;
        else if(current == required && k == 1) {
            found = true;
            return true;
        }
        else if(current == required) {
            if(solve(arr, visited, 0, k - 1, 0, required)) {
                found = true;
                return true;
            }
            else return false;
        }
        else {
            for(int i = index; i < arr.length; i++) {
                if(visited[i]) continue;

                visited[i] = true;
                if(solve(arr, visited, i + 1, k, current + arr[i], required)) {
                    found = true;
                    return true;
                }
                visited[i] = false;
            }
            return false;
        }
    }
}
