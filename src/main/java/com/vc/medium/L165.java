package com.vc.medium;

class L165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0;
        for(i = 0; i < Math.min(v1.length, v2.length); i++) {
            int v1Int = Integer.parseInt(v1[i]);
            int v2Int = Integer.parseInt(v2[i]);
            //System.out.println(v1Int+" "+v2Int);

            if(v1Int > v2Int) return 1;
            else if(v1Int < v2Int) return -1;
        }

        if(v1.length > v2.length) {
            for(int j = i; j < v1.length; j++) {
                if(Integer.parseInt(v1[j]) != 0) return 1;
            }
        }
        else {
            for(int j = i; j < v2.length; j++) {
                if(Integer.parseInt(v2[j]) != 0) return -1;
            }
        }
        return 0;
    }
}
