package com.vc.hard;

import java.util.*;

class Point {
    int x;
    int y;
    int endValue;

    public Point(int x, int y, int endValue) {
        this.x = x;
        this.y = y;
        this.endValue = endValue;
    }
}

class L850 {
    public int rectangleArea(int[][] rectangles) {
        List<Point> data = new ArrayList<Point>();
        for(int[] r: rectangles) {
            int x1 = r[0];
            int y1 = r[1];

            int x2 = r[2];
            int y2 = r[3];

            /** bottom-left 1 */
            data.add(new Point(x1, y1, 1));

            /** top-left -1 */
            data.add(new Point(x1, y2, -1));

            /** bottom-right should be oppposite of bottom-left so -1*/
            data.add(new Point(x2, y1, -1));

            /** top-right should be opposite of top-left so 1 */
            data.add(new Point(x2, y2, 1));
        }

        Collections.sort(data, new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                return p1.x - p2.x;
            }
        });

        // for(Point p: data) {
        //     System.out.println(p.x+" "+p.y+" "+p.endValue);
        // }

        TreeMap<Integer, Integer> mapY = new TreeMap<Integer, Integer>();
        long preX = -1;
        long preY = -1;
        long result = 0;
        int MOD = (int)1e9 + 7;
        for(int i = 0; i < data.size(); i++) {
            Point p = data.get(i);
            mapY.put(p.y, mapY.getOrDefault(p.y, 0) + p.endValue);
            if(i == data.size() - 1 || data.get(i + 1).x > p.x) {
                if(preX > -1) {
                    result += (preY * (p.x - preX)) % MOD;
                    result %= MOD;
                }
                preX = p.x;
                preY = calcY(mapY);
            }
        }
        return (int)result;
    }

    public int calcY(TreeMap<Integer, Integer> map) {
        int result = 0;
        int count = 0;
        int pre = -1;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(count > 0) {
                result += entry.getKey() - pre;
            }
            count += entry.getValue();
            pre = entry.getKey();
        }
        return result;
    }
}