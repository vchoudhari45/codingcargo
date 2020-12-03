package com.vc.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MaximumNumberOfVisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> angles = new ArrayList<>();
        int locationX = location.get(0);
        int locationY = location.get(1);
        int overlap = 0;
        for(List<Integer> point: points) {
            int pointX = point.get(0);
            int pointY = point.get(1);

            if(pointX == locationX && pointY == locationY) overlap++;
            else {
                int dx = pointX - locationX;
                int dy = pointY - locationY;

                double angleForPoint = Math.atan2(dy, dx) * (180 / Math.PI);
                angles.add(angleForPoint);
            }
        }

        Collections.sort(angles);

        /**
            Handle a case where rotation completes 360 degree
            Because of which few points which are on the edge of 360 and before the 360, Will come in the sliding window of points of which are at the start of the rotation and which as angle of 0 degree
         */
        List<Double> anglesCompleteCircle = new ArrayList<>(angles);
        for(Double a: angles) anglesCompleteCircle.add(a + 360);

        //Sliding window over angles to see if they are within field of view of rotation
        int end = 1, start = 0, res = 0;
        while(end < anglesCompleteCircle.size()) {
            while(anglesCompleteCircle.get(end) - anglesCompleteCircle.get(start) > angle) {
                start++;
            }
            res = Math.max(res,  end - start + 1);
            end++;
        }

        return overlap + res;
    }
}