package com.vc.medium;

class L261 {
    public boolean validTree(int n, int[][] edges) {
        if(n != edges.length + 1) return false;

        int[] parentArr = new int[n];
        for(int i = 0; i < parentArr.length; i++) parentArr[i] = i;

        boolean multipleParent = false;
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];

            int fromParent = find(from, parentArr);
            int toParent = find(to, parentArr);

            if(toParent == fromParent) return false;     //Tree has a cycle
            if(toParent != to) {                        //Tree has multiple parent, other than root
                if(multipleParent) return false;
                else multipleParent = true;
            }

            parentArr[toParent] = fromParent;
        }
        return true;
    }

    private int find(int x, int[] parentArr) {
        if(x == parentArr[x]) return x;
        return parentArr[x] = find(parentArr[x], parentArr);
    }
}
