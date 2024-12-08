// https://www.geeksforgeeks.org/problems/overlapping-intervals--170633/1
public class POTD_OverlappingIntervals {
    public List<int[]> mergeOverlap(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return merged;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } 
            else {
                merged.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        merged.add(currentInterval);
        return merged;
    }
}
