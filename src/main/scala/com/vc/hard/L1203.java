package com.vc.hard;

import java.util.*;

class L1203 {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, Set<Integer>> itemGraph = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> itemIndegree = new HashMap<Integer, Integer>();

        Map<Integer, Set<Integer>> groupGraph = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> groupIndegree = new HashMap<Integer, Integer>();

        for(int i = 0; i < beforeItems.size(); i++) {
            int groupAfterItem = group[i];
            int groupIndegreeValue = groupIndegree.getOrDefault(groupAfterItem, 0);

            int itemIndegreeValue = itemIndegree.getOrDefault(i, 0);
            for(Integer beforeItem: beforeItems.get(i)) {
                itemIndegreeValue++;

                Set<Integer> set = itemGraph.getOrDefault(beforeItem, new HashSet<Integer>());
                set.add(i);
                itemGraph.put(beforeItem, set);

                int groupBeforeItem = group[beforeItem];
                if(groupBeforeItem != groupAfterItem) {
                    Set<Integer> setGroup = groupGraph.getOrDefault(groupBeforeItem,
                            new HashSet<Integer>());
                    if(!setGroup.contains(groupAfterItem)) {
                        groupIndegreeValue++;
                        setGroup.add(groupAfterItem);
                    }
                    groupGraph.put(groupBeforeItem, setGroup);
                }
            }
            itemIndegree.put(i, itemIndegreeValue);
            groupIndegree.put(groupAfterItem, groupIndegreeValue);
        }

//         System.out.println("=======================================");
//         printMap(itemGraph);
//         System.out.println("=======================================");
//         printMap(groupGraph);

//         System.out.println("=======================================");
//         printMapIndegree(itemIndegree);
//         System.out.println("=======================================");
        printMapIndegree(groupIndegree);

        List<Integer> groupOrdering = topologicalSorting(groupGraph, groupIndegree, groupIndegree.size());
        List<Integer> itemOrdering = topologicalSorting(itemGraph, itemIndegree, n);

//         System.out.println(itemOrdering);
//         System.out.println(groupOrdering);

        if(groupOrdering.size() == 0 || itemOrdering.size() == 0) return new int[]{};

        Map<Integer, List<Integer>> groupToItem = new HashMap();
        for(Integer item: itemOrdering) {
            int g = group[item];
            List<Integer> list = groupToItem.getOrDefault(g, new ArrayList<Integer>());
            list.add(item);
            groupToItem.put(g, list);
        }


        int[] res = new int[n];
        int i = 0;
        for(Integer g: groupOrdering) {
            for(Integer item: groupToItem.get(g)) {
                res[i++] = item;
            }
        }
        return res;
    }

    private void printMap(Map<Integer, Set<Integer>> map) {
        for(Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println(" => "+entry.getValue());
        }
    }

    private void printMapIndegree(Map<Integer, Integer> map) {
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println(" => "+entry.getValue());
        }
    }

    private List<Integer> topologicalSorting(Map<Integer, Set<Integer>> graph,
                                             Map<Integer, Integer> indegree,
                                             int count) {
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> res = new ArrayList<Integer>();

        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if(entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }

        while(!q.isEmpty()) {
            int beforeItem = q.poll();
            res.add(beforeItem);
            if(graph.containsKey(beforeItem)) {
                for(Integer afterItem: graph.get(beforeItem)) {
                    if(indegree.containsKey(afterItem)) {
                        indegree.put(afterItem, indegree.get(afterItem) - 1);
                        if(indegree.get(afterItem) == 0) {
                            q.offer(afterItem);
                        }
                    }
                }
            }
        }

        //System.out.println("Printing from topo "+res);

        if(res.size() == count) return res;
        else return new ArrayList<Integer>();
    }
}