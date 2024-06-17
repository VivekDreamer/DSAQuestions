// https://www.geeksforgeeks.org/problems/check-if-two-line-segments-intersect0017/1
class POTD_CheckIfTwoLineSegmentsIntersect {
    String doIntersect(int p1[], int q1[], int p2[], int q2[]) {
         // Calculate slopes of the lines
        double m1 = (double)(q1[1] - p1[1]) / (double)(q1[0] - p1[0]);
        double m2 = (double)(q2[1] - p2[1]) / (double)(q2[0] - p2[0]);
        
        // If slopes are equal, lines are parallel and do not intersect
        if (m1 == m2) {
            return "false";
        }
        
        // Check on which side of line segment p1-q1 the points p2 and q2 lie
        boolean chk211 = (p2[1] - p1[1] - m1 * (p2[0] - p1[0])) > 0;
        boolean chk212 = (q2[1] - p1[1] - m1 * (q2[0] - p1[0])) > 0;
        
        // Check on which side of line segment p2-q2 the points p1 and q1 lie
        boolean chk121 = (p1[1] - p2[1] - m2 * (p1[0] - p2[0])) > 0;
        boolean chk122 = (q1[1] - p2[1] - m2 * (q1[0] - p2[0])) > 0;
        
        // If both points p2 and q2 lie on the same side of p1-q1, and both points p1 and q1 lie on the same side of p2-q2, the segments do not intersect
        if ((chk211 == chk212) || (chk121 == chk122)) {
            return "false";
        }
        
        // Otherwise, the segments intersect
        return "true";
    }
}
