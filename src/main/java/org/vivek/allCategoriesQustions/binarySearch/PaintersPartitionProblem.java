package org.vivek.allCategoriesQustions.binarySearch;

import java.util.Arrays;

// Given an array/list of length ‘N’, where the array/list represents the boards and each element of the given array/list represents the length of each board.
//  Some ‘K’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint. 
//  You are supposed to return the area of the minimum time to get this job done of painting all the ‘N’ boards under the constraint that any painter will only paint the continuous sections of boards.

public class PaintersPartitionProblem {
    // Minimum possible answer: We will get the minimum answer when we give n boards of the array to n painters(i.e. Each painter will be allocated 1 board). 
    // Now, in this case, the minimum time required to paint all the boards will be the maximum element in the array. So, the minimum possible answer is max(arr[]).
    // Maximum possible answer: We will get the maximum answer when we give all n boards to a single painter.
    //  The total time required is the summation of array elements i.e. sum(arr[]). So, the maximum possible answer is sum(arr[]).

    // From the observations, it is clear that our answer lies in the range [max(arr[]), sum(arr[])].

    //brute force
    public static int findLargestMinDistance(int[] arr, int k){
        int low = Arrays.stream(arr).max().orElseThrow();
        int high = Arrays.stream(arr).sum();

        for(int time = low; time <= high; time++){
            if(countPainters(arr, time) <= k) return time;
        }
        return low;
    }

    private static int countPainters(int[] arr, int time) {
        int numOfPainters = 1;
        int n = arr.length;
        int paintDone = 0;
        for(int i = 0; i < n; i++){
            if(paintDone + arr[i] <= time){
                paintDone += arr[i]; // allocate board to current painter
            } else {
                paintDone = arr[i];
                numOfPainters++;
            }
        }
        return numOfPainters;
    }
    
    //optimal
    public static int findLargestMinDistanceOptimized(int[] arr, int k){
        int low = Arrays.stream(arr).max().orElseThrow();
        int high = Arrays.stream(arr).sum();
        while(low <= high){
            int time = low + (high - low)/2;
            if(countPainters(arr, time) < k){
                low = time + 1;
            } else {
                high = time - 1;
            }
        }
        return low;
    }
}
