package com.vc.hard;

import java.util.*;

class Element {
    int row;
    int col;
    int val;

    public Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
class L632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> a.val - b.val);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.size(); i++) {
            Element e = new Element(i, 0, nums.get(i).get(0));
            max = Math.max(max, nums.get(i).get(0));
            pq.offer(e);
        }

        int start = -1;
        int end = -1;
        int range = Integer.MAX_VALUE;
        while(pq.size() == nums.size()) {
            Element current = pq.poll();

            if(max - current.val < range) {
                range = max - current.val;
                end = max;
                start = current.val;
            }

            if(current.col + 1 < nums.get(current.row).size()) {
                Element newElement = new Element(current.row,
                        current.col + 1,
                        nums.get(current.row).get(current.col + 1));
                pq.offer(newElement);
                max = Math.max(max, newElement.val);
            }
        }
        return new int[]{start, end};
    }
}
