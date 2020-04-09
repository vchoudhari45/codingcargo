package com.vc.medium;

import java.util.*;

class L636 {
    class Entry {
        int functionId;
        int time;
        boolean isStart;

        Entry(int functionId, int time, boolean isStart) {
            this.functionId = functionId;
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public String toString() {
            return "FunctionId: "+functionId+" Time: "+time+" isStart: "+isStart;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int res[] = new int[n];

        Stack<Entry> st = new Stack<>();
        int prevTime = 0;
        for(int i = 0; i < logs.size(); i++) {
            String[] log = logs.get(i).split(":");
            //System.out.println(Arrays.toString(log));
            Entry e = new Entry(Integer.parseInt(log[0]), Integer.parseInt(log[2]), log[1].equals("start"));

            if(e.isStart) {
                if(!st.isEmpty()) res[st.peek().functionId] += (e.time - prevTime);
                st.push(e);
                prevTime = e.time;
            }
            else {
                res[e.functionId] += (e.time + 1 - prevTime);
                prevTime = e.time + 1;
                st.pop();
            }
            //System.out.println(e+" prevTime: "+prevTime);
            //System.out.println(Arrays.toString(res));
        }
        return res;
    }
}
