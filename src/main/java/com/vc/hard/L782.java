package com.vc.hard;

import java.util.*;

class L782 {
    public int movesToChessboard(int[][] board) {
        int n = board.length;
        HashMap<Integer, Integer> rowMap = new HashMap<>();
        HashMap<Integer, Integer> colMap = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String col = "";
            String row = "";
            for(int j = 0; j < n; j++) {
                col += board[j][i];
                row += board[i][j];
            }
            /**
                 [
                 [0,1,1,0],
                 [0,1,1,0],
                 [1,0,0,1],
                 [1,0,0,1]
                 ]
             */
            int r = Integer.parseInt(row, 2);
            int c = Integer.parseInt(col, 2);
            rowMap.put(r, rowMap.getOrDefault(r, 0) + 1);
            colMap.put(c, colMap.getOrDefault(c, 0) + 1);
        }
        //System.out.println(rowMap);
        //System.out.println(colMap);

        int rowMove = minMove(rowMap, n);
        int colMove = minMove(colMap, n);

        if(rowMove == -1 || colMove == -1) return -1;

        else return rowMove + colMove;
    }

    private int minMove(HashMap<Integer, Integer> count, int n) {
        //If row pattern or col pattern are not equal to 2
        if(count.size() != 2) return -1;

        List<Integer> keys = new ArrayList<>(count.keySet());
        int k1 = keys.get(0);
        int k2 = keys.get(1);

        //No of ones and zeros are not equal
        if(Math.abs(count.get(k1) - count.get(k2)) > 1) return -1;

        //One key should be opposite of other
        int allOneMask = (1 << n) - 1;
        if((k1 ^ k2) != allOneMask) return -1;

        int countOneK1 = Integer.bitCount(k1);
        int res = Integer.MAX_VALUE;

        if(n % 2 == 0 || countOneK1 * 2 < n) {
            //starts with Zero
            //0xAAAAAAAA is 1 at even places
            //count numbers of even places where we don't have 1
            res = Math.min(res, Integer.bitCount(k1 ^ 0xAAAAAAAA & allOneMask) / 2);
        }

        if(n % 2 == 0 || countOneK1 * 2 > n) { //starts with One
            res = Math.min(res, Integer.bitCount(k1 ^ 0x55555555 & allOneMask) / 2);
        }

        return res;
    }
}