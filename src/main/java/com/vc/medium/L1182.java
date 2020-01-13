package com.vc.medium;

import java.util.*;

class L1182 {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < colors.length; i++) {
            int color = colors[i];
            TreeSet<Integer> indexes = map.getOrDefault(color, new TreeSet<Integer>());
            indexes.add(i);
            map.put(color, indexes);
        }
        //System.out.println(map);

        List<Integer> list = new ArrayList<>();
        for(int[] query: queries) {
            int index = query[0];
            int color = query[1];

            if(!map.containsKey(color)) {
                list.add(-1);
            }
            else {
                TreeSet<Integer> set = map.get(color);
                if(set.contains(index)) list.add(0);
                else {
                    Integer below = set.floor(index);
                    Integer above = set.ceiling(index);
                    //System.out.println("Searching for color: "+color+" in indexes: "+set+" around index: "+index+" above: "+above+" below: "+below);

                    if(below != null && above != null) {
                        int db = Math.abs(index - below);
                        int da = Math.abs(above - index);
                        if(da > db) list.add(Math.abs(below - index));
                        else list.add(Math.abs(index - above));
                    }
                    else if(below == null && above == null) list.add(-1);
                    else if(below == null) list.add(Math.abs(index - above));
                    else list.add(Math.abs(index - below));
                }
            }
        }
        return list;
    }
}
