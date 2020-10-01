package com.vc.hard;

class SelfCrossing {
    public boolean isSelfCrossing(int[] x) {
        if(x == null) return false;
        if(x.length <= 3) return false;

        for(int i = 3; i < x.length; i++) {
            int up = x[i - 3];
            int left = x[i - 2];
            int down = x[i - 1];
            int right = x[i];

            //Case 1: Fourth line crosses the first line
            if(up >= down && right >= left) return true;

            int upAgain = 0;
            if(i >= 4) {
                up = x[i - 4];
                left = x[i - 3];
                down = x[i - 2];
                right = x[i - 1];
                upAgain = x[i];

                //case 2: Fifth line meets first line
                if(up + upAgain >= down && left == right) return true;
            }

            int leftAgain = 0;
            if(i >= 5) {
                up = x[i - 5];
                left = x[i - 4];
                down = x[i - 3];
                right = x[i - 2];
                upAgain = x[i - 1];
                leftAgain = x[i];

                //case 3: Sixth line meets first line
                if(right >= left && leftAgain + left >= right && upAgain + up >= down && upAgain <= down) return true;
            }
        }
        return false;
    }
}