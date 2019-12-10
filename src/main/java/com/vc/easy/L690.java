package com.vc.easy;

import java.util.*;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}

class L690 {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(Employee e: employees) {
            map.put(e.id, e);
        }
        int res = 0;
        Stack<Integer> s = new Stack<Integer>();
        s.push(id);
        while(!s.isEmpty()) {
            int eid = s.pop();
            Employee e = map.get(eid);
            res += e.importance;
            if(e.subordinates != null) {
                for(Integer sub: e.subordinates) {
                    s.push(sub);
                }
            }
        }
        return res;
    }
}

