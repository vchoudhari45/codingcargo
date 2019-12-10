package com.vc.hard;

import java.util.*;

class L1183 {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int[][] subMatrix = new int[sideLength][sideLength];

        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                subMatrix[i % sideLength][j % sideLength]++;
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });

        for(int i = 0; i < sideLength; i++) {
            for(int j = 0; j < sideLength; j++) {
                System.out.print(subMatrix[i][j]+" ");
                pq.offer(subMatrix[i][j]);
            }
            System.out.println();
        }

        int total = 0;
        for(int i = 0; i < maxOnes; i++) {
            int poll = pq.poll();
            //System.out.println("Poll  -> "+poll);
            total += poll;
        }
        return total;
    }
}
