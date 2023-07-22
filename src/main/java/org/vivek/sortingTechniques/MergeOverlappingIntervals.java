package org.vivek.sortingTechniques;

import java.util.Arrays;
import java.util.Comparator;

//the problem of overlapping the merged intervals.
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        Interval arr[] = { new Interval(5,10),new Interval(3,15),new Interval(18,30), new Interval(2,7) };
        int n = arr.length;
        mergeIntervals(arr, n);
    }
    private static void mergeIntervals(Interval[] arr, int n) {
        // First, sort the array based on the start time using Arrays.sort()
        Arrays.sort(arr, Comparator.comparingInt(interval -> interval.start));
        int res = 0;
        for(int i = 1; i < n; i++){
            if(arr[res].end > arr[i].start){
                arr[res].start = Math.min(arr[res].start, arr[i].start);
                arr[res].end = Math.max(arr[res].end, arr[i].end);
            }
            else{
                res++;
                arr[res] = arr[i];
            }
        }
        for (int i = 0; i <= res; i++)  
            System.out.print(  "[" + arr[i].start + ", " + arr[i].end + "] ");  
    }
    static class Interval{
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
