// https://www.geeksforgeeks.org/problems/non-overlapping-intervals/1
public class POTD_NonOverlappingIntervals {
    static int minRemoval(int intervals[][]) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int last = 0;
        int ans = 0;
         int N = intervals.length;
        for(int i =1;i<N;i++){
            if(intervals[i][0]<intervals[last][1])ans++;
              else last = i;
            }
        return ans;
    }
}
