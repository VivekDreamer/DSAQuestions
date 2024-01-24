package org.vivek.allCategoriesQustions.binarySearch;

import java.util.Arrays;

// You are given an array ‘arr’ of size ‘n’ which denotes the position of stalls.
// You are also given an integer ‘k’ which denotes the number of aggressive cows.
// You are given the task of assigning stalls to ‘k’ cows such that the minimum distance between any two of them is the maximum possible.
// Find the maximum possible minimum distance.
public class AggresiveCows {
    //brute force
    public static int aggresiveCows(int[] stalls, int k){
        int n = stalls.length;
        Arrays.sort(stalls);
        int limit = stalls[n-1] - stalls[0];
        for(int i = 1; i <= limit; i++){
            if(canWePlaceCows(stalls, i, k) == false){
                return i-1;
            }
        }
        return limit;
    }

    private static boolean canWePlaceCows(int[] stalls, int dist, int k) {
        int n = stalls.length;
        int countCows = 1;
        int last = stalls[0];
        for(int i = 1; i < n; i++){
            if(stalls[i] - last >= dist){
                countCows++;   //place next cow
                last = stalls[i]; //upddate the location of last cow
            }
            if(countCows >= k) return true;
        }
        return false;
    }

    //optimal 
    public static int aggresiveCowsOptimal(int[] stalls, int k){
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canWePlaceCows(stalls, mid, k)) 
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;
    }
}
