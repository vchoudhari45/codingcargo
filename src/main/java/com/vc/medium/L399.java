package com.vc.medium;

import java.util.*;

class L399 {
    class To {
        String to;
        double value;

        To(String to, double value) {
            this.to = to;
            this.value = value;
        }

        @Override
        public String toString() {
            return to+", "+value;
        }
    }

    HashMap<String, List<To>> map = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for(int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            String f = list.get(0);
            String t = list.get(1);

            List<To> toList = map.getOrDefault(f, new ArrayList<To>());
            To to = new To(t, values[i]);
            toList.add(to);
            map.put(f, toList);

            List<To> fromList = map.getOrDefault(t, new ArrayList<To>());
            To from = new To(f, 1 / values[i]);
            fromList.add(from);
            map.put(t, fromList);
        }

        //System.out.println(map);

        double[] d = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            d[i] = dfs(from, to, new HashSet<String>());
        }
        return d;
    }

    private double dfs(String from, String target, HashSet<String> visited) {
        if(from.equals(target)) {
            if(map.containsKey(from)) return 1.0;
            else return -1.0;
        }

        if(!map.containsKey(from) || visited.contains(from)) return -1.0;

        visited.add(from);
        for(To to: map.get(from)) {
            double r = dfs(to.to, target, visited);
            if(r != -1.0) return to.value * r;
        }
        visited.remove(from);
        return -1.0;
    }
}
