package com.vc.medium;

import java.util.*;

class L1233 {
    public List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders, new Comparator<String>(){
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String folder: folders) {
            String[] path = folder.split("/");
            String p = "";
            boolean toBeRemoved = false;
            for(int i = 1; i < path.length; i++) {
                String k = path[i];
                p += "/"+k;
                //System.out.println(p);
                if(set.contains(p)) toBeRemoved = true;
            }
            if(!toBeRemoved) res.add(folder);
            set.add(folder);
        }
        return res;
    }
}
