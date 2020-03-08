package com.vc.medium;

class L1306 {
    private int[] arr;
    private boolean[] visited;
    private int n = 0;

    public boolean canReach(int[] arr, int start) {
        if(arr == null || arr.length == 0) return false;

        this.arr = arr;
        this.n = arr.length;
        this.visited = new boolean[n];

        return canReach(start);
    }

    private boolean canReach(int start) {
        if(arr[start] == 0) return true;

        if(visited[start]) return false;

        visited[start] = true;
        boolean forward  = (start + arr[start] < n && canReach(start + arr[start]));
        boolean backward = (start - arr[start] >=0 && canReach(start - arr[start]));

        return forward || backward;
    }
}
