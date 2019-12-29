package com.vc.hard;

import java.util.*;

class L632 {

    static class Element {
        int row;
        int col;
        int val;

        Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public String toString() {
            return "(row: "+row+" col:"+col+" val: "+val+")";
        }
    }

    public int[] smallestRange(List<List<Integer>> list) {
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>(){
            public int compare(Element e1, Element e2) {
                return Integer.valueOf(e1.val).compareTo(e2.val);
            }
        });

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size(); i++) {
            int value = list.get(i).get(0);
            Element e = new Element(i, 0, value);
            max = Math.max(max, value);
            min = Math.min(min, value);
            pq.offer(e);
        }

        int range = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while(pq.size() == list.size()) {
            //System.out.println("PriorityQueue: "+pq);
            Element e = pq.poll();
            //System.out.println("Removing: "+e+" min: "+min+" max: "+max);

            if(max - e.val < range) {
                range = max - e.val;
                min = e.val;
                start = min;
                end = max;
            }

            if(e.col + 1 < list.get(e.row).size()) {
                int value = list.get(e.row).get(e.col + 1);
                Element eNew = new Element(e.row, e.col + 1, value);
                max = Math.max(max, value);
                pq.offer(eNew);
            }
        }
        return new int[]{start, end};
    }
}