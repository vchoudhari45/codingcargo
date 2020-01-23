package com.vc.medium;

import com.vc.hard.TreeNode;

import java.util.*;

class L987 {

    class Entry {
        int index = 0;
        int val = 0;

        public Entry(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    class EntryComparator implements Comparator<Entry> {
        public int compare(Entry e1, Entry e2) {
            int cmp = Integer.compare(e1.index, e2.index);
            if(cmp == 0) cmp = Integer.compare(e1.val, e2.val);
            return cmp;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<Entry>> map = new TreeMap<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        solve(root, 0, 0, map);
        for(Map.Entry<Integer, PriorityQueue<Entry>> entry: map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Entry> pq = entry.getValue();
            while(!pq.isEmpty()) {
                list.add(pq.poll().val);
            }
            res.add(list);
        }
        return res;
    }

    private void solve(TreeNode root, int x, int y, TreeMap<Integer, PriorityQueue<Entry>> map) {
        if(root == null) return;

        PriorityQueue<Entry> list = map.getOrDefault(x, new PriorityQueue<Entry>(new EntryComparator()));
        list.add(new Entry(y, root.val));
        map.put(x, list);

        solve(root.left, x - 1, y + 1, map);
        solve(root.right, x + 1, y + 1, map);
    }
}
