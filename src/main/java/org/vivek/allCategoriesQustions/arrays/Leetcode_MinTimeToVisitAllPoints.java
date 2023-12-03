package org.vivek.allCategoriesQustions.arrays;

// https://leetcode.com/problems/minimum-time-visiting-all-points/
public class Leetcode_MinTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int steps = 0;
        for(int i = 0; i < n-1; i++){
            //i to i+1
            int x1 = points[i][0];
            int y1 = points[i][1];
            int x2 = points[i+1][0];
            int y2 = points[i+1][1];
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);
            steps += (Math.min(dx,dy) + Math.abs(dy-dx));
        }
        return steps;
    }
}
