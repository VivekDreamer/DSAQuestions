package org.vivek.allCategoriesQustions.binarySearch;

import java.util.Arrays;

// You are given ‘N’ roses and you are also given an array ‘arr’  where ‘arr[i]’  denotes that the ‘ith’ rose will bloom on the ‘arr[i]th’ day.
// You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly ‘k’ adjacent bloomed roses to make a single bouquet.
// Find the minimum number of days required to make at least ‘m’ bouquets each containing ‘k’ roses. Return -1 if it is not possible.
public class MinimumDaysToMakeMBouquets {
    //brute force approach
    public static int roseGarden(int[] arr, int k, int m){
        int n = arr.length;
        if(k * m > n) return -1; //impossible case
        int mini = Arrays.stream(arr).min().orElseThrow();
        int maxi = Arrays.stream(arr).max().orElseThrow();
        for(int i = mini; i <= maxi; i++){
            if(isPossible(arr,i,k,m)){
                return i;
            }
        }
        return -1;
    }

    private static boolean isPossible(int[] arr, int day, int k, int m) {
        int numberOfBookquets = 0;
        int counter = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= day) counter++;
            else{
                numberOfBookquets += (counter/k);
                counter = 0;
            }
        }
        numberOfBookquets += (counter/k);
        return numberOfBookquets >= m;
    }

    //optimal approach : binary search
    public static int roseGarden1(int[] arr, int k, int m){
        int n = arr.length;
        if(k * m > n) return -1;
        int mini = Arrays.stream(arr).max().orElseThrow();
        int maxi = Arrays.stream(arr).min().orElseThrow();
        while(mini < maxi){
            int days = mini + (maxi-mini)/2;
            if(isPossible(arr, days, k, m)){
                maxi = days-1;
            } else {
                mini = days+1;
            }
        }
        return mini;
    }
}
