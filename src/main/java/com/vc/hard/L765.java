package com.vc.hard;

import java.util.*;

class L765 {
    public int minSwapsCouples(int[] row) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }

        int ans = 0;
        for(int i = 0; i < row.length - 1; i++) {
            int partner = row[i];
            int secondPartner = partner % 2 == 0 ? partner + 1 : partner - 1;
            if(map.get(secondPartner) != i + 1) {
                int wrongPartner = row[i + 1];
                int wrongPartnerIndex = map.get(wrongPartner);

                int secondPartnerIndex = map.get(secondPartner);

                map.put(wrongPartner, secondPartnerIndex);
                map.put(secondPartner, i + 1);

                row[i + 1] = secondPartner;
                row[secondPartnerIndex] = wrongPartner;

                ans++;
            }
            i++;
        }

        return ans;
    }
}
