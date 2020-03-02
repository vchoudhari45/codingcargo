package com.vc.medium;

class L531 {
    public int findLonelyPixel(char[][] picture) {
        if(picture == null || picture.length == 0) return 0;

        int n = picture.length;
        int m = picture[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}
