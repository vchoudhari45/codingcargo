package com.vc.medium;

import java.util.*;

class L93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;

        int n = s.length();
        for(int i = 1; i < 4 && i < n; i++) {
            String first = s.substring(0, i);
            if(!isValid(first)) continue;

            for(int j = i + 1; j < i + 4 && j < n; j++) {
                String second = s.substring(i, j);
                if(!isValid(second)) continue;

                for(int k = j + 1; k < j + 4 && k < n; k++) {
                    String third = s.substring(j, k);
                    if(!isValid(third)) continue;

                    if(n - k < 4) {
                        String fourth = s.substring(k, n);
                        if(!isValid(fourth)) continue;
                        res.add(first+"."+second+"."+third+"."+fourth);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String ipPartition) {
        if(ipPartition.charAt(0) == '0' && ipPartition.length() > 1) return false;
        int partition = Integer.parseInt(ipPartition);
        return partition >= 0 && partition <= 255;
    }
}
