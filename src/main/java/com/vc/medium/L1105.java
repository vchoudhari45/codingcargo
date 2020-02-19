package com.vc.medium;

import java.util.HashMap;

class L1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return solve(books, shelfWidth, 0, memo);
    }

    private int solve(int[][] books, int shelfWidth, int index, HashMap<Integer, Integer> memo) {
        if(index >= books.length) return 0;

        if(memo.containsKey(index)) return memo.get(index);

        int globalMin = Integer.MAX_VALUE;
        int layerHeight = 0, totalWidth = 0;
        for(int i = index; i < books.length; i++) {
            int bookWidth = books[i][0], bookHeight = books[i][1];

            if (totalWidth + bookWidth > shelfWidth) break; // current layer is full

            layerHeight = Math.max(layerHeight, bookHeight);
            totalWidth += bookWidth;

            int subProblem = solve(books, shelfWidth, i + 1, memo);
            globalMin = Math.min(globalMin, layerHeight + subProblem);
        }

        memo.put(index, globalMin);
        return globalMin;
    }
}