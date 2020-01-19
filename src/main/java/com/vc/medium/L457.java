package com.vc.medium;

class L457 {
    public boolean circularArrayLoop(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            //slow pointer
            Integer ps = i;

            //fast pointer
            Integer pf = next(arr, ps, arr[ps]);
            if(pf == null) continue;
            pf = next(arr, pf, arr[pf]);

            while(pf != null && ps != null && ps != pf) {
                ps = next(arr, ps, arr[ps]);

                pf = next(arr, pf, arr[pf]);
                if(pf == null) break;
                pf = next(arr, pf, arr[pf]);
            }

            if(ps != null && ps == pf) return true;
        }
        return false;
    }

    private Integer next(int[] arr, Integer oldIndex, Integer dir) {
        if(oldIndex == null || arr[oldIndex] * dir < 0) return null;

        Integer newIndex = oldIndex + arr[oldIndex];
        newIndex = newIndex % arr.length;
        if(newIndex < 0) newIndex += arr.length;

        if(oldIndex == newIndex || arr[newIndex] * dir < 0) return null;
        else return newIndex;
    }
}
