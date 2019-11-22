package com.vc.hard;

import java.util.*;

class L782 {
    public int movesToChessboard(int[][] board) {
        HashMap<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> colMap = new HashMap<Integer, Integer>();

        int n = board.length;

        for(int i = 0; i < board.length; i++) {
            String r = "";
            String c = "";
            for(int j = 0; j < board.length; j++) {
                r += board[i][j];
                c += board[j][i];
            }
            int rInt = Integer.parseInt(r, 2);
            int cInt = Integer.parseInt(c, 2);
            rowMap.put(rInt, rowMap.getOrDefault(rInt, 0) + 1);
            colMap.put(cInt, colMap.getOrDefault(cInt, 0) + 1);
        }
        //System.out.println(rowMap);
        //System.out.println(colMap);

        int res1 = analyzeCount(rowMap, n);
        if(res1 == -1) return res1;

        int res2 = analyzeCount(colMap, n);
        if(res2 == -1) return res2;

        return res1 + res2;
    }

    public int analyzeCount(Map<Integer, Integer> count, int n) {
        //If row pattern or col pattern are not equal to 2
        if(count.size() != 2) return -1;

        List<Integer> keys = new ArrayList<>(count.keySet());
        int k1 = keys.get(0);
        int k2 = keys.get(1);

        //No of ones and zeros are not equal
        if(Math.abs(count.get(k1) - count.get(k2)) > 1) return -1;

        int allOneMask = (1 << n) - 1;

        //One key should be opposite of other
        if((k1 ^ k2) != allOneMask) return -1;

        int countOneK1 = Integer.bitCount(k1 & allOneMask);
        int res = Integer.MAX_VALUE;

        if(n % 2 == 0 || countOneK1 * 2 < n)
            res = Math.min(res, Integer.bitCount(k1 ^ 0xAAAAAAAA & allOneMask) / 2);

        if(n % 2 == 0 || countOneK1 * 2 > n)
            res = Math.min(res, Integer.bitCount(k1 ^ 0x55555555 & allOneMask) / 2);

        return res;
    }
}
